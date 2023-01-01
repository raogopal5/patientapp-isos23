package com.isos.isosportal.service.impl;

import com.isos.isosportal.model.Doctor;
import com.isos.isosportal.repositories.DoctorRepository;
import com.isos.isosportal.service.DoctorService;
import com.isos.isosportal.service.PatientService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    private static final Logger LOGGER = LogManager.getLogger(DoctorServiceImpl.class);
    @Autowired
    private DoctorRepository doctorRepository;
    @Override
    public Doctor findById(Long id) {
        LOGGER.info("findById initiated");
        Doctor result = doctorRepository.findById(id).get();
        return result;
    }

    @Override
    public Doctor save(Doctor doctor) {
        LOGGER.info("Save initiated");
        Doctor result = doctorRepository.save(doctor);
        return result;
    }

    @Override
    public void deleteById(Long id) {
        LOGGER.info("deleteById initiated");
        doctorRepository.deleteById(id);

    }

    @Override
    public void deleteAll() {
        LOGGER.info("deleteAll initiated");
          doctorRepository.deleteAll();
    }

    @Override
    public List<Doctor> findAll() {
        LOGGER.info("findAll initiated");
        List<Doctor> result = (List<Doctor>) doctorRepository.findAll();
        return result;
    }
}
