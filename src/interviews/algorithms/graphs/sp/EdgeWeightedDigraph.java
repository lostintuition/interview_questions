package interviews.algorithms.graphs.sp;

import java.util.*;

public class EdgeWeightedDigraph<T> {
    Map<T, List<DirectedEdge<T>>> vertexNameToEdges;
    private int numVertices;
    private int numEdges;

    public EdgeWeightedDigraph() {
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

    public void addEdge(T from, T to, double weight) {
        numEdges++;
        if (!vertexNameToEdges.containsKey(from) || !vertexNameToEdges.containsKey(to)) {
            throw new IllegalArgumentException("Tried to add a vertex that does not exist");
        }
        DirectedEdge<T> edge = new DirectedEdge<>(from, to, weight);

        vertexNameToEdges.get(from).add(edge);
    }

    public void addVertex(T vertexName) {
        numVertices++;
        vertexNameToEdges.put(vertexName, new ArrayList<>());
    }

    public Collection<DirectedEdge<T>> getAdjacentEdges(T vertexName) {
        return vertexNameToEdges.get(vertexName);
    }

    public Collection<T> getVertices() {
        return vertexNameToEdges.keySet();
    }

    public Collection<DirectedEdge<T>> getEdges() {
        Set<DirectedEdge<T>> edges = new HashSet<>();
        vertexNameToEdges.values().forEach(edges::addAll);
        return edges;
    }

    public static EdgeWeightedDigraph<Integer> tinyIntegerGraph() {
        EdgeWeightedDigraph<Integer> graph = new EdgeWeightedDigraph<>();
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
