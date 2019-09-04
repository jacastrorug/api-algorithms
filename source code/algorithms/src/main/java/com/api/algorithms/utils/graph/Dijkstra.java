package com.api.algorithms.utils.graph;

import com.api.algorithms.utils.models.Edge;
import com.api.algorithms.utils.models.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class Dijkstra extends Graph {

    private String source;

    private String target;

    private ArrayList<Integer> path;

    private double distance;


    public Dijkstra(Node[] nodes, Edge[] edges, String source, String target) {
        super(nodes, edges);

        this.source = source;
        this.target = target;

    }


    public double calculateMinPath() {

        double min = -1;
        int source = this.nodeIndex.get(this.source);
        int target = this.nodeIndex.get(this.target);

        if (Math.pow(nodes.length, 1.3) < edges.length) {
            //Es un grafo denso
            double[][] adjMatrix = parseAdjacentMatrix();
            min = minPath(adjMatrix, source, target);
        } else {
            ArrayList<ArrayList<double[]>> adjList = parseAdjacentList();
            min = minPath(adjList, source, target);
        }

        return min;
    }


    public static double minPath(double[][] adjacentMatrix, int source, int target) {

        double[] distances = new double[adjacentMatrix.length];
        boolean[] expanded = new boolean[adjacentMatrix.length];

        Arrays.fill(distances, Double.MAX_VALUE);

        ArrayDeque<Integer> q = new ArrayDeque<>();
        distances[source] = 0;
        q.add(source);

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v = 0; v < adjacentMatrix.length; v++) {
                if (u != v) {
                    if (distances[v] > distances[u] + adjacentMatrix[u][v]) {
                        distances[v] = distances[u] + adjacentMatrix[u][v];
                    }
                    if (!expanded[v])
                        q.add(v);
                }

            }
            expanded[u] = true;
        }


        return distances[target];
    }

    public static double minPath(ArrayList<ArrayList<double[]>> adjacentList, int source, int target) {

        double[] distances = new double[adjacentList.size()];
        boolean[] expanded = new boolean[adjacentList.size()];

        Arrays.fill(distances, Double.MAX_VALUE);

        ArrayDeque<Integer> q = new ArrayDeque<>();
        distances[source] = 0;
        q.add(source);

        while (!q.isEmpty()) {
            int u = q.poll();
            for (double[] edge : adjacentList.get(u)) {
                int v = (int) edge[0];
                double distanceV = edge[1];

                if (u != v) {
                    if (distances[v] > distances[u] + distanceV) {
                        distances[v] = distances[u] + distanceV;
                    }
                    if (!expanded[v])
                        q.add(v);
                }
            }
            expanded[u] = true;
        }

        return distances[source];
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
}
