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

    private CohortRepository cohortRepository;
    private CandidateService candidateService;
    private Cohort cohort;

    public CohortServiceImplementation(CohortRepository cohortRepository,
                                       CandidateService candidateService,
                                       Cohort cohort){
        this.cohortRepository = cohortRepository;
        this.candidateService = candidateService;
        this.cohort = cohort;
    }
    @Override
    public Cohort createCohort(CreateCohortRequest request) {

        cohort.setName(request.getName());
        cohort.setStartDate(request.getStartDate());
        cohort.setEndDate(request.getEndDate());
        Cohort saveCohort = cohortRepository.save(cohort);
        return saveCohort;
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
        Cohort updateAndSaveCohort = cohortRepository.save(cohort);
        return updateAndSaveCohort;
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
