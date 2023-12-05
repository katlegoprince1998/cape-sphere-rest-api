package com.codeworld.capesphereapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
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

    @Embedded
    private CandidateKin candidateKin;

    //create a relationship between candidate and module
    @JsonIgnore
    @ManyToMany(mappedBy = "candidates")
    private Set<Module> modules = new HashSet<>();
    //create a relationship with grade
    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private Set<Grade> grades = new HashSet<>();

    //create a relationship with progress
    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private Set<Progress> progresses = new HashSet<>();
    //create a relationship with evaluation
    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private Set<Evaluation> evaluations = new HashSet<>();

    //create a relationship with stream
    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private Set<Stream> streams = new HashSet<>();

}
