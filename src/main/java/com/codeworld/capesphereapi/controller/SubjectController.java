package com.codeworld.capesphereapi.controller;

import com.codeworld.capesphereapi.model.Subject;
import com.codeworld.capesphereapi.request.SubjectRequest;
import com.codeworld.capesphereapi.service.subject.SubjectService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/subject")
@RestController
public class SubjectController {
    @Autowired
    SubjectService subjectService;
    @PostMapping("/add/subject/{candidate_id}")
    public Subject addSubject(@RequestBody SubjectRequest request,
                              @PathVariable("candidate_id") Long candidate_id){
      return subjectService.createSubject(request, candidate_id);
    }

    @GetMapping("/get/subjects/{candidate_id}")
    public List<Subject> getAllSubjects(@PathVariable("candidate_id") Long candidate_id){
        return subjectService.getAllSubject(candidate_id);
    }
}
