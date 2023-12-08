package com.codeworld.capesphereapi.service;

import com.codeworld.capesphereapi.model.Subject;
import com.codeworld.capesphereapi.request.SubjectRequest;

import java.util.List;

public interface SubjectService {
    Subject createSubject(SubjectRequest request, Long candidate_id);
    List<Subject> getAllSubject();
}
