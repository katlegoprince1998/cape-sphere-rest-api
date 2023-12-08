package com.codeworld.capesphereapi.service;

import com.codeworld.capesphereapi.model.Candidate;
import com.codeworld.capesphereapi.model.Evaluation;
import com.codeworld.capesphereapi.model.Subject;
import com.codeworld.capesphereapi.repository.CandidateRepository;
import com.codeworld.capesphereapi.repository.EvaluationRepository;
import com.codeworld.capesphereapi.repository.SubjectRepository;
import com.codeworld.capesphereapi.request.EvaluationRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EvaluationServiceImplementation implements EvaluationService{

    private CandidateRepository candidateRepository;
    private SubjectRepository subjectRepository;
    private EvaluationRepository evaluationRepository;

    public EvaluationServiceImplementation(CandidateRepository candidateRepository,
                                           SubjectRepository subjectRepository,
                                           EvaluationRepository evaluationRepository){
        this.candidateRepository = candidateRepository;
        this.subjectRepository = subjectRepository;
        this.evaluationRepository = evaluationRepository;
    }

    @Override
    public Evaluation createEvaluation(EvaluationRequest request, Long candidate_id, Long subject_id) {
        Candidate candidate = candidateRepository.findById(candidate_id).get();
        Subject subject = subjectRepository.findById(subject_id).get();

        Evaluation evaluation = new Evaluation();

        evaluation.setCandidate(candidate);
        evaluation.setLastUpdate(LocalDate.now());
        evaluation.setRisk(request.getRisk());
        evaluation.setRecommendation(request.getRecommendation());
        evaluation.setOverallTechScore(request.getOverallTechScore());
        evaluation.setSubject(subject);
        evaluation.setStatus(request.getStatus());
        evaluation.setPlacement_ready(request.getPlacement_ready());

        return evaluationRepository.save(evaluation);
    }

    @Override
    public List<Evaluation> getAllEvaluations() {
        return evaluationRepository.findAll();
    }
}
