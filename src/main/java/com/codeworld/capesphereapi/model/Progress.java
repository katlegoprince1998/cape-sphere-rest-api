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
            name = "subject_id",
            referencedColumnName = "subject_id"
    )
    private Subject subject;

    public double getCurrent() {
        return current;
    }

    public void setCurrent(double current) {
        this.current = current;
    }

    public double getOverall() {
        return overall;
    }

    public void setOverall(double overall) {
        this.overall = overall;
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
