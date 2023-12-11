package com.codeworld.capesphereapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
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
    private Long id;
    private String name;
    //create a relationship with candidate
    @OneToMany(mappedBy = "candidateID", cascade = CascadeType.ALL)
    private Set<Candidate> candidate = new HashSet<>();

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Candidate> getCandidate() {
        return candidate;
    }

    public void setCandidate(Set<Candidate> candidate) {
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
