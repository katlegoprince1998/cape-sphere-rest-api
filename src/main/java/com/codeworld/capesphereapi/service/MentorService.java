package com.codeworld.capesphereapi.service;

import com.codeworld.capesphereapi.exception.MentorException;
import com.codeworld.capesphereapi.model.Mentor;
import com.codeworld.capesphereapi.request.CreateMentorRequest;

import java.util.List;


public interface MentorService {
    Mentor createMentor(CreateMentorRequest request);
    Mentor updateMentor(Mentor req, Long mentor_id) throws MentorException;
    Mentor findMentorById(Long mentor_id) throws MentorException;
    String deleteMentor(Long mentor_id) throws Exception;
    List<Mentor> getAllMentors();
}
