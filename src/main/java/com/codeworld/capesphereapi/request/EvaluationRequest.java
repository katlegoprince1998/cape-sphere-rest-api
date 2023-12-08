package com.codeworld.capesphereapi.request;

import java.time.LocalDate;

public class EvaluationRequest {
    private String status;
    private String risk;
    private String placement_ready;
    private int overallTechScore;
    private LocalDate lastUpdate;
    private String recommendation;

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
}
