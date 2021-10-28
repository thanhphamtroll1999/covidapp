package me.ifi.CovidWebSpring.service.impl;

import me.ifi.CovidWebSpring.model.Patient;
import me.ifi.CovidWebSpring.repository.PatientRepository;
import me.ifi.CovidWebSpring.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    PatientRepository patientRepository;

    @Override
    public List<Patient> getListPatients() {
       return patientRepository.findAll();
    }

    @Override
    public void deleteSelectedPatient(long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public void createNewPatient(Patient patient){
        patientRepository.save(patient);
    }

    @Override
    public void updatePatient(long id, Patient patientUpdate) {
        Patient patient = patientRepository.findPatientById(id);
        if(patient != null){
            patient.setName(patientUpdate.getName());
            patient.setDateOfBirth(patientUpdate.getDateOfBirth());
            patient.setGender(patientUpdate.getGender());
            patient.setAge(patientUpdate.getAge());
            patient.setAddress(patientUpdate.getAddress());
            patient.setStatus(patientUpdate.getStatus());
            patient.setDiscoveredDate(patientUpdate.getDiscoveredDate());
            patient.setArea(patientUpdate.getArea());
            patientRepository.save(patient);
        }else patientRepository.save(patientUpdate);

    }

    @Override
    public Patient getPatientById(long id) {
        return patientRepository.findPatientById(id);
    }

    @Override
    public List<Patient> getListPatientsSearch(String keyword) {
        return patientRepository.search(keyword);
    }
}
