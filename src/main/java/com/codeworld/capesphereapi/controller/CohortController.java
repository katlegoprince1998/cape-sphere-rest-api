package com.codeworld.capesphereapi.controller;

import com.codeworld.capesphereapi.model.Cohort;
import com.codeworld.capesphereapi.request.CreateCohortRequest;
import com.codeworld.capesphereapi.service.cohort.CohortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cohort")
public class CohortController {
    @Autowired
    private CohortService service;
    @PostMapping("/create")
    public Cohort createCohort(@RequestBody CreateCohortRequest request){
      return service.createCohort(request);
    }
    @GetMapping("/cohorts")
    public List<Cohort> getAllCohorts(){
        return service.getAllCohorts();
    }

}
