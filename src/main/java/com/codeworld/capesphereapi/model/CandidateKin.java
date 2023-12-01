package com.codeworld.capesphereapi.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable

public class CandidateKin {
    private String nok_firstname;
    private String nok_lastname;
    private String nok_cellNumber;
    private String nok_relationship;
}
