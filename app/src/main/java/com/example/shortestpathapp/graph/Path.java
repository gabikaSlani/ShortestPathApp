package com.example.shortestpathapp.graph;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
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
