package com.isos.isosportal.repositories;

import com.isos.isosportal.model.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DoctorRepository extends CrudRepository<Doctor,Long> {
}
