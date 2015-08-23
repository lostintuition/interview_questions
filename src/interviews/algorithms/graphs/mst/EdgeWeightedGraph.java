package interviews.algorithms.graphs.mst;


import interviews.algorithms.graphs.Graph;
import interviews.algorithms.graphs.Vertex;
import interviews.algorithms.graphs.undirected.UndirectedGraph;

import java.util.*;

public class EdgeWeightedGraph<T> {

    Map<T, List<Edge<T>>> vertexNameToEdges;
    private int numVertices;
    private int numEdges;

    public EdgeWeightedGraph() {
        vertexNameToEdges = new HashMap<>();
        numVertices = 0;
        numEdges = 0;
    }

    public int numVertices() {
        return numVertices;
    }

    public int numEdges() {
        return numEdges;
    }

    public void addEdge(T startingVertexName, T endingVertexName, double weight) {
        numEdges++;
        if (!vertexNameToEdges.containsKey(startingVertexName) || !vertexNameToEdges.containsKey(endingVertexName)) {
            throw new IllegalArgumentException("Tried to add a vertex that does not exist");
        }
        Edge<T> edge = new Edge<>(startingVertexName, endingVertexName, weight);

        vertexNameToEdges.get(startingVertexName).add(edge);
        vertexNameToEdges.get(endingVertexName).add(edge);
    }

    public void addVertex(T vertexName) {
        numVertices++;
        vertexNameToEdges.put(vertexName, new ArrayList<>());
    }

    public Collection<Edge<T>> getAdjacentEdges(T vertexName) {
        return vertexNameToEdges.get(vertexName);
    }

    public Collection<Edge<T>> getEdges() {
        Set<Edge<T>> edges = new HashSet<>();
        vertexNameToEdges.values().forEach(edges::addAll);
        return edges;
    }

    public static EdgeWeightedGraph<Integer> tinyIntegerGraph() {
        EdgeWeightedGraph<Integer> graph = new EdgeWeightedGraph<>();
        for (int i = 0; i < 13; i++) {
            graph.addVertex(i);
        }

        graph.addEdge(0, 6, 1);
        graph.addEdge(0, 2, 2);
        graph.addEdge(0, 1, 3);
        graph.addEdge(0, 5, 4);
        graph.addEdge(3, 5, 5);
        graph.addEdge(3, 4, 6);
        graph.addEdge(4, 5, 7);
        graph.addEdge(4, 6, 8);
        graph.addEdge(7, 8, 9);
        graph.addEdge(9, 10, 10);
        graph.addEdge(9, 11, 11);
        graph.addEdge(9, 12, 12);
        graph.addEdge(11, 12, 13);

        return graph;
    }
}