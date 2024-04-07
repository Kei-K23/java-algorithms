package graph;

import java.util.*;

/**
 * Represents an undirected graph using adjacency list representation.
 */
public class Graph {
    private Map<Integer, List<Integer>> adjacencyList; // Map to store the adjacency list of each node

    /**
     * Constructs a new Graph object.
     */
    public Graph() {
        this.adjacencyList = new HashMap<>(); // Initialize the adjacency list
    }

    /**
     * Adds a node to the graph.
     * 
     * @param node The node to be added
     */
    public void addNode(int node) {
        if (!this.adjacencyList.containsKey(node)) {
            this.adjacencyList.put(node, new ArrayList<>()); // Add a new node with an empty list of neighbors
        }
    }

    /**
     * Adds an edge between two nodes in the graph.
     * 
     * @param source      The source node of the edge
     * @param destination The destination node of the edge
     */
    public void addEdge(int source, int destination) {
        this.adjacencyList.get(source).add(destination); // Add destination to the list of neighbors of source
        this.adjacencyList.get(destination).add(source); // Add source to the list of neighbors of destination (for
                                                         // undirected graph)
    }

    /**
     * Removes a node from the graph.
     * 
     * @param node The node to be removed
     */
    public void removeNode(int node) {
        List<Integer> neighbors = adjacencyList.get(node);

        for (Integer neighbor : neighbors) {
            adjacencyList.get(neighbor).remove((Integer) node); // Remove node from the neighbor lists of other nodes
        }

        adjacencyList.remove(node); // Remove the node from the adjacency list
    }

    /**
     * Removes an edge between two nodes in the graph.
     * 
     * @param source      The source node of the edge
     * @param destination The destination node of the edge
     */
    public void removeEdge(int source, int destination) {
        this.adjacencyList.get(source).remove((Integer) destination); // Remove destination from the neighbor list of
                                                                      // source
        this.adjacencyList.get(destination).remove((Integer) source); // Remove source from the neighbor list of
                                                                      // destination (for undirected graph)
    }

    /**
     * Performs a breadth-first search traversal starting from the specified node.
     * 
     * @param start The starting node for the traversal
     * @return A list containing the nodes visited during the traversal
     */
    public List<Integer> bfsTraversal(int start) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            result.add(currentNode);

            for (int neighbor : adjacencyList.get(currentNode)) {
                if (!visited.contains(neighbor)) {
                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
            }
        }

        return result;
    }

    /**
     * Performs a depth-first search traversal starting from the specified node.
     * 
     * @param start The starting node for the traversal
     * @return A list containing the nodes visited during the traversal
     */
    public List<Integer> dfsTraversal(int start) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        dfsHelper(start, visited, result);
        return result;
    }

    /**
     * Helper method for depth-first search traversal.
     * 
     * @param currentNode The current node being visited
     * @param visited     A set containing the visited nodes
     * @param result      A list to store the traversal result
     */
    private void dfsHelper(int currentNode, Set<Integer> visited, List<Integer> result) {
        visited.add(currentNode);
        result.add(currentNode);

        for (int neighbor : adjacencyList.get(currentNode)) {
            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, visited, result);
            }
        }
    }
}
