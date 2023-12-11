package com.codeworld.capesphereapi.repository;

import com.codeworld.capesphereapi.model.Progress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgressRepository extends JpaRepository<Progress, Long> {
    @Query(
            value = "SELECT s.subject_id,  p.progress_id, p.candidateid, p.subject_id AS progress_subject_id, " +
                    "p.current, p.overall " +
                    "FROM tbl_progress p, tbl_candidate c, tbl_subject s " +
                    "WHERE p.candidateid = ?1 " +
                    "AND s.subject_id = p.subject_id",
            nativeQuery = true
    )
    Progress getProgress(Long candidate_id);
}
