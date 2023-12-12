package com.codeworld.capesphereapi.controller;

import com.codeworld.capesphereapi.model.Mentor;
import com.codeworld.capesphereapi.request.CreateMentorRequest;
import com.codeworld.capesphereapi.service.mentor.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/mentor")
@RestController
public class MentorController {
    @Autowired
    private MentorService service;

    @PostMapping("/create/mentor")
    public Mentor createMentor(@RequestBody CreateMentorRequest request){
        return service.createMentor(request);
    }
    @GetMapping("/get/mentor")
    public List<Mentor> getMentors(){
        return service.getAllMentors();
    }
}
