package com.codeworld.capesphereapi.controller;

import com.codeworld.capesphereapi.config.JwtProvider;
import com.codeworld.capesphereapi.exception.CandidateException;
import com.codeworld.capesphereapi.model.Candidate;
import com.codeworld.capesphereapi.model.Specialisation;
import com.codeworld.capesphereapi.repository.CandidateRepository;
import com.codeworld.capesphereapi.repository.SpecialisationRepository;
import com.codeworld.capesphereapi.request.LoginRequest;
import com.codeworld.capesphereapi.response.AuthResponse;
import com.codeworld.capesphereapi.service.candidate.CustomeCandidateServiceImplementation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final CandidateRepository candidateRepository;
    private final JwtProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;
    private final SpecialisationRepository repository;

    private final CustomeCandidateServiceImplementation candidateServiceImplementation;

    public AuthController(CandidateRepository candidateRepository, CustomeCandidateServiceImplementation
            candidateServiceImplementation, PasswordEncoder passwordEncoder,
                          JwtProvider jwtProvider, SpecialisationRepository repository) {
        this.candidateRepository = candidateRepository;
        this.candidateServiceImplementation = candidateServiceImplementation;
        this.passwordEncoder = passwordEncoder;
        this.jwtProvider = jwtProvider;
        this.repository = repository;
    }

    @PostMapping("/specialisation/{specialisation_id}/signup")
    public ResponseEntity<AuthResponse> createCandidateHandler(
            @RequestBody Candidate candidate,
            @PathVariable("specialisation_id") Long specialisation_id
    ) throws CandidateException {
        String email = candidate.getEmail();
        String password = candidate.getPassword();
        String firstname = candidate.getFirstname();
        String lastname = candidate.getLastname();
        String idNo = candidate.getIdentification();
        String phone = candidate.getPhone();
        Specialisation specialisation = repository.findById(specialisation_id).get();


        Candidate isEmailExist = candidateRepository.findByEmail(email);

        if (isEmailExist != null) {
            throw new CandidateException("An Account With This Email" +
                    " Already Exist");
        }
        Candidate createdCandidate = new Candidate();

        createdCandidate.setEmail(email);
        createdCandidate.setPassword(passwordEncoder.encode(password));
        createdCandidate.setFirstname(firstname);
        createdCandidate.setLastname(lastname);
        createdCandidate.setIdentification(idNo);
        createdCandidate.setIdentification(phone);
        createdCandidate.setSpecialisation(specialisation);

        Candidate savedCandidate = candidateRepository.save(createdCandidate);

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                savedCandidate.getEmail(), savedCandidate.getPassword());

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtProvider.generateToken(authentication);

        AuthResponse authResponse = new AuthResponse();
        authResponse.setJwt(token);
        authResponse.setMessage("Account created successfully");

        return new ResponseEntity<AuthResponse>(authResponse, HttpStatus.CREATED);
    }

    @PostMapping("/signing")
    public ResponseEntity<AuthResponse> loginCandidateHandler(@RequestBody
                                                              LoginRequest loginRequest) {
        String username = loginRequest.getEmail();
        String password = loginRequest.getPassword();
        Authentication authentication = authenticate(username, password);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.generateToken(authentication);
        AuthResponse authResponse = new AuthResponse();
        authResponse.setJwt(token);
        authResponse.setMessage("Login Success");

        return new ResponseEntity<AuthResponse>(authResponse, HttpStatus.CREATED);

    }

    private Authentication authenticate(String username, String password) {
        UserDetails userDetails = candidateServiceImplementation.loadUserByUsername(username);

        if (userDetails == null) {
            throw new BadCredentialsException("Invalid Username");
        }

        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new BadCredentialsException("Password Invalid");
        }
        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    }

}
