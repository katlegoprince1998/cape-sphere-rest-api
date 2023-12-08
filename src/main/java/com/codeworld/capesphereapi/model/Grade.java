package com.codeworld.capesphereapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_grade")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long grd_id;
    private int score;
    private  int total;
    private LocalDate dayGraded;

    //create a relationship with candidate
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "candidateID",
            referencedColumnName = "candidate_id"
    )
    private Candidate candidate;

    //create a relationship with module
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "subject_id",
            referencedColumnName = "subject_id"
    )
    private Subject subject;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public LocalDate getDayGraded() {
        return dayGraded;
    }

    public void setDayGraded(LocalDate dayGraded) {
        this.dayGraded = dayGraded;
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
