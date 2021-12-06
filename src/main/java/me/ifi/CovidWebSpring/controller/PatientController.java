package me.ifi.CovidWebSpring.controller;

import io.swagger.annotations.ApiResponse;
import me.ifi.CovidWebSpring.dto.PatientDto;
import me.ifi.CovidWebSpring.model.Patient;
import me.ifi.CovidWebSpring.service.PatientService;
import me.ifi.CovidWebSpring.service.impl.PatientServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class PatientController {
    @Autowired
    PatientServiceImpl patientServiceImpl;

    @Autowired
    ModelMapper modelMapper;

//    @GetMapping("/patients")
//    public ResponseEntity<List<Patient>> getListPatients() {
//        List<Patient> list = patientServiceImpl.getListPatients();
//        if(list.isEmpty()){
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        else return new ResponseEntity<>(list, HttpStatus.OK);
//    }
//
//    @GetMapping("/patients/{id}")
//    public ResponseEntity<Patient> getPatientById(@PathVariable long id){
//        try{
//            Patient patient = patientServiceImpl.getPatientById(id);
//            return new ResponseEntity<>(patient, HttpStatus.OK);
//        }catch (Exception e){
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @PostMapping("/create")
//    public ResponseEntity<Patient> createNewPatient(@RequestBody Patient patient){
//        try{
//            patientServiceImpl.createNewPatient(patient);
//            return new ResponseEntity<>(patient,HttpStatus.CREATED);
//        }catch (Exception e){
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @DeleteMapping("/patients/{id}")
//    public ResponseEntity<Patient> deleteSelectedPatient(@PathVariable long id){
//        try{
//            patientServiceImpl.deleteSelectedPatient(id);
//            return new ResponseEntity<>(HttpStatus.OK);
//        }catch (Exception e){
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @PutMapping("/patients/{id}")
//    public ResponseEntity<Patient> updatePatient(@PathVariable long id, @RequestBody Patient updatePatient){
//        try{
//            patientServiceImpl.updatePatient(id, updatePatient);
//            return new ResponseEntity<>(updatePatient, HttpStatus.OK);
//        }catch (Exception e){
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @GetMapping("/patients/search/{keyword}")
//    public ResponseEntity<List<Patient>> getListPatientSearch(@PathVariable String keyword){
//        try{
//            List<Patient> listSearch = patientServiceImpl.getListPatientsSearch(keyword);
//            return new ResponseEntity<>(listSearch, HttpStatus.OK);
//        }catch (Exception e){
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    private PatientService patientService;

    @GetMapping("/patients")
    public ResponseEntity<List<PatientDto>> getListPatients() {
        List<PatientDto> list = patientService.getListPatients().stream().map(patient ->
                modelMapper.map(patient, PatientDto.class)).collect(Collectors.toList());
        if(list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/patients/{id}")
    public ResponseEntity<PatientDto> getPatientById(@PathVariable long id){
        try{
            Patient patient = patientService.getPatientById(id);
            PatientDto patientResponse = modelMapper.map(patient, PatientDto.class);
            return new ResponseEntity<>(patientResponse, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<PatientDto> createNewPatient(@RequestBody PatientDto patientDto){

        try{
            Patient patientRequest = modelMapper.map(patientDto, Patient.class);
            Patient patient = patientService.createNewPatient(patientRequest);

            PatientDto patientResponse = modelMapper.map(patient, PatientDto.class);
            return new ResponseEntity<>(patientResponse,HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/patients/{id}")
    public ResponseEntity<PatientDto> deleteSelectedPatient(@PathVariable long id){
        try{
            patientService.deleteSelectedPatient(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/patients/{id}")
    public ResponseEntity<PatientDto> updatePatient(@PathVariable long id, @RequestBody PatientDto updatePatientDto){
        try{
            Patient patientRequest = modelMapper.map(updatePatientDto, Patient.class);
            Patient patient = patientService.updatePatient(id, patientRequest);

            PatientDto patientResponse = modelMapper.map(patient, PatientDto.class);
            return new ResponseEntity<>(patientResponse, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/patients/search/{keyword}")
    public ResponseEntity<List<PatientDto>> getListPatientSearch(@PathVariable String keyword){
        try{
            List<PatientDto> list = patientService.getListPatientsSearch(keyword).stream().map(patient ->
                    modelMapper.map(patient, PatientDto.class)).collect(Collectors.toList());
            return new ResponseEntity<>(list, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
