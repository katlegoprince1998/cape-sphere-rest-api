package com.codeworld.capesphereapi.repository;

import com.codeworld.capesphereapi.model.Specialisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialisationRepository extends JpaRepository<Specialisation, Long> {
  @Query(
          value = "SELECT s.id, s.name, s.mentor_id, c.specialisation_id, " +
                  " s.cohort_id, c.candidate_id " +
                  "FROM tbl_specialisation s, tbl_candidate c " +
                  "WHERE s.id = c.specialisation_id " +
                  "AND c.candidate_id = ?1",
          nativeQuery = true
  )


  Specialisation getSpecialisation(Long candidate_is);
}
