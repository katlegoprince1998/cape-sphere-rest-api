package com.codeworld.capesphereapi.service.candidate;

import com.codeworld.capesphereapi.config.JwtProvider;
import com.codeworld.capesphereapi.exception.CandidateException;
import com.codeworld.capesphereapi.model.Candidate;
import com.codeworld.capesphereapi.repository.CandidateRepository;
import com.codeworld.capesphereapi.service.candidate.CandidateService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CandidateServiceImplementation implements CandidateService {
    private CandidateRepository candidateRepository;
    private JwtProvider jwtProvider;

    public CandidateServiceImplementation(CandidateRepository candidateRepository,
                                          JwtProvider jwtProvider){
        this.candidateRepository = candidateRepository;
        this.jwtProvider = jwtProvider;
    }
    @Override
    public Candidate findCandidateById(Long candidateId) throws CandidateException {
        Optional<Candidate> candidate = candidateRepository.findById(candidateId);
        if(candidate.isPresent()){
            return candidate.get();
        }
        throw new CandidateException("Candidate Was Not Found");
    }

    @Override
    public Candidate findCandidateByJwt(String jwt) throws CandidateException {
        String email = jwtProvider.getEmailFromToken(jwt);

        Candidate candidate = candidateRepository.findByEmail(email);

        if(candidate==null){
            throw new CandidateException("Candidate with this email was not found");

        }

        return candidate;
    }
}
