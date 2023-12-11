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
    private String startDate;
    private String endDate;

    //create a relationship with stream
    @JsonIgnore
    @OneToMany(mappedBy = "cohort")
    private Set<Specialisation> specialisations = new HashSet<>();

    public Long getCohortID() {
        return cohortID;
    }

    public void setCohortID(Long cohortID) {
        this.cohortID = cohortID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Set<Specialisation> getSpecialisations() {
        return specialisations;
    }

    public void setSpecialisations(Set<Specialisation> specialisations) {
        this.specialisations = specialisations;
    }
}
