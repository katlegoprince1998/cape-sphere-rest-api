package com.codeworld.capesphereapi.controller;

import com.codeworld.capesphereapi.model.Progress;
import com.codeworld.capesphereapi.request.ProgressRequest;
import com.codeworld.capesphereapi.service.progress.ProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/progress")
@RestController
public class ProgressController {
    @Autowired
    private ProgressService service;

    @PostMapping("/add/candidate/{candidate_id}/subject/{subject_id}")
    public Progress addProgress(@RequestBody ProgressRequest request, @PathVariable("candidate_id") Long candidate_id,
                                @PathVariable("subject_id") Long subject_id){
        return service.createProgress(request,candidate_id,subject_id);
    }

    @GetMapping("/get/progress/{candidate_id}")
    public Progress getProgress(@PathVariable("candidate_id") Long candidate_id){
        return service.getCandidateProgress(candidate_id);
    }
}
