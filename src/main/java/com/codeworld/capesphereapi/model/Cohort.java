package com.codeworld.capesphereapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        name = "tbl_cohort"
)
public class Cohort {
    @Id
    @SequenceGenerator(
            name = "cohort_sequence",
            sequenceName = "cohort_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cohort_sequence"
    )
    private Long cohortID;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;

    @OneToMany(
            mappedBy = "Cohort",
            cascade = CascadeType.ALL
    )
    private List<Stream>  streams;

    @OneToMany(
            mappedBy = "Cohort",
            cascade = CascadeType.ALL
    )
    private List<Candidate> candidates;
}
