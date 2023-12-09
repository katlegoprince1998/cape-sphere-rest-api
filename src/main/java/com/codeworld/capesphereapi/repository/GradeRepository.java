package com.codeworld.capesphereapi.repository;

import com.codeworld.capesphereapi.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;


public interface GradeRepository extends JpaRepository<Grade,Long> {

}
