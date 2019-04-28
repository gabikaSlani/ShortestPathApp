package com.example.shortestpathapp.graph;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Graph {

    private Set<Node> nodes = new HashSet<>();
    private Set<Edge> edges = new HashSet<>();

    public Graph() {
    }

    public Graph addNode(Node node) {
        this.nodes.add(node);
        return this;
    }

    public Graph addEdge(Edge edge) {
        this.edges.add(edge);
        Node node1 = edge.getNode1();
        Node node2 = edge.getNode2();
        this.edges.add(new Edge(node2, node1, edge.getCost()));
        node1.addNeighbour(node2);
        node2.addNeighbour(node1);
        return this;
    }

    public Set<Node> getNodes() {
        return nodes;
    }

    public Set<Edge> getEdges() {
        return edges;
    }

    public Node getNode(String name) {
        return nodes.stream().filter(node -> node.getName().equals(name)).findFirst().get();
    }

    public double getEdgeCost(Node node1, Node node2) {
        for (Edge edge : edges) {
            if (edge.getNode1().equals(node1) && edge.getNode2().equals(node2)) {
                return edge.getCost();
            }
        }
        return -1;
    }

    public double getMinimalXPos() {
        Optional<Node> node = nodes.stream()
                .min((node1, node2) -> node1.getPos_x().compareTo(node2.getPos_x()));
        return node.isPresent() ? node.get().getPos_x() : null;
    }

    public double getMaximalXPos() {
        Optional<Node> node = nodes.stream()
                .max((node1, node2) -> node1.getPos_x().compareTo(node2.getPos_x()));
        return node.isPresent() ? node.get().getPos_x() : null;
    }

    public double getMinimalYPos() {
        Optional<Node> node = nodes.stream()
                .min((node1, node2) -> node1.getPos_y().compareTo(node2.getPos_y()));
        return node.isPresent() ? node.get().getPos_y() : null;
    }

    public double getMaximalYPos() {
        Optional<Node> node = nodes.stream()
                .max((node1, node2) -> node1.getPos_y().compareTo(node2.getPos_y()));
        return node.isPresent() ? node.get().getPos_y() : null;
    }
}
