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
            sequenceName = "stream_sequence"
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

}
