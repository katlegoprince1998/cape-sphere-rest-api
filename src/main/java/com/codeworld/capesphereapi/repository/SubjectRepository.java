package com.codeworld.capesphereapi.repository;

import com.codeworld.capesphereapi.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
    @Query(
            value = "SELECT DISTINCT s.sub_level,e.candidateid, c.candidate_id," +
                    " e.subject_id, s.name " +
                    "FROM tbl_subject s, subject_enrollment e, tbl_candidate c " +
                    "WHERE s.subject_id = e.subject_id " +
                    "AND c.candidate_id = e.candidateid " +
                    "AND e.candidateid = ?1",
            nativeQuery = true
    )

    List<Subject> getSubjectByCandidateId(Long candidate_id);
}
