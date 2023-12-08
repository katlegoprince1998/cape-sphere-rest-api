package com.codeworld.capesphereapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        name = "tbl_specialisation"
)
public class Specialisation {
    @Id
    @SequenceGenerator(
            name = "specialisation_sequence",
            sequenceName = "specialisation_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "specialisation_sequence")
    private Long specialisation_id;
    private String name;
    //create a relationship with candidate
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "candidateID",
            referencedColumnName = "candidate_id"
    )
    private Candidate candidate;

    //create a relationship with Cohort
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "cohort_id",
            referencedColumnName = "cohortid"
    )
    private Cohort cohort;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "mentor_id",
            referencedColumnName = "mentor_id"
    )
    private Mentor mentor;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public Cohort getCohort() {
        return cohort;
    }

    public void setCohort(Cohort cohort) {
        this.cohort = cohort;
    }

    public Mentor getMentor() {
        return mentor;
    }

    public void setMentor(Mentor mentor) {
        this.mentor = mentor;
    }
}
