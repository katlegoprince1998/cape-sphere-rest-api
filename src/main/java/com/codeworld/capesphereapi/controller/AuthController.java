package com.codeworld.capesphereapi.controller;

import com.codeworld.capesphereapi.config.JwtProvider;
import com.codeworld.capesphereapi.exception.CandidateException;
import com.codeworld.capesphereapi.model.Candidate;
import com.codeworld.capesphereapi.repository.CandidateRepository;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final CandidateRepository candidateRepository;
    private final JwtProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;

    private final CustomeCandidateServiceImplementation candidateServiceImplementation;

    public AuthController(CandidateRepository candidateRepository, CustomeCandidateServiceImplementation
            candidateServiceImplementation, PasswordEncoder passwordEncoder,
                          JwtProvider jwtProvider) {
        this.candidateRepository = candidateRepository;
        this.candidateServiceImplementation = candidateServiceImplementation;
        this.passwordEncoder = passwordEncoder;
        this.jwtProvider = jwtProvider;
    }

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> createCandidateHandler(
            @RequestBody Candidate candidate
    ) throws CandidateException {
        String email = candidate.getEmail();
        String password = candidate.getPassword();
        String firstname = candidate.getFirstname();
        String lastname = candidate.getLastname();
        String idNo = candidate.getIdentityNO();
        String phone = candidate.getPhoneNumber();

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
        createdCandidate.setIdentityNO(idNo);
        createdCandidate.setPhoneNumber(phone);

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
