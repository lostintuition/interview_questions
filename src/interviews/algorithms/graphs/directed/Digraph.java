package interviews.algorithms.graphs.directed;


import interviews.algorithms.graphs.Vertex;
import interviews.algorithms.graphs.Graph;

import java.util.*;

public class Digraph<T> implements Graph<T> {

    Map<T, Vertex<T>> vertexNameToVertex;
    Map<Vertex<T>, Deque<Vertex<T>>> vertexToAdjacentVertices;
    private int numVertices;
    private int numEdges;

    public Digraph() {
        vertexNameToVertex = new HashMap<>();
        vertexToAdjacentVertices = new HashMap<>();
        numVertices = 0;
        numEdges = 0;
    }

    @Override
    public int numVertices() {
        return numVertices;
    }

    @Override
    public int numEdges() {
        return numEdges;
    }

    @Override
    public void addEdge(T startingVertexName, T endingVertexName) {
        numEdges++;
        if (!vertexNameToVertex.containsKey(startingVertexName) || !vertexNameToVertex.containsKey(endingVertexName)) {
            throw new IllegalArgumentException("Tried to add a vertex that does not exist");
        }
        Vertex<T> startingVertex = vertexNameToVertex.get(startingVertexName);
        Vertex<T> endingVertex = vertexNameToVertex.get(endingVertexName);

        vertexToAdjacentVertices.get(startingVertex).push(endingVertex);
        startingVertex.adjacentVertices.add(endingVertex);
    }

    @Override
    public void addVertex(T vertexName) {
        numVertices++;
        Vertex<T> vertex = new Vertex<>(vertexName);
        vertexNameToVertex.put(vertexName, vertex);
        vertexToAdjacentVertices.put(vertex, new ArrayDeque<>());
    }

    @Override
    public Collection<Vertex<T>> getAdjacentVertices(T vertexName) {
        Vertex<T> vertex = vertexNameToVertex.get(vertexName);
        return vertexToAdjacentVertices.get(vertex);
    }

    @Override
    public Vertex<T> getVertex(T vertexName) {
        return vertexNameToVertex.get(vertexName);
    }

    @Override
    public void reset() {
        vertexNameToVertex.values().stream().forEach(Vertex::reset);
    }

    @Override
    public List<Vertex<T>> getVertices() {
        return new ArrayList<>(vertexNameToVertex.values());
    }

    public static Digraph<Integer> tinyIntegerGraph() {
        Digraph<Integer> graph = new Digraph<>();
        for (int i = 0; i < 13; i++) {
            graph.addVertex(i);
        }

        graph.addEdge(4, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 2);
        graph.addEdge(6, 0);
        graph.addEdge(0, 1);
        graph.addEdge(2, 0);
        graph.addEdge(11, 12);
        graph.addEdge(12, 9);
        graph.addEdge(9, 10);
        graph.addEdge(9, 11);
        graph.addEdge(8, 9);
        graph.addEdge(10, 12);
        graph.addEdge(11, 4);
        graph.addEdge(4, 3);
        graph.addEdge(3, 5);
        graph.addEdge(7, 8);
        graph.addEdge(8, 7);
        graph.addEdge(5, 4);
        graph.addEdge(0, 5);
        graph.addEdge(6, 4);
        graph.addEdge(6, 9);
        graph.addEdge(7, 6);

        return graph;
    }
}