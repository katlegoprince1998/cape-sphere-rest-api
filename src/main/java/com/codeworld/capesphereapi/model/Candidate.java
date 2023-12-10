package com.codeworld.capesphereapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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


    //create a relationship with evaluation
    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private Set<Evaluation> evaluations = new HashSet<>();

    //create a relationship with stream
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "specialisation_id"

    )
    private Specialisation specialisation;

}
