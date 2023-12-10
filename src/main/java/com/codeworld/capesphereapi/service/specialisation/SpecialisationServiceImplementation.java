package com.codeworld.capesphereapi.service.specialisation;

import com.codeworld.capesphereapi.model.Candidate;
import com.codeworld.capesphereapi.model.Cohort;
import com.codeworld.capesphereapi.model.Mentor;
import com.codeworld.capesphereapi.model.Specialisation;
import com.codeworld.capesphereapi.repository.CandidateRepository;
import com.codeworld.capesphereapi.repository.CohortRepository;
import com.codeworld.capesphereapi.repository.MentorRepository;
import com.codeworld.capesphereapi.repository.SpecialisationRepository;
import com.codeworld.capesphereapi.request.SpecialisationRequest;
import com.codeworld.capesphereapi.service.specialisation.SpecialisationService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class SpecialisationServiceImplementation implements SpecialisationService {

    private SpecialisationRepository specialisationRepository;
    private MentorRepository mentorRepository;

    private CohortRepository cohortRepository;

    public SpecialisationServiceImplementation(SpecialisationRepository specialisationRepository,
                                               MentorRepository mentorRepository,
                                               CohortRepository cohortRepository){
        this.specialisationRepository = specialisationRepository;
        this.mentorRepository = mentorRepository;
        this.cohortRepository = cohortRepository;
    }
    @Override
    public Specialisation createSpecialisation(SpecialisationRequest request, Long mentor_id, Long cohort_id) {
        Mentor mentor = mentorRepository.findById(mentor_id).get();
        Cohort cohort = cohortRepository.findById(cohort_id).get();

        Specialisation specialisation = new Specialisation();
        specialisation.setName(request.getName());
        specialisation.setCohort(cohort);
        specialisation.setMentor(mentor);


        return specialisationRepository.save(specialisation);
    }
    @Override
    public List<Specialisation> getAllSpecialisation() {
        return specialisationRepository.findAll();
    }
}
