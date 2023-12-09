package com.codeworld.capesphereapi.service.grade;


import com.codeworld.capesphereapi.model.Grade;
import com.codeworld.capesphereapi.request.GradeRequest;


import java.util.List;

public interface GradeService {
    Grade createGrade(GradeRequest request,Long candidate_id, Long subject_id);

    List<Grade> candidateGrades(Long candidate_id);
}
