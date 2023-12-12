package com.codeworld.capesphereapi.controller;

import com.codeworld.capesphereapi.model.Evaluation;
import com.codeworld.capesphereapi.request.EvaluationRequest;
import com.codeworld.capesphereapi.service.evaluation.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/evaluation")
@RestController
public class EvaluationController {
    @Autowired
    EvaluationService service;
    @PostMapping("/create/{candidate_id}/{subject_id}")
    public Evaluation createEvaluation(@RequestBody  EvaluationRequest request, @PathVariable("candidate_id")
     Long candidate_id,@PathVariable("subject_id") Long subject_id) {
      return service.createEvaluation(request,candidate_id,subject_id);
    }

    @GetMapping("/get/{candidate_id}")
    public List<Evaluation> getEvaluation(@PathVariable("candidate_id") Long candidate_id) {
        return service.getAllEvaluations(candidate_id);
    }
 }
