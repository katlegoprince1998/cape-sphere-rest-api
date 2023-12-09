package com.codeworld.capesphereapi.service.candidate;

import com.codeworld.capesphereapi.exception.CandidateException;
import com.codeworld.capesphereapi.model.Candidate;

public interface CandidateService {
     Candidate findCandidateById(Long candidateId)
             throws CandidateException;
     Candidate findCandidateByJwt(String jwt)
             throws CandidateException;



}
