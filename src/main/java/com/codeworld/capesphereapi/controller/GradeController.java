package com.codeworld.capesphereapi.controller;

import com.codeworld.capesphereapi.model.Grade;
import com.codeworld.capesphereapi.request.GradeRequest;
import com.codeworld.capesphereapi.service.grade.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grade")
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @PostMapping("/addGrade/candidate/{candidateId}/subject/{subject_id}")
    public Grade addGrade(@RequestBody GradeRequest request,
                          @PathVariable("candidateId") Long candidate_id,
                          @PathVariable("subject_id") Long subject_id){

        return gradeService.createGrade(request, candidate_id, subject_id);
    }

    @GetMapping("/get/grades/{candidate_id}")
    public List<Grade> getAllGrades(@PathVariable("candidate_id") Long candidate_id){
        return gradeService.candidateGrades(candidate_id);
    }
}
