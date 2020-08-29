package com.example.springbootslo.util;

import com.example.springbootslo.model.Appointment;
import com.example.springbootslo.model.Doctor;
import com.example.springbootslo.model.Patient;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component("AppointmentUtil")
public class AppointmentUtilities {

    public boolean validateAppointmentUpdateInfo(Optional<Appointment> appointment, Optional<Doctor> doctor, Optional<Patient> patient) {
        if(appointment.isPresent() && doctor.isPresent() && patient.isPresent()){
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     *
     * @param list list in which the method will search
     * @param id id of requested appointment
     *
     * @return Optional which will contain the found appointment, will be empty if not found
     *
     */

    public Optional<Appointment> getAppointmentById(List<Appointment> list, UUID id) {
        return list.stream()
                .filter(appointment -> appointment.getAppointmentId().equals(id))
                .findFirst();
    }

    /**
     *
     *
     * @param appointmentList List with active appointments to remove appointment from
     * @param appointmentArchive List with archived appointments to add appointment to
     * @param appointmentId id of appointment to archive
     *
     * @return
     *
     */

    public int setAppointmentToInactive(List<Appointment> appointmentList, List<Appointment> appointmentArchive, UUID appointmentId) {

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

    /**
     *
     *
     * @param appointmentList list with active appointments add appointment to
     * @param appointmentArchive List with archived appointments remove appointment from
     * @param appointmentId Id of appointment to set to active
     *
     * @return Statuscode
     *
     */

    public int setAppointmentToActive(List<Appointment> appointmentList, List<Appointment> appointmentArchive, UUID appointmentId) {

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
}
