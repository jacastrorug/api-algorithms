package com.api.algorithms.utils.graph;

import com.api.algorithms.utils.models.Edge;
import com.api.algorithms.utils.models.Node;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {

    Node[] nodes;

    Edge[] edges;

    HashMap<String, Integer> nodeIndex;

    HashMap<Integer, String> indexNode;


    public Graph(Node[] nodes, Edge[] edges) {
        this.nodes = nodes;
        this.edges = edges;

        this.nodeIndex = new HashMap<>(this.nodes.length);
        this.indexNode = new HashMap<>(this.nodes.length);
        for (int i = 0; i < this.nodes.length; i++) {
            Node node = this.nodes[i];
            this.nodeIndex.put(node.getId(), i);
            this.indexNode.put(i, node.getId());
        }

    }


    double[][] parseAdjacentMatrix() {

        double[][] adjacentMatrix = new double[nodes.length][nodes.length];

        for (Edge e : edges) {
            int indexA = nodeIndex.get(e.getSource());
            int indexB = nodeIndex.get(e.getTarget());
            adjacentMatrix[indexA][indexB] = e.getDistance();

            if (!e.isDirected()) {
                adjacentMatrix[indexB][indexA] = e.getDistance();
            }

        }

        return adjacentMatrix;
    }

    ArrayList<ArrayList<double[]>> parseAdjacentList() {
        ArrayList<ArrayList<double[]>> adjacentList = new ArrayList<>(nodes.length);

        for (int i = 0; i < nodes.length; i++) {
            adjacentList.set(i, new ArrayList<>());
        }

        for (Edge e : edges) {
            int indexA = nodeIndex.get(e.getSource());
            int indexB = nodeIndex.get(e.getTarget());
            adjacentList.get(indexA).add(new double[]{indexB, e.getDistance()});

            if (!e.isDirected()) {
                adjacentList.get(indexB).add(new double[]{indexA, e.getDistance()});
            }
        }

        return adjacentList;
    }

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

    public HashMap<String, Integer> getNodeIndex() {
        return nodeIndex;
    }

    public void setNodeIndex(HashMap<String, Integer> nodeIndex) {
        this.nodeIndex = nodeIndex;
    }
}
