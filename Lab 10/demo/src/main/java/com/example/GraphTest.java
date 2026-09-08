package com.example;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import edu.uci.ics.jung.graph.SparseMultigraph;

public class GraphTest {
    public static void DFS(SparseMultigraph<Integer, String> g, Integer curr, Set<Integer> visited) {
    //System.out.println(visited);

    /*Start at vertex
    Visit it
    Choose adjacent one to visit
    Then choose a vertex adjacent to that vertex to visit
    And so on until you can go no further
    Then back up and see whether a new vertex can be found */
    visited.add(curr);
    System.out.println(curr);

    for (Integer neighbor : g.getNeighbors(curr)) {
        if (!visited.contains(neighbor)) {
            DFS(g, neighbor, visited);
        }
    }
}


    public static void BFS(SparseMultigraph<Integer, String> g, Integer startNode) {
    Queue<Integer> queue = new LinkedList<>();
    Set<Integer> visited = new HashSet<>();

    queue.add(startNode);
    visited.add(startNode);
    /*Visit the start node first
    Then all the nodes adjacent to it
    Then all nodes that can be reached by a path from the start node containing two edges
    Then all nodes that can be reached by a path from the start node containing three edges
    And so on */

    while (!queue.isEmpty()) {
        //System.out.println(queue);
        //System.out.println(visited);
        int curr = queue.poll(); // Gets first element of the queue
        System.out.println(curr);

        for (int neighbor : g.getNeighbors(curr)) {
            if(!visited.contains(neighbor)) {
                visited.add(neighbor);
                queue.add(neighbor);
            }
        }
    }
}
    public static void main(String[] args) {
        SparseMultigraph<Integer, String> g = new SparseMultigraph<>();
        g.addEdge("Edge-12", 1, 2);
        g.addEdge("Edge-13", 1, 3);
        g.addEdge("Edge-24", 2, 4);
        g.addEdge("Edge-34", 3, 4);
        System.out.println("Breadth First Search");
        BFS(g,1);
        HashSet<Integer> hs = new HashSet<>();
        System.out.println("Depth First Search");
        DFS(g,1,hs);
    }
}