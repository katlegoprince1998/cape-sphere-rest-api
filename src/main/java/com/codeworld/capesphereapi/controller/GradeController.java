package com.codeworld.capesphereapi.controller;

import com.codeworld.capesphereapi.model.Grade;
import com.codeworld.capesphereapi.request.GradeRequest;
import com.codeworld.capesphereapi.service.GradeInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/grade")
public class GradeController {

    @Autowired
    private GradeInterface gradeInterface;

    @PostMapping("/addGrade/candidate/{candidateId}")
    public Grade addGrade(@RequestBody GradeRequest request,
                          @PathVariable("candidateId") Long candidate_id){

        return gradeInterface.createGrade(request, candidate_id);
    }
}
