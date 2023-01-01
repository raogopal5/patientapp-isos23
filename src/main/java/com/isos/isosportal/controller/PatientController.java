package com.isos.isosportal.controller;

import com.isos.isosportal.enums.ErrorCode;
import com.isos.isosportal.exception.ApiException;
import com.isos.isosportal.model.Patient;
import com.isos.isosportal.service.PatientService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PatientController {
    private static final Logger LOGGER = LogManager.getLogger(PatientController.class);


    @Autowired
    private PatientService patientService;

    @GetMapping("/patients")
    public ResponseEntity<List<Patient>> findAllPatient() throws ApiException {
        LOGGER.info("findAllPatient started");
        List<Patient> result = patientService.findAll();
        if(result ==null){
            throw new ApiException(ErrorCode.PATIENT_ALL_NOT_FOUND.getCode(),ErrorCode.PATIENT_ALL_NOT_FOUND.getMessage());
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/patient/{id}")
    public ResponseEntity<Patient> findPatientById(@PathVariable(value = "id") long id) throws ApiException {
        LOGGER.info("findPatientById started");
        Patient result = patientService.findById(id);
        if(result ==null){
            throw new ApiException(ErrorCode.PATIENT_BY_ID_NOT_FOUND.getCode(),ErrorCode.PATIENT_BY_ID_NOT_FOUND.getMessage());
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/patient")
    public ResponseEntity<Patient> savePatient(@Validated @RequestBody Patient patient) throws ApiException {
        LOGGER.info("savePatient started");
        Patient result = patientService.save(patient);
        if(result ==null){
            throw new ApiException(ErrorCode.PATIENT_ALL_NOT_FOUND.getCode(),ErrorCode.PATIENT_ALL_NOT_FOUND.getMessage());
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/patient")
    public ResponseEntity<Patient> updatePatient(@Validated @RequestBody Patient patient) throws ApiException {
        LOGGER.info("updatePatient started");
        Patient result = patientService.findById(patient.getId());
        result.setLastName("Rao");
        if(result ==null){
            throw new ApiException(ErrorCode.PATIENT_SAVE_ERROR_FOUND.getCode(),ErrorCode.PATIENT_SAVE_ERROR_FOUND.getMessage());
        }

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @DeleteMapping("/patient/{id}")
    public ResponseEntity<HttpStatus> deletePatient(@Validated @PathVariable Long id) throws ApiException {
        LOGGER.info("deletePatient started");
        try{
            patientService.deleteById(id);
        }catch (Exception ex){
            LOGGER.error("error while delete "+ex.getMessage());
        }
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/patients")
    public ResponseEntity<HttpStatus> deleteAllPatient() throws ApiException {
        LOGGER.info("deletePatient started");
        try{
            patientService.deleteAll();
        }catch (Exception ex){
            LOGGER.error("error while delete "+ex.getMessage());
        }
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }

}
