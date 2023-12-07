package com.codeworld.capesphereapi.service;

import com.codeworld.capesphereapi.exception.CohortException;
import com.codeworld.capesphereapi.model.Cohort;
import com.codeworld.capesphereapi.request.CreateCohortRequest;


import java.util.List;


public interface CohortService {
    Cohort createCohort(CreateCohortRequest request);
    String deleteCohort(Long cohort_id) throws CohortException;
    Cohort updateCohort(Cohort req, Long cohort_id) throws CohortException;
    Cohort findCohortById(Long cohort_id) throws CohortException;
    List<Cohort> getAllCohorts();
}
