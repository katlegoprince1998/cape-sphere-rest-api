package com.codeworld.capesphereapi.controller;

import com.codeworld.capesphereapi.model.Specialisation;
import com.codeworld.capesphereapi.request.SpecialisationRequest;
import com.codeworld.capesphereapi.service.specialisation.SpecialisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/specialisation")
public class SpecialisationController {
    @Autowired
    private SpecialisationService service;
    @PostMapping("/create/mentor/{mentor_id}/cohort/{cohort_id}")
    public Specialisation createSpecialisation(@RequestBody SpecialisationRequest request
    , @PathVariable("mentor_id") Long mentor_id,
                                               @PathVariable("cohort_id") Long cohort_id){
       return service.createSpecialisation(request, mentor_id, cohort_id);

    }

    @GetMapping("/get/specialisation/{candidate_id}")
    public Specialisation getCandiadateSpecialisation(@PathVariable("candidate_id") Long candidate_id){
        return service.getCandidateSpecialisation(candidate_id);
    }

}
