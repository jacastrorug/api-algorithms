package com.api.algorithms.utils.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;

public class Node {

    @JsonProperty(value = "id")
    private String id;

    @JsonProperty(value = "properties")
    private HashMap<String, String> properties;

    public Node(String id) {
        this(id, new HashMap<>());
    }

    public Node(String id, HashMap<String, String> properties) {
        this.id = id;
        this.properties = properties;
    }

    public String getId() {
        return this.id;
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
