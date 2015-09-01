package interviews.algorithms.graphs.sp;

import interviews.algorithms.graphs.mst.Edge;

import java.util.*;

public class DijkstraShortestPaths<T> {

    EdgeWeightedDigraph<T> graph;
    PriorityQueue<Vertex> priorityQueue;
    Map<T, Vertex> vertexNameToVertex;

    public DijkstraShortestPaths(EdgeWeightedDigraph<T> graph, T sourceVertexName) {
        this.graph = graph;
        this.priorityQueue = new PriorityQueue<>();
        this.vertexNameToVertex = new HashMap<>();

        for (T vertexName: graph.getVertices()) {
            Vertex vertex = new Vertex(vertexName, Double.MAX_VALUE);
            vertexNameToVertex.put(vertexName, vertex);
        }

        updateVertex(sourceVertexName, 0.0);

        while (!priorityQueue.isEmpty()) {
            relax(priorityQueue.remove());
        }
    }

    private void relax(Vertex vertex) {
        for (DirectedEdge<T> edge: graph.getAdjacentEdges(vertex.vertexName)) {
            T toVertexName = edge.to();
            Vertex toVertex = vertexNameToVertex.get(toVertexName);
            if (edge.weight() + vertex.distance < toVertex.distance) {
                toVertex.edgeTo = edge;
                updateVertex(toVertexName, edge.weight() + vertex.distance);
            }
        }
    }

    public double distanceTo(T vertexName) {
        Vertex vertex = vertexNameToVertex.get(vertexName);
        return vertex.distance;
    }

    public boolean hasPathTo(T vertexName) {
        return distanceTo(vertexName) < Double.MAX_VALUE;
    }

    public Collection<DirectedEdge<T>> pathTo(T vertexName) {
        if (!hasPathTo(vertexName)) {
            return null;
        }

        Deque<DirectedEdge<T>> path = new ArrayDeque<>();
        Vertex vertex = vertexNameToVertex.get(vertexName);
        DirectedEdge<T> currentEdge = vertex.edgeTo;
        while (currentEdge != null) {
            path.push(currentEdge);
            currentEdge = vertexNameToVertex.get(currentEdge.from()).edgeTo;
        }

        return path;
    }

    private void updateVertex(T vertexName, double distance) {
        Vertex vertex = vertexNameToVertex.get(vertexName);
        if (priorityQueue.contains(vertex)) {
            priorityQueue.remove(vertex);
        }
        vertex.distance = distance;
        priorityQueue.add(vertex);
    }

    private class Vertex implements Comparable<Vertex> {

        double distance;
        T vertexName;
        DirectedEdge<T> edgeTo;

        public Vertex(T vertexName, double distance) {
            this.vertexName = vertexName;
            this.distance = distance;
            this.edgeTo = null;
        }


        @Override
        public int compareTo(Vertex that) {
            if (this.distance < that.distance) {
                return -1;
            } else if (this.distance > that.distance) {
                return 1;
            } else {
                return 0;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof Edge) {
                Vertex other = (Vertex) o;
                return Objects.equals(this.distance, other.distance);
            }

            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(this.vertexName);
        }
    }
}
