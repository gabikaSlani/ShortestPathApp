package com.example.shortestpathapp.graph;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Path {

    private List<Node> path;


    public Path() {
        this.path = new LinkedList<>();
    }

    public void addNode(Node node){
        this.path.add(node);
    }


    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        Iterator<?> it = this.path.iterator();

        while (it.hasNext()) {
            string.append(it.next());
            string.append(" -> ");
        }

        return "Path{" + string + '}';
    }
}
