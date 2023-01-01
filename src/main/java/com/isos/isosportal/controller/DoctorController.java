package com.isos.isosportal.controller;

import com.isos.isosportal.enums.ErrorCode;
import com.isos.isosportal.exception.ApiException;
import com.isos.isosportal.model.Doctor;
import com.isos.isosportal.service.DoctorService;
import com.isos.isosportal.service.impl.DoctorServiceImpl;
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
public class DoctorController {

    private static final Logger LOGGER = LogManager.getLogger(DoctorController.class);

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/doctors")
    public ResponseEntity<List<Doctor>> findAllDoctor() throws ApiException {
        LOGGER.info("findAllDoctor started");
        List<Doctor> result = doctorService.findAll();
        if(result ==null){
            throw new ApiException(ErrorCode.DOCTOR_ALL_NOT_FOUND.getCode(),ErrorCode.DOCTOR_ALL_NOT_FOUND.getMessage());
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/doctor/{id}")
    public ResponseEntity<Doctor> findDoctorById(@PathVariable(value = "id") long id) throws ApiException {
        LOGGER.info("findAllDoctor started");
        Doctor result = doctorService.findById(id);
        if(result ==null){
            throw new ApiException(ErrorCode.DOCTOR_BY_ID_NOT_FOUND.getCode(),ErrorCode.DOCTOR_BY_ID_NOT_FOUND.getMessage());
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/doctor")
    public ResponseEntity<Doctor> saveDoctor(@Validated @RequestBody Doctor doctor) throws ApiException {
        LOGGER.info("saveDoctor started");
        Doctor result = doctorService.save(doctor);
        if(result ==null){
            throw new ApiException(ErrorCode.DOCTOR_SAVE_ERROR_FOUND.getCode(),ErrorCode.DOCTOR_SAVE_ERROR_FOUND.getMessage());
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/doctor")
    public ResponseEntity<Doctor> updateDoctor(@Validated @RequestBody Doctor doctor) throws ApiException {
        LOGGER.info("saveDoctor started");
       Doctor result = doctorService.findById(doctor.getId());
        result.setLastName("Rao");
        if(result ==null){
            throw new ApiException(ErrorCode.DOCTOR_SAVE_ERROR_FOUND.getCode(),ErrorCode.DOCTOR_SAVE_ERROR_FOUND.getMessage());
        }

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }


    @DeleteMapping("/doctor/{id}")
    public ResponseEntity<HttpStatus> deleteDoctor(@Validated @PathVariable Long id) throws ApiException {
        LOGGER.info("deleteDoctor started");
        try{
            doctorService.deleteById(id);
        }catch (Exception ex){
            LOGGER.error("error while delete "+ex.getMessage());
        }
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/doctor")
    public ResponseEntity<HttpStatus> deleteAllDoctor() throws ApiException {
        LOGGER.info("deleteAllDoctor started");
        try{
            doctorService.deleteAll();
        }catch (Exception ex){
            LOGGER.error("error while delete "+ex.getMessage());
        }
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }
}
