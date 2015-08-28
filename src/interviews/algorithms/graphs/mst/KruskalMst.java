package interviews.algorithms.graphs.mst;

import interviews.algorithms.uf.UnionFind;
import interviews.algorithms.uf.WeightedQuickUnionFind;

import java.util.Collection;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class KruskalMst<T> {

    private Queue<Edge<T>> mst;
    private double weight;

    public KruskalMst(EdgeWeightedGraph<T> graph) {
        mst = new LinkedList<>();
        weight = 0;

        PriorityQueue<Edge<T>> priorityQueue = new PriorityQueue<>();
        priorityQueue.addAll(graph.getEdges());

        WeightedQuickUnionFind<T> unionFind = new WeightedQuickUnionFind<>(graph.getVertices());

        while (!priorityQueue.isEmpty()) {
            Edge<T> edge = priorityQueue.remove();
            T head = edge.either();
            T tail = edge.other(head);
            if (!unionFind.connected(head, tail)) {
                unionFind.union(head, tail);
                mst.add(edge);
                weight += edge.weight();
            }
        }
    }

    public Collection<Edge<T>> edges() {
        return new LinkedList<>(mst);
    }

    public double weight() {
        return weight;
    }
}
