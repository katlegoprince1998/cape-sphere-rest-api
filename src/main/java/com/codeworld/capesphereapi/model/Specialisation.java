package com.codeworld.capesphereapi.model;

import jakarta.persistence.*;
import lombok.*;

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

}
