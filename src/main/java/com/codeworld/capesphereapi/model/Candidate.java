package com.codeworld.capesphereapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "tbl_candidate"
)
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "candidate_id")
    private Long candidateID;
    private String firstname;
    private String lastname;
    private String identityNO;

    private String phoneNumber;
    private String email;
    private String password;
    private String role;

    @Embedded
    @ElementCollection
    @CollectionTable(name = "candidate_kin", joinColumns = @JoinColumn(name = "candidateid"))
    private List<CandidateKin> candidateKin = new ArrayList<>();

    //create a relationship between candidate and module
    @JsonIgnore
    @ManyToMany(mappedBy = "candidates")
    private Set<Subject> modules = new HashSet<>();
    //create a relationship with grade
    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private Set<Grade> grades = new HashSet<>();

    //create a relationship with progress
    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private Set<Progress> progresses = new HashSet<>();

    public String getFirstname() {
        return firstname;
    }

    public Long getCandidateID() {
        return candidateID;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getIdentityNO() {
        return identityNO;
    }

    public void setIdentityNO(String identityNO) {
        this.identityNO = identityNO;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    //create a relationship with evaluation
    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private Set<Evaluation> evaluations = new HashSet<>();

    //create a relationship with stream
    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private Set<Specialisation> streams = new HashSet<>();

}
