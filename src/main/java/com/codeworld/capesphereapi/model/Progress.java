package com.codeworld.capesphereapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tbl_progress")
public class Progress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long progress_id;
    private double current;
    private double overall;

    //create a relationship with candidates
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "candidateID",
            referencedColumnName = "candidate_id"
    )
    private Candidate candidate;

    //create a one-to-one relationship with module
    @OneToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "module_id",
            referencedColumnName = "module_id"
    )
    private Module module;
}
