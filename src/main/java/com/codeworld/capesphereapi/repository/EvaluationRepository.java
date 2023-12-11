package com.codeworld.capesphereapi.repository;

import com.codeworld.capesphereapi.model.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {
    @Query(
            value = "select e.evaluation_id, e.last_update, e.overall_tech_score, e.placement_ready," +
                    " e.recommendation, e.risk, e.status, e.candidateid, c.candidate_id, s.subject_id, s.name " +
                    "from tbl_evaluation e, tbl_subject s, tbl_candidate c " +
                    "where c.candidate_id = ?1 " +
                    "and s.subject_id = s.subject_id",
            nativeQuery = true
    )
    List<Evaluation> getCandidateEvaluation(Long candidate_id);
}
