package com.codeworld.capesphereapi.repository;

import com.codeworld.capesphereapi.model.Progress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgressRepository extends JpaRepository<Progress, Long> {
}
