package com.isos.isosportal.service.impl;

import com.isos.isosportal.model.Patient;
import com.isos.isosportal.repositories.PatientRepository;
import com.isos.isosportal.service.PatientService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    private static final Logger LOGGER = LogManager.getLogger(PatientServiceImpl.class);
    @Autowired
    private PatientRepository patientRepository;
    @Override
    public Patient findById(Long id) {
        LOGGER.info("findById started");
       Patient result =  patientRepository.findById(id).get();
      return result;
    }

    @Override
    public Patient save(Patient patient) {
        LOGGER.info("save started");
        Patient result =  patientRepository.save(patient);
        return result;
    }

    @Override
    public void deleteById(Long id) {
        LOGGER.info("deleteById started");
        patientRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        LOGGER.info("deleteAll started");
        patientRepository.deleteAll();

    }

    @Override
    public List<Patient> findAll() {
        LOGGER.info("deleteAll started");
        List<Patient> results = (List<Patient>) patientRepository.findAll();
        return  results;
    }
}
