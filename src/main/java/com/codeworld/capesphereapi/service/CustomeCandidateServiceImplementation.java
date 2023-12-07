package com.codeworld.capesphereapi.service;

import com.codeworld.capesphereapi.model.Candidate;
import com.codeworld.capesphereapi.repository.CandidateRepository;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomeCandidateServiceImplementation implements UserDetailsService {

    private final CandidateRepository candidateRepository;
    public CustomeCandidateServiceImplementation(CandidateRepository candidateRepository){
        this.candidateRepository = candidateRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Candidate candidate = candidateRepository.findByEmail(username);
        if(candidate ==null){
            throw new UsernameNotFoundException("User not found with email -" + username);
        }
        List<GrantedAuthority> authorities =new ArrayList<>();

        return new User(candidate.getEmail(),
                candidate.getPassword(), authorities);
    }
}
