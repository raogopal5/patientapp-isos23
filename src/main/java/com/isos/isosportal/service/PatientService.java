package com.isos.isosportal.service;

import com.isos.isosportal.model.Patient;

import java.util.List;

public interface PatientService {
    Patient findById(Long id);
    Patient save(Patient patient);
    void deleteById(Long id);
    void deleteAll();
    List<Patient> findAll();

}
