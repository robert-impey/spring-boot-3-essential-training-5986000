package com.frankmoley.lil.roomwebapp.data.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.frankmoley.lil.roomwebapp.data.entity.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, UUID>{

}
