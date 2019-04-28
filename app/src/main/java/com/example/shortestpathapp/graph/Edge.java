package com.example.shortestpathapp.graph;
public class Edge {

    private Node node1;
    private Node node2;
    private Double cost;


    public Edge(Node node1, Node node2, double cost) {
        this.node1 = node1;
        this.node2 = node2;
        this.cost = cost;
    }

    public Node getNode1() {
        return node1;
    }

    public void setNode1(Node node1) {
        this.node1 = node1;
    }

    public Node getNode2() {
        return node2;
    }

    public void setNode2(Node node2) {
        this.node2 = node2;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
}
