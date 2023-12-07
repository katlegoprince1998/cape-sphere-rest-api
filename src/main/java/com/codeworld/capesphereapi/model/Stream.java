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
        name = "tbl_stream"
)
public class Stream {
    @Id
    @SequenceGenerator(
            name = "stream_sequence",
            sequenceName = "stream_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stream_sequence")
    private Long streamID;
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
