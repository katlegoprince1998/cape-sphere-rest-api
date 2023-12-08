package com.codeworld.capesphereapi.request;

public class ProgressRequest {
    private double current;
    private double overall;

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
}
