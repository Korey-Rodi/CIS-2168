package com.example;

import edu.uci.ics.jung.graph.SparseGraph;

public class GraphTest {
    public static void main(String[] args) {

        SparseGraph<Integer, String> g = new SparseGraph<>();

        g.addVertex(2);
        g.addVertex(3);

        g.addEdge("23", 2, 3);

        System.out.println(g);
    }
}