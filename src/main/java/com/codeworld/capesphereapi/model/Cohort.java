package com.codeworld.capesphereapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@Table(
        name = "tbl_cohort"
)
public class Cohort {
    @Id
    @SequenceGenerator(
            name = "cohort_sequence",
            sequenceName = "cohort_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cohort_sequence"
    )
    private Long cohortID;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;

    //create a relationship with stream
    @JsonIgnore
    @OneToMany(mappedBy = "cohort")
    private Set<Specialisation> streams = new HashSet<>();

}
