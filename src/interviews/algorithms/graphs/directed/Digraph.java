package interviews.algorithms.graphs.directed;


import interviews.algorithms.graphs.Vertex;
import interviews.algorithms.graphs.Graph;

import java.util.*;

public class Digraph<T> implements Graph<T> {

    Map<T, Vertex<T>> vertexNameToVertex;
    private int numVertices;
    private int numEdges;

    public Digraph() {
        vertexNameToVertex = new HashMap<>();
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

        startingVertex.adjacentVertices.add(endingVertex);
    }

    @Override
    public void addVertex(T vertexName) {
        numVertices++;
        vertexNameToVertex.put(vertexName, new Vertex<>(vertexName));
    }

    @Override
    public List<Vertex<T>> getAdjacentVertices(T vertexName) {
        return vertexNameToVertex.get(vertexName).adjacentVertices;
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

    public static Graph<Integer> tinyIntegerGraph() {
        Graph<Integer> graph = new Digraph<>();
        for (int i = 0; i < 13; i++) {
            graph.addVertex(i);
        }

        graph.addEdge(0, 6);
        graph.addEdge(0, 2);
        graph.addEdge(0, 1);
        graph.addEdge(0, 5);
        graph.addEdge(3, 5);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(7, 8);
        graph.addEdge(9, 10);
        graph.addEdge(9, 11);
        graph.addEdge(9, 12);
        graph.addEdge(11, 12);

        return graph;
    }
}