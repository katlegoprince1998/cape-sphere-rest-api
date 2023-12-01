package com.codeworld.capesphereapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "streamID", name = "stream_id")
    private Stream stream;

    @ManyToOne
    @JoinColumn(
            name = "cohort_id",
            referencedColumnName = "cohortID"
    )
    private Cohort cohort;
}
