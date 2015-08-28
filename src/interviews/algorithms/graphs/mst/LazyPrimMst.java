package interviews.algorithms.graphs.mst;

import java.util.*;

public class LazyPrimMst<T> {

    Set<T> knownVertices;
    PriorityQueue<Edge<T>> priorityQueue;
    Queue<Edge<T>> mst;
    EdgeWeightedGraph<T> edgeWeightedGraph;
    double weight;

    public LazyPrimMst(EdgeWeightedGraph<T> edgeWeightedGraph) {
        this.knownVertices = new HashSet<>();
        this.priorityQueue = new PriorityQueue<>();
        this.mst = new LinkedList<>();
        this.edgeWeightedGraph = edgeWeightedGraph;
        this.weight = 0;

        Collection<T> vertices = edgeWeightedGraph.getVertices();
        T vertex = vertices.iterator().next();
        visit(vertex);

        while (!priorityQueue.isEmpty()) {
            Edge<T> edge = priorityQueue.remove();
            T head = edge.either();
            T tail = edge.other(head);
            if (!knownVertices.contains(head) || !knownVertices.contains(tail)) {
                if (!knownVertices.contains(head)) {
                    visit(head);
                } else if (!knownVertices.contains(tail)) {
                    visit(tail);
                }
                mst.add(edge);
                weight += edge.weight();
            }
        }
    }

    public Collection<Edge<T>> getEdges() {
        return new LinkedList<>(mst);
    }

    public double weight() {
        return weight;
    }

    private void visit(T vertexName) {
        knownVertices.add(vertexName);
        for (Edge<T> edge: edgeWeightedGraph.getAdjacentEdges(vertexName)) {
            T other = edge.other(vertexName);
            if (!knownVertices.contains(other)) {
                priorityQueue.add(edge);
            }
        }
    }
}
