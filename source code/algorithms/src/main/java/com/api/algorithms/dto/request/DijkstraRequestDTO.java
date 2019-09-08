package com.api.algorithms.dto.request;

import com.api.algorithms.dto.Edge;
import com.api.algorithms.dto.Node;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class DijkstraRequestDTO implements Serializable {

    @JsonProperty(value = "nodes", required = true)
    private Node[] nodes;

    @JsonProperty(value = "edges", required = true)
    private Edge[] edges;

    @JsonProperty(value = "source", required = true)
    private String source;

    @JsonProperty(value = "target", required = true)
    private String target;

    @JsonProperty(value = "withPath", required = true)
    private boolean withPath;

    public Node[] getNodes() {
        return nodes;
    }

    public void setNodes(Node[] nodes) {
        this.nodes = nodes;
    }

    public Edge[] getEdges() {
        return edges;
    }

    public void setEdges(Edge[] edges) {
        this.edges = edges;
    }

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

    public boolean isWithPath() {
        return withPath;
    }

    public void setWithPath(boolean withPath) {
        this.withPath = withPath;
    }
}
