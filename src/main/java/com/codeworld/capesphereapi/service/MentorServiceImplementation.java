package com.codeworld.capesphereapi.service;

import com.codeworld.capesphereapi.exception.MentorException;
import com.codeworld.capesphereapi.model.Mentor;
import com.codeworld.capesphereapi.repository.MentorRepository;
import com.codeworld.capesphereapi.request.CreateMentorRequest;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
    public Mentor updateMentor(Mentor req, Long mentor_id) throws MentorException {

        Mentor mentor1 = findMentorById(mentor_id);
        if(Objects.nonNull(req.getFullName()) && !"".equalsIgnoreCase(req.getFullName())){
            mentor1.setFullName(req.getFullName());
        }
        if(Objects.nonNull(req.getEmail()) && !"".equalsIgnoreCase(req.getEmail())){
            mentor1.setEmail(req.getEmail());
        }
        if(Objects.nonNull(req.getPhone()) && !"".equalsIgnoreCase(req.getPhone())){
            mentor1.setEmail(req.getPhone());
        }
        Mentor upadteAndSaveMentor =mentorRepository.save(mentor1);
        return upadteAndSaveMentor;
    }
    @Override
    public Mentor findMentorById(Long mentor_id) throws MentorException {
        Optional<Mentor> optionalMentor = mentorRepository.findById(mentor_id);

        if(optionalMentor.isPresent()){
           return optionalMentor.get();
        }
        throw new MentorException("Mentor Is Not Available");

    }
    @Override
    public String deleteMentor(Long mentor_id) throws Exception {
        Mentor mentor1 = findMentorById(mentor_id);
        mentorRepository.delete(mentor1);
        return "Mentor Deleted Successfully";
    }
    @Override
    public List<Mentor> getAllMentors() {
        return mentorRepository.findAll();
    }
}
