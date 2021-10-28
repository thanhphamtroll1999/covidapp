package me.ifi.CovidWebSpring.service;

import me.ifi.CovidWebSpring.model.Patient;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PatientService {
    List<Patient> getListPatients();
    void deleteSelectedPatient(long id);
    void createNewPatient(Patient patient);
    void updatePatient(long id, Patient patient);
    Patient getPatientById(long id);
    List<Patient> getListPatientsSearch(String keyword);
}
