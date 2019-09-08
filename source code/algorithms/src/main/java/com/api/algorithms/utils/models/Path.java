package com.api.algorithms.utils.models;

import com.api.algorithms.dto.Node;
import com.api.algorithms.utils.graph.Dijkstra;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;

public class Path {

    @JsonProperty(value = "path")
    private HashMap<String, String> path;


    public Path(Dijkstra dijkstra) {
        int[] pathIndex = dijkstra.getPath();
        Node[] nodes = dijkstra.getNodes();

        HashMap<String, String> path = new HashMap<>();

        for (int i = 0; i < pathIndex.length; i++) {
            if (pathIndex[i] == -1)
                continue;

            String u = nodes[i].getId();
            String v = nodes[pathIndex[i]].getId();
            path.put(u, v);
        }

        this.path = path;
    }


    public HashMap<String, String> getPath() {
        return path;
    }

    public void setPath(HashMap<String, String> path) {
        this.path = path;
    }
}
