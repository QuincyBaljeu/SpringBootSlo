package com.example.springbootslo.dataAccess;

import com.example.springbootslo.model.Appointment;
import com.example.springbootslo.model.Doctor;
import com.example.springbootslo.model.Patient;
import com.example.springbootslo.util.AppointmentUtilities;
import com.example.springbootslo.util.DoctorUtilities;
import com.example.springbootslo.util.PatientUtilities;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private AppointmentUtilities appointmentUtilities;
    @Autowired
    private DoctorUtilities doctorUtilities;
    @Autowired
    PatientUtilities patientUtilities;

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
    public int addPatient(Patient patient) {
        patientList.add(new Patient(patient.getName()));
        return 1;
    }

    @Override
    public List<Patient> getPatients() {
        return this.patientList;
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

        Optional<Appointment> appointmentToUpdate = appointmentUtilities.getAppointmentById(appointmentList, appointmentId);
        Optional<Doctor> doctorToAdd = doctorUtilities.getDoctorById(doctorlist, doctorId);
        Optional<Patient> patientToAdd = patientUtilities.getPatientById(patientList, patientId);

        if(!appointmentUtilities.validateAppointmentUpdateInfo(appointmentToUpdate, doctorToAdd, patientToAdd)){
            System.out.println("No appointment found with matching id");
            return 0;
        }

        appointmentToUpdate.get().setDoctor(doctorToAdd.get());
        appointmentToUpdate.get().setPatient(patientToAdd.get());
        appointmentToUpdate.get().setDescription(description);

        return 1;
    }

    /**
     *  Updates the active status of an appointment and archives it if neccessary.
     *
     *
     * @param  appointmentId Id of appointment which will be updated
     * @param  activity int to inidicate active status. >1 equals active appointment <1 equals inactive appointment
     *
     * @return Statuscode
     *
     */

    @Override
    public int updateAppointmentActivity(UUID appointmentId, int activity) {

        if(activity > 0) {
            return appointmentUtilities.setAppointmentToActive(appointmentList, appointmentArchive,appointmentId);
        } else {
            return appointmentUtilities.setAppointmentToInactive(appointmentList, appointmentArchive,appointmentId);
        }

    }
}
