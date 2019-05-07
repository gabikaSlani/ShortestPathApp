package com.example.shortestpathapp.graph;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Graph {

    private Set<Node> nodes;
    private Set<Edge> edges;

    public Graph() {
        nodes = new HashSet<>();
        edges = new HashSet<>();
    }

    public Graph addNode(Node node) {
        this.nodes.add(node);
        return this;
    }

    public void clearNodes(){
        for(Node node: nodes){
            node.setF(0.0);
            node.setG(0.0);
            node.setH(0.0);
            node.setParent(null);
        }
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
        Optional<Node> node = nodes.stream().filter(n -> n.getName().equals(name)).findFirst();
        return node.isPresent() ? node.get() : null;
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
