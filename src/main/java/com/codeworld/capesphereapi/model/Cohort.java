package com.codeworld.capesphereapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

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

    public Long getCohortID() {
        return cohortID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Set<Specialisation> getStreams() {
        return streams;
    }

    public void setStreams(Set<Specialisation> streams) {
        this.streams = streams;
    }

    //create a relationship with stream
    @JsonIgnore
    @OneToMany(mappedBy = "cohort")
    private Set<Specialisation> streams = new HashSet<>();

}
