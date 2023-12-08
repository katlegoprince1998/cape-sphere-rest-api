package com.codeworld.capesphereapi.service;

import com.codeworld.capesphereapi.model.Progress;
import com.codeworld.capesphereapi.request.ProgressRequest;

import java.util.List;

public interface ProgressService {
    Progress createProgress(ProgressRequest request, Long candidate_id,Long subject_id);

    List<Progress> getAllProgresses();
}
