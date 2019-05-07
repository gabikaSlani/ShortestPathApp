package com.example.shortestpathapp;

import com.example.shortestpathapp.graph.Edge;
import com.example.shortestpathapp.graph.Graph;
import com.example.shortestpathapp.graph.Node;
import com.example.shortestpathapp.graph.Path;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainActivityController {

    public static double euclideanDist(Node node1, Node node2) {
        return Math.sqrt(
                Math.pow((node1.getPos_x() - node2.getPos_x()), 2)
                        +
                        Math.pow((node1.getPos_y() - node2.getPos_y()), 2)
        );
    }

    public static Node getLowestDistanceNode(Set<Node> unsettledNodes) {
        Node lowestDistanceNode = null;
        double lowestDistance = Double.MAX_VALUE;
        for (Node node : unsettledNodes) {
            double nodeDistance = node.getF();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }

    public static Path aStarSearch(Graph graph, Node source, Node target) {
        Set<Node> settled = new HashSet<>();
        Set<Node> unsettled = new HashSet<>();
        source.setF(euclideanDist(source, target));
        unsettled.add(source);
        while (!unsettled.isEmpty()) {
            Node current = getLowestDistanceNode(unsettled);
            unsettled.remove(current);
            settled.add(current);

            if (current.equals(target)) {
                return getPath(target);
            }

            Set<Node> neighbours = current.getNeighbours();
            for (Node neighbour : neighbours) {
                double g = current.getG() + graph.getEdgeCost(current, neighbour);
                double h = euclideanDist(neighbour, target);
                double f = g + h;

                if(!(unsettled.contains(neighbour) || settled.contains(neighbour)) || neighbour.getF() > f){
                    unsettled.add(neighbour);
                    neighbour.setParent(current);
                    neighbour.setG(g);
                    neighbour.setH(h);
                    neighbour.setF(f);
                }
            }
        }
        return new Path();
    }

    public static Path getPath(Node target) {
        Path path = new Path();

        for (Node node = target; node != null; node = node.getParent()) {
            path.addNode(node);
        }

        return path;
    }

    public static Graph generateGraph() {
        Graph graph = new Graph();
        Node nodeA = new Node("A", 0.0, 0.0);
        Node nodeB = new Node("B", 0.0, 5.0);
        Node nodeC = new Node("C", 2.0, 7.0);
        Node nodeD = new Node("D", 3.0, 2.0);
        Node nodeE = new Node("E", 5.0, 4.0);
        Node nodeF = new Node("F", 5.0, 8.0);
        Node nodeG = new Node("G", 7.0, 6.0);
        graph.addNode(nodeA).addNode(nodeB).addNode(nodeC).addNode(nodeD)
                .addNode(nodeE).addNode(nodeF).addNode(nodeG);

        graph
                .addEdge(new Edge(nodeA, nodeB, 8))
                .addEdge(new Edge(nodeA, nodeC, 13))
                .addEdge(new Edge(nodeA, nodeD, 3))
                .addEdge(new Edge(nodeB, nodeE, 9))
                .addEdge(new Edge(nodeB, nodeD, 4))
                .addEdge(new Edge(nodeB, nodeG, 12))
                .addEdge(new Edge(nodeC, nodeF, 4))
                .addEdge(new Edge(nodeD, nodeF, 11))
                .addEdge(new Edge(nodeD, nodeE, 2))
                .addEdge(new Edge(nodeE, nodeG, 2))
                .addEdge(new Edge(nodeF, nodeG, 4));


        return graph;
    }

    public static Graph generateGraph1() {
        Graph graph = new Graph();
        Node nodeA = new Node("A", 0.0, 0.0);
        Node nodeB = new Node("B", 0.2, 3.5);
        Node nodeC = new Node("C", 0.0, 6.3);
        Node nodeD = new Node("D", 2.7, 0.2);
        Node nodeE = new Node("E", 2.0, 2.0);
        Node nodeF = new Node("F", 2.5, 4.5);
        Node nodeG = new Node("G", 2.0, 6.7);
        Node nodeH = new Node("H", 5.0, 1.0);
        Node nodeI = new Node("I", 5.0, 4.0);
        Node nodeJ = new Node("J", 4.8, 6.4);
        Node nodeK = new Node("K", 7.0, 0.0);
        Node nodeL = new Node("L", 7.0, 2.5);
        Node nodeM = new Node("M", 7.0, 5.0);
        Node nodeN = new Node("N", 7.0, 7.0);
        Node nodeO = new Node("O", 9.0, 2.6);
        graph.addNode(nodeA).addNode(nodeB).addNode(nodeC).addNode(nodeD)
                .addNode(nodeE).addNode(nodeF).addNode(nodeG).addNode(nodeH)
                .addNode(nodeI).addNode(nodeJ).addNode(nodeK).addNode(nodeL)
                .addNode(nodeM).addNode(nodeN).addNode(nodeO);

        graph
                .addEdge(new Edge(nodeA, nodeB, 10))
                .addEdge(new Edge(nodeA, nodeE, 8))
                .addEdge(new Edge(nodeA, nodeD, 6))
                .addEdge(new Edge(nodeA, nodeE, 8))
                .addEdge(new Edge(nodeB, nodeC, 20))
                .addEdge(new Edge(nodeB, nodeG, 14))
                .addEdge(new Edge(nodeB, nodeF, 2))
                .addEdge(new Edge(nodeC, nodeG, 6))
                .addEdge(new Edge(nodeD, nodeH, 6))
                .addEdge(new Edge(nodeD, nodeI, 8))
                .addEdge(new Edge(nodeE, nodeI, 16))
                .addEdge(new Edge(nodeF, nodeI, 10))
                .addEdge(new Edge(nodeG, nodeJ, 8))
                .addEdge(new Edge(nodeH, nodeK, 6))
                .addEdge(new Edge(nodeH, nodeL, 4))
                .addEdge(new Edge(nodeI, nodeJ, 4))
                .addEdge(new Edge(nodeI, nodeL, 6))
                .addEdge(new Edge(nodeI, nodeM, 2))
                .addEdge(new Edge(nodeJ, nodeM, 4))
                .addEdge(new Edge(nodeJ, nodeN, 2))
                .addEdge(new Edge(nodeK, nodeO, 4))
                .addEdge(new Edge(nodeL, nodeO, 6))
                .addEdge(new Edge(nodeM, nodeO, 8))
                .addEdge(new Edge(nodeN, nodeO, 14));
        return graph;
    }

    public static Path findShortestPath(Graph graph, String nodeName1, String nodeName2){
        Node source = graph.getNode(nodeName1);
        Node target = graph.getNode(nodeName2);
        return aStarSearch(graph, source, target);
    }
}
