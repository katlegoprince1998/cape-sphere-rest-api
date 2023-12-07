package com.codeworld.capesphereapi.service;

import com.codeworld.capesphereapi.exception.MentorException;
import com.codeworld.capesphereapi.model.Mentor;
import com.codeworld.capesphereapi.repository.MentorRepository;
import com.codeworld.capesphereapi.request.CreateMentorRequest;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MentorServiceImplementation implements MentorService{
    private MentorRepository mentorRepository;
    private Mentor mentor;
    public MentorServiceImplementation(MentorRepository mentorRepository, Mentor mentor){
        this.mentorRepository = mentorRepository;
        this.mentor = mentor;
    }
    @Override
    public Mentor createMentor(CreateMentorRequest request) {
        mentor.setFullName(request.getFullName());
        mentor.setEmail(request.getEmail());
        mentor.setPhone(request.getPhone());
        Mentor saveMentor = mentorRepository.save(mentor);
        return saveMentor;
    }
    @Override
    public Mentor updateMentor(Mentor mentor, Long mentor_id) throws MentorException {
        return null;
    }
    @Override
    public Mentor findMentorById(Long mentor_id) throws MentorException {
        return null;
    }
    @Override
    public String deleteMentor(Long mentor_id) throws Exception {
        return null;
    }
    @Override
    public List<Mentor> getAllMentors() {
        return null;
    }
}
