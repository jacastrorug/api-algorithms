package com.api.algorithms.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;

public class DijkstraResponse extends BaseResponse {

    @JsonProperty(value = "minPath")
    private double minPath;

    @JsonProperty(value = "path")
    private HashMap<String, String> path;


    public DijkstraResponse(double minPath) {
        this(minPath, null);
    }

    public DijkstraResponse(double minPath, HashMap<String, String> path) {
        super("Procesado con éxito");
        this.minPath = minPath;
        this.path = path;
    }

    public double getMinPath() {
        return minPath;
    }

    public void setMinPath(double minPath) {
        this.minPath = minPath;
    }

    public HashMap<String, String> getPath() {
        return path;
    }

    public void setPath(HashMap<String, String> path) {
        this.path = path;
    }
}
