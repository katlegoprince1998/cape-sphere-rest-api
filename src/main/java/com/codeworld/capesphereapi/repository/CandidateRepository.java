package com.codeworld.capesphereapi.repository;

import com.codeworld.capesphereapi.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends
        JpaRepository<Candidate, Long> {

    public Candidate findByEmail(String email);
}
