package interviews.algorithms.graphs.mst;

import java.util.*;

public class EagerPrimMst<T> {

    private EdgeWeightedGraph<T> edgeWeightedGraph;
    private Set<T> knownVertices;
    private Map<T, Edge<T>> mst;
    private PriorityQueue<Vertex> priorityQueue; // implements comparable based on distance
    private Map<T, Vertex> vertexNameToVertex; // used to keep track of the vertex's current distance

    public EagerPrimMst(EdgeWeightedGraph<T> edgeWeightedGraph) {
        this.edgeWeightedGraph = edgeWeightedGraph;
        this.knownVertices = new HashSet<>();
        this.mst = new HashMap<>();
        this.priorityQueue = new PriorityQueue<>();
        this.vertexNameToVertex = new HashMap<>();

        Collection<T> vertices = edgeWeightedGraph.getVertices();
        for (T vertexName: vertices) {
            vertexNameToVertex.put(vertexName, new Vertex(vertexName, Double.MAX_VALUE));
        }

        T firstVertexName = vertices.iterator().next();
        Vertex firstVertex = new Vertex(firstVertexName, 0);
        vertexNameToVertex.put(firstVertexName, firstVertex);
        priorityQueue.add(firstVertex);

        while (!priorityQueue.isEmpty()) {
            visit(priorityQueue.remove());
        }
    }

    public void visit(Vertex vertex) {
        T vertexName = vertex.vertexName;
        knownVertices.add(vertexName);

        for (Edge<T> adjacentEdge: edgeWeightedGraph.getAdjacentEdges(vertexName)) {
            T otherVertexName = adjacentEdge.other(vertexName);
            if (!knownVertices.contains(otherVertexName)) {
                Vertex otherVertex = vertexNameToVertex.get(otherVertexName);
                if (adjacentEdge.weight() < otherVertex.distance) {
                    Vertex newOtherVertex = new Vertex(otherVertexName, adjacentEdge.weight());
                    vertexNameToVertex.put(otherVertexName, newOtherVertex);
                    mst.put(otherVertexName, adjacentEdge);
                    if (priorityQueue.contains(otherVertex)) {
                        priorityQueue.remove(otherVertex);
                        priorityQueue.add(newOtherVertex);
                    } else {
                        priorityQueue.add(newOtherVertex);
                    }
                }
            }
        }
    }

    public Collection<Edge<T>> edges() {
        return new LinkedList<>(mst.values());
    }

    public double weight() {
        double weight = 0;
        for (Edge edge: mst.values()) {
            System.out.println(edge.weight());
            weight += edge.weight();
        }

        return weight;
    }

    private class Vertex implements Comparable<Vertex> {

        double distance;
        T vertexName;

        public Vertex(T vertexName, double distance) {
            this.vertexName = vertexName;
            this.distance = distance;
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
