package com.api.algorithms.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.HashMap;

public class Node implements Serializable {

    @JsonProperty(value = "id")
    private String id;

    @JsonProperty(value = "properties")
    private HashMap<String, String> properties;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public HashMap<String, String> getProperties() {
        return this.properties;
    }

    public void setProperties(HashMap<String, String> properties) {
        this.properties = properties;
    }

    public void setProperty(String key, String value) {
        if (this.properties.containsKey(key)) {
            this.properties.put(key, value);
        } else {
            this.addProperty(key, value);
        }
    }

    public void addProperty(String key, String value) {
        this.properties.put(key, value);
    }


}
