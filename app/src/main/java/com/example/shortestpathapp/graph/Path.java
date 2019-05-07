package com.example.shortestpathapp.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Path {

    private List<Node> path;

    public Path() {
        this.path = new ArrayList<>();
    }

    public void addNode(Node node){
        this.path.add(node);
    }

    public boolean isEmpty() {
        return path.isEmpty();
    }

    public Node getStart() {
        if (path == null || path.isEmpty()) {
            return null;
        }
        return path.get(path.size()-1);
    }

    public Node getEnd() {
        if (path == null || path.isEmpty()) {
            return null;
        }
        return path.get(0);
    }

    public boolean areNeighborsInPath(Node node1, Node node2) {
        if (!path.contains(node1) || !path.contains(node2)) {
            return false;
        }
        int positionOfNode1 = path.indexOf(node1);
        if (positionOfNode1 - 1 >= 0 && path.get(positionOfNode1 - 1) == node2) {
            return true;
        }
        return positionOfNode1 + 1 <= path.size() - 1 && path.get(positionOfNode1 + 1) == node2;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        ListIterator it = this.path.listIterator(this.path.size());

        while (it.hasPrevious()) {
            string.append(it.previous());
            string.append(" -> ");
        }
        return string.toString().substring(0, string.length()-3);
    }
}
