package com.codeworld.capesphereapi.service.progress;

import com.codeworld.capesphereapi.model.Candidate;
import com.codeworld.capesphereapi.model.Progress;
import com.codeworld.capesphereapi.model.Subject;
import com.codeworld.capesphereapi.repository.CandidateRepository;
import com.codeworld.capesphereapi.repository.ProgressRepository;
import com.codeworld.capesphereapi.repository.SubjectRepository;
import com.codeworld.capesphereapi.request.ProgressRequest;
import com.codeworld.capesphereapi.service.progress.ProgressService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgressServiceImplementation implements ProgressService {
    private final CandidateRepository candidateRepository;
    private final SubjectRepository subjectRepository;
    private final ProgressRepository progressRepository;

    public ProgressServiceImplementation(CandidateRepository candidateRepository,
                                         SubjectRepository subjectRepository,
                                         ProgressRepository progressRepository){
        this.progressRepository = progressRepository;
        this.candidateRepository = candidateRepository;
        this.subjectRepository = subjectRepository;
    }
    @Override
    public Progress createProgress(ProgressRequest request, Long candidate_id, Long subject_id) {
        Candidate candidate = candidateRepository.findById(candidate_id).get();
        Subject subject = subjectRepository.findById(subject_id).get();

        Progress progress = new Progress();
        progress.setCandidate(candidate);
        progress.setCurrent(request.getCurrent());
        progress.setOverall(request.getOverall());
        progress.setSubject(subject);
        return progressRepository.save(progress);
    }

    @Override
    public List<Progress> getAllProgresses() {
        return progressRepository.findAll();
    }
}
