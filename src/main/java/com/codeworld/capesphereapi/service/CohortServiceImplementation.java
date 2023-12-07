package com.codeworld.capesphereapi.service;

import com.codeworld.capesphereapi.exception.CohortException;
import com.codeworld.capesphereapi.model.Cohort;
import com.codeworld.capesphereapi.repository.CohortRepository;
import com.codeworld.capesphereapi.request.CreateCohortRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class CohortServiceImplementation implements CohortService{

    private final CohortRepository cohortRepository;
    private CandidateService candidateService;


    public CohortServiceImplementation(CohortRepository cohortRepository,
                                       CandidateService candidateService){
        this.cohortRepository = cohortRepository;
        this.candidateService = candidateService;

    }
    @Override
    public Cohort createCohort(CreateCohortRequest request) {
        Cohort cohort = new Cohort();
        cohort.setName(request.getName());
        cohort.setStartDate(request.getStartDate());
        cohort.setEndDate(request.getEndDate());
        return cohortRepository.save(cohort);
    }

    @Override
    public String deleteCohort(Long cohort_id) throws CohortException {
        Cohort cohort1 = findCohortById(cohort_id);
        cohortRepository.delete(cohort1);
        return "Cohort deleted Successfully";
    }
    @Override
    public Cohort updateCohort(Cohort req, Long cohort_id) throws CohortException {
        Cohort cohort = findCohortById(cohort_id);
        if(Objects.nonNull(req.getName()) && !"".equalsIgnoreCase(req.getName())){
            cohort.setName(req.getName());
        }
        if (Objects.nonNull(req.getEndDate())){
            cohort.setEndDate(req.getEndDate());
        }
        if (Objects.nonNull(req.getStartDate())){
            cohort.setStartDate(req.getStartDate());
        }
        return cohortRepository.save(cohort);
    }
    @Override
    public Cohort findCohortById(Long cohort_id) throws CohortException {
        return null;
    }
    @Override
    public List<Cohort> getAllCohorts() {
        return null;
    }
}
