package com.isos.isosportal.service;

import com.isos.isosportal.model.Doctor;


import java.util.List;

public interface DoctorService {

    Doctor findById(Long id);
    Doctor save(Doctor doctor);
    void deleteById(Long id);
    void deleteAll();
    List<Doctor> findAll();

}
