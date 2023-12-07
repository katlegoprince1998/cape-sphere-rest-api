package com.codeworld.capesphereapi.request;

import java.time.LocalDate;

public class GradeRequest {
    private int score;
    private  int total;

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

    private LocalDate dayGraded;
}
