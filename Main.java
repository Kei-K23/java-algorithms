import java.util.List;

import graph.Graph;

public class Main {
  public static void main(String[] args) {
    // import the data structure and test them below

    Graph graph = new Graph();

    graph.addNode(1);
    graph.addNode(2);
    graph.addNode(3);
    graph.addNode(4);

    graph.addEdge(1, 2);
    graph.addEdge(1, 3);
    graph.addEdge(2, 4);
    graph.addEdge(3, 4);

    // Perform BFS traversal starting from node 1
    List<Integer> bfsResult = graph.bfsTraversal(1);
    System.out.println("BFS Traversal: " + bfsResult);

    // Perform DFS traversal starting from node 1
    List<Integer> dfsResult = graph.dfsTraversal(1);
    System.out.println("DFS Traversal: " + dfsResult);
  }
}
