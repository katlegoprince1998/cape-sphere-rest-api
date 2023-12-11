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
    private String identification;

    private String phone;
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
            name = "specialisation_id",
            referencedColumnName = "id"

    )
    private Specialisation specialisation;

    public Long getCandidateID() {
        return candidateID;
    }

    public void setCandidateID(Long candidateID) {
        this.candidateID = candidateID;
    }

    public String getFirstname() {
        return firstname;
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

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public List<CandidateKin> getCandidateKin() {
        return candidateKin;
    }

    public void setCandidateKin(List<CandidateKin> candidateKin) {
        this.candidateKin = candidateKin;
    }

    public Set<Subject> getModules() {
        return modules;
    }

    public void setModules(Set<Subject> modules) {
        this.modules = modules;
    }

    public Set<Grade> getGrades() {
        return grades;
    }

    public void setGrades(Set<Grade> grades) {
        this.grades = grades;
    }

    public Set<Progress> getProgresses() {
        return progresses;
    }

    public void setProgresses(Set<Progress> progresses) {
        this.progresses = progresses;
    }

    public Set<Evaluation> getEvaluations() {
        return evaluations;
    }

    public void setEvaluations(Set<Evaluation> evaluations) {
        this.evaluations = evaluations;
    }

    public Specialisation getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(Specialisation specialisation) {
        this.specialisation = specialisation;
    }
}
