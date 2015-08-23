package interviews.algorithms.graphs.mst;

import org.junit.Test;

import java.util.PriorityQueue;

import static org.junit.Assert.*;

public class KruskalMstTest {

    @Test
    public void testKruskalMst() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < 10; i++) {
            pq.add(i);
        }

        while (!pq.isEmpty()) {
            System.out.println(pq.remove());
        }

        PriorityQueue<Edge<Integer>> priorityQueue = new PriorityQueue<>();
        priorityQueue.addAll(EdgeWeightedGraph.tinyIntegerGraph().getEdges());
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.remove());
        }
    }

}