package interviews.algorithms.graphs.directed;

import org.junit.Test;

import static org.junit.Assert.*;

public class TopologicalSortTest {

    @Test
    public void testToplogicalSort() {
        Digraph<Integer> graph = new Digraph<>();
        for (int i = 0; i < 13; i++) {
            graph.addVertex(i);
        }

        graph.addEdge(0, 6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 5);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 5);
        graph.addEdge(5, 4);
        graph.addEdge(6, 4);
        graph.addEdge(6, 9);
        graph.addEdge(7, 6);
        graph.addEdge(8, 7);
        graph.addEdge(9, 10);
        graph.addEdge(9, 12);
        graph.addEdge(9, 11);
        graph.addEdge(11, 12);

        TopologicalSort<Integer> ts = new TopologicalSort<>(graph);
        System.out.println(ts.order());
    }

}