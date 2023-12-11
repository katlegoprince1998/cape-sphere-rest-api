package com.codeworld.capesphereapi.service.evaluation;

import com.codeworld.capesphereapi.model.Evaluation;
import com.codeworld.capesphereapi.request.EvaluationRequest;

import java.util.List;

public interface EvaluationService {
    Evaluation createEvaluation(EvaluationRequest request, Long candidate_id,Long subject_id);

    List<Evaluation> getAllEvaluations(Long candidate_id);
}
