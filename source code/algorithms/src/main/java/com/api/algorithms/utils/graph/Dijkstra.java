package com.api.algorithms.utils.graph;

import com.api.algorithms.dto.Edge;
import com.api.algorithms.dto.Node;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class Dijkstra extends Graph implements Serializable {

    @JsonProperty(value = "source", required = true)
    private String source;

    @JsonProperty(value = "target", required = true)
    private String target;

    @JsonProperty(value = "path", required = true)
    private int[] path;

    @JsonProperty(value = "edgesPath", required = true)
    private Edge edgesPath;

    @JsonProperty(value = "distance", required = true)
    private double distance;


    public Dijkstra(Node[] nodes, Edge[] edges, String source, String target) {
        super(nodes, edges);

        this.source = source;
        this.target = target;

    }


    public double calculateMinPath() {

        int[] path = new int[nodes.length];
        Arrays.fill(path, -1);

        int source = nodeIndex.get(this.source);
        int target = nodeIndex.get(this.target);

        double min;
        if (Math.pow(nodes.length, 1.3) < edges.length) {
            //Es un grafo denso
            double[][] adjMatrix = parseAdjacentMatrix();
            min = minPath(adjMatrix, source, target, path);
        } else {
            ArrayList<ArrayList<double[]>> adjList = parseAdjacentList();
            min = minPath(adjList, source, target, path);
        }

        this.distance = min;
        this.path = path;

        return min;
    }


    public static double minPath(double[][] adjacentMatrix, int source, int target, int[] path) {

        double[] distances = new double[adjacentMatrix.length];
        boolean[] expanded = new boolean[adjacentMatrix.length];

        Arrays.fill(distances, Double.MAX_VALUE);

        ArrayDeque<Integer> q = new ArrayDeque<>();
        distances[source] = 0;
        expanded[source] = true;
        q.add(source);

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v = 0; v < adjacentMatrix.length; v++) {
                if (u == v || adjacentMatrix[u][v] <= 0)
                    continue;

                if (distances[v] > distances[u] + adjacentMatrix[u][v]) {
                    distances[v] = distances[u] + adjacentMatrix[u][v];
                    path[u] = v;
                }

                if (!expanded[v]) {
                    expanded[v] = true;
                    q.add(v);
                }
            }
        }

        return distances[target];
    }

    public static double minPath(ArrayList<ArrayList<double[]>> adjacentList, int source, int target, int[] path) {

        double[] distances = new double[adjacentList.size()];
        boolean[] expanded = new boolean[adjacentList.size()];

        Arrays.fill(distances, Double.MAX_VALUE);

        ArrayDeque<Integer> q = new ArrayDeque<>();
        distances[source] = 0;
        q.add(source);

        while (!q.isEmpty()) {
            int u = q.poll();
            expanded[u] = true;
            for (double[] edge : adjacentList.get(u)) {
                int v = (int) Math.round(edge[0]);
                double distanceV = edge[1];

                if (u != v) {
                    if (distances[v] > distances[u] + distanceV) {
                        distances[v] = distances[u] + distanceV;
                        path[u] = v;
                    }
                    if (!expanded[v])
                        q.add(v);
                }
            }
        }
        return distances[target];
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

    public int[] getPath() {
        return path;
    }

    public void setPath(int[] path) {
        this.path = path;
    }

    public Edge getEdgesPath() {
        return edgesPath;
    }

    public void setEdgesPath(Edge edgesPath) {
        this.edgesPath = edgesPath;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

}
