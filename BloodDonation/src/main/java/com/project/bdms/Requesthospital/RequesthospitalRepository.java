package com.project.bdms.Requesthospital;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RequesthospitalRepository extends JpaRepository<Requesthospital, Integer> {

}
