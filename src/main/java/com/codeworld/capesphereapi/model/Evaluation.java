package com.codeworld.capesphereapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_evaluation")
@Getter
@Setter
public class Evaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long evaluation_id;
    private String status;
    private String risk;
    private String placement_ready;
    private int overallTechScore;
    private LocalDate lastUpdate;
    private String recommendation;

    //create a relationship with candidate
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
            name = "subject_id",
            referencedColumnName = "subject_id"
    )
    private Subject subject;

    public Long getEvaluation_id() {
        return evaluation_id;
    }

    public void setEvaluation_id(Long evaluation_id) {
        this.evaluation_id = evaluation_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRisk() {
        return risk;
    }

    public void setRisk(String risk) {
        this.risk = risk;
    }

    public String getPlacement_ready() {
        return placement_ready;
    }

    public void setPlacement_ready(String placement_ready) {
        this.placement_ready = placement_ready;
    }

    public int getOverallTechScore() {
        return overallTechScore;
    }

    public void setOverallTechScore(int overallTechScore) {
        this.overallTechScore = overallTechScore;
    }

    public LocalDate getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDate lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
