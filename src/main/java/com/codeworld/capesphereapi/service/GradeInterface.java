package com.codeworld.capesphereapi.service;


import com.codeworld.capesphereapi.model.Grade;
import com.codeworld.capesphereapi.request.GradeRequest;


import java.util.List;

public interface GradeInterface {
    Grade createGrade(GradeRequest request,Long candidate_i);

    List<Grade> candidateGrades(Long candidate_grade);
}
