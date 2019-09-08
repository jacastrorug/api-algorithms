package com.api.algorithms.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Edge implements Serializable {

    @JsonProperty(value = "source")
    private String source;

    @JsonProperty(value = "target")
    private String target;

    @JsonProperty(value = "directed")
    private boolean directed;

    @JsonProperty(value = "distance")
    private double distance;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public boolean isDirected() {
        return directed;
    }

    public void setDirected(boolean directed) {
        this.directed = directed;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {

        return String.format("%s -> %s  distance:%f isDirected:%b", this.getSource(), this.getTarget(), this.getDistance(), this.isDirected());
    }
}
