package com.codeworld.capesphereapi.repository;

import com.codeworld.capesphereapi.model.Progress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgressRepository extends JpaRepository<Progress, Long> {
   @Query(
           value = "select p.progress_id,p.candidateid,p.subject_id,s.subject_id," +
                   " p.current, p.overall from tbl_progress p " +
                   ", tbl_candidate c, tbl_subject s " +
                   "where p.candidateid = ?1 " +
                   "and s.subject_id = p.subject_id ",
           nativeQuery = true
   )
    Progress getProgress(Long candidate_id);
}
