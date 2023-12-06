package com.codeworld.capesphereapi.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
@Table(name = "candidate_kin")

public class CandidateKin {
    private String nok_firstname;
    private String nok_lastname;
    private String nok_cellNumber;
    private String nok_relationship;
}
