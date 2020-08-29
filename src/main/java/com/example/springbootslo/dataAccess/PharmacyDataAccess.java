package com.example.springbootslo.dataAccess;

import com.example.springbootslo.model.Appointment;
import com.example.springbootslo.model.Doctor;
import com.example.springbootslo.model.Patient;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component("PharmacyDAO")
public class PharmacyDataAccess implements DataAccess {

    private static List<Doctor> doctorlist = new ArrayList<>();
    private static List<Patient> patientList = new ArrayList<>();
    private static List<Appointment> appointmentList = new ArrayList<>();
    private static List<Appointment> appointmentArchive = new ArrayList<>();

    @Override
    public int addDoctor(Doctor doctor) {
        doctorlist.add(doctor);
        return 1;
    }

    @Override
    public List<Doctor> getDoctors() {
        return this.doctorlist;
    }

    @Override
    public Optional<Doctor> getDoctorById(List<Doctor> list, UUID id) {
        return list.stream()
                .filter(doctor -> doctor.getId().equals(id))
                .findFirst();
    }

    @Override
    public int addPatient(Patient patient) {
        patientList.add(new Patient(patient.getName()));
        return 1;
    }

    @Override
    public List<Patient> getPatients() {
        return this.patientList;
    }

    @Override
    public Optional<Patient> getPatientById(List<Patient> list, UUID id) {
        return list.stream()
                .filter(patient -> patient.getId().equals(id))
                .findFirst();
    }

    @Override
    public int addAppointment(Appointment appointment) {
        appointmentList.add(new Appointment(appointment.getDate()));
        return 1;
    }

    @Override
    public List<Appointment> getAppointments() {
        return this.appointmentList;
    }

    @Override
    public int updateAppointmentInfo(UUID appointmentId,UUID doctorId, UUID patientId, String description) {

        Optional<Appointment> appointmentToUpdate = getAppointmentById(appointmentList, appointmentId);
        Optional<Doctor> doctorToAdd = getDoctorById(doctorlist, doctorId);
        Optional<Patient> patientToAdd = getPatientById(patientList, patientId);

        if(!validateAppointmentUpdateInfo(appointmentToUpdate, doctorToAdd, patientToAdd)){
            System.out.println("No appointment found with matching id");
            return 0;
        }

        appointmentToUpdate.get().setDoctor(doctorToAdd.get());
        appointmentToUpdate.get().setPatient(patientToAdd.get());
        appointmentToUpdate.get().setDescription(description);

        return 1;
    }

    @Override
    public Optional<Appointment> getAppointmentById(List<Appointment> list, UUID id) {
        return list.stream()
                .filter(appointment -> appointment.getAppointmentId().equals(id))
                .findFirst();
    }

    @Override
    public int updateAppointmentActivity(UUID appointmentId, int activity) {

        if(activity > 0) {
            return setAppointmentToActive(appointmentId);
        } else {
            return setAppointmentToInactive(appointmentId);
        }

    }

    @Override
    public int setAppointmentToInactive(UUID appointmentId) {

        Optional<Appointment> appointmentToUpdate = getAppointmentById(appointmentList, appointmentId);

        if(appointmentToUpdate.isEmpty()){
            System.out.println("No appointment found with matching id");
            return 0;
        }

        appointmentToUpdate.get().setActive(false);
        appointmentList.remove(appointmentToUpdate.get());
        appointmentArchive.add(appointmentToUpdate.get());
        return 1;
    }

    @Override
    public int setAppointmentToActive(UUID appointmentId) {

        Optional<Appointment> appointmentToUpdate = getAppointmentById(appointmentArchive, appointmentId);

        if(appointmentToUpdate.isEmpty()){
            System.out.println("No appointment found with matching id");
            return 0;
        }


        appointmentToUpdate.get().setActive(true);
        appointmentArchive.remove(appointmentToUpdate.get());
        appointmentList.add(appointmentToUpdate.get());

        return 1;
    }

    @Override
    public boolean validateAppointmentUpdateInfo(Optional<Appointment> appointment, Optional<Doctor> doctor, Optional<Patient> patient) {
        if(appointment.isPresent() && doctor.isPresent() && patient.isPresent()){
            return true;
        } else {
            return false;
        }
    }


}
