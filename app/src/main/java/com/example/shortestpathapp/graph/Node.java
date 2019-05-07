package com.example.shortestpathapp.graph;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Node {

    private String name;
    private Double pos_x;
    private Double pos_y;
    private Double g;
    private Double h;
    private Double f;
    private Node parent;
    private Set<Node> neighbours;

    public Node(String name, double pos_x, double pos_y) {
        this.name = name;
        this.pos_x = pos_x;
        this.pos_y = pos_y;
        this.neighbours = new HashSet<>();
        this.f = 0.0;
        this.h = 0.0;
        this.g = 0.0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPos_x() {
        return pos_x;
    }

    public void setPos_x(Double pos_x) {
        this.pos_x = pos_x;
    }

    public Double getPos_y() {
        return pos_y;
    }

    public void setPos_y(Double pos_y) {
        this.pos_y = pos_y;
    }


    public Double getF() {
        return f;
    }

    public void setF(Double f) {
        this.f = f;
    }
    public Double getG() {
        return g;
    }

    public void setG(Double g) {
        this.g = g;
    }
    public Double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public void addNeighbour(Node neighbour){
        this.neighbours.add(neighbour);
    }

    public Set<Node> getNeighbours(){
        return neighbours;
    }

    public void setParent(Node parent){
        this.parent = parent;
    }

    public Node getParent(){
        return this.parent;
    }


    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Double.compare(node.pos_x, pos_x) == 0 &&
                Double.compare(node.pos_y, pos_y) == 0 &&
                name.equals(node.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, pos_x, pos_y);
    }
}
