package com.codeworld.capesphereapi.service.subject;

import com.codeworld.capesphereapi.model.Candidate;
import com.codeworld.capesphereapi.model.Subject;
import com.codeworld.capesphereapi.repository.CandidateRepository;
import com.codeworld.capesphereapi.repository.SubjectRepository;
import com.codeworld.capesphereapi.request.SubjectRequest;
import com.codeworld.capesphereapi.service.subject.SubjectService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class SubjectServiceImplementation implements SubjectService {

    private final SubjectRepository subjectRepository;
    private final CandidateRepository candidateRepository;

    public SubjectServiceImplementation(SubjectRepository subjectRepository,
                                        CandidateRepository candidateRepository){
        this.subjectRepository = subjectRepository;
        this.candidateRepository = candidateRepository;

    }
    @Override
    public Subject createSubject(SubjectRequest request, Long candidate_id) {
        Candidate candidate = candidateRepository.findById(candidate_id).get();
        Subject subject = new Subject();
        subject.setName(request.getName());
        subject.setLevel(request.getLevel());
        subject.setCandidates(Collections.singleton(candidate));
        return subjectRepository.save(subject);
    }
    @Override
    public List<Subject> getAllSubject(Long candidate_id) {
        return subjectRepository.getSubjectByCandidateId(candidate_id);
    }
}
