package com.codeworld.capesphereapi.repository;

import com.codeworld.capesphereapi.model.Specialisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialisationRepository extends JpaRepository<Specialisation, Long> {
}
