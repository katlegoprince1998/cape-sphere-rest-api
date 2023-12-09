package com.codeworld.capesphereapi.service.grade;

import com.codeworld.capesphereapi.model.Candidate;
import com.codeworld.capesphereapi.model.Grade;
import com.codeworld.capesphereapi.model.Subject;
import com.codeworld.capesphereapi.repository.CandidateRepository;
import com.codeworld.capesphereapi.repository.GradeRepository;
import com.codeworld.capesphereapi.repository.SubjectRepository;
import com.codeworld.capesphereapi.request.GradeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Service
public class GradeServiceImplementation implements GradeService {
    @Autowired
    private GradeRepository gradeRepository;
    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public Grade createGrade(GradeRequest request, Long candidate_id, Long subject_id) {
        Subject subject = subjectRepository.findById(subject_id).get();
        Candidate candidate = candidateRepository.findById(candidate_id).get();
        Grade grade = new Grade();
        grade.setCandidate(candidate);
        grade.setSubject(subject);
        grade.setScore(request.getScore());
        grade.setTotal(request.getTotal());
        grade.setDayGraded(LocalDate.now());
        return gradeRepository.save(grade);

    }
    @Override
    public List<Grade> candidateGrades(Long candidate_id) {
        return gradeRepository.findAllById(Collections.singleton(candidate_id));
    }
}
