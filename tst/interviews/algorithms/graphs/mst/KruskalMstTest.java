package interviews.algorithms.graphs.mst;

import org.junit.Test;

import java.util.PriorityQueue;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class KruskalMstTest {

    @Test
    public void testKruskalMst() {
        EdgeWeightedGraph<Integer> edgeWeightedGraph = new EdgeWeightedGraph<>();
        for (int i = 0; i < 8; i++) {
            edgeWeightedGraph.addVertex(i);
        }

        edgeWeightedGraph.addEdge(0, 7, .16);
        edgeWeightedGraph.addEdge(2, 3, .17);
        edgeWeightedGraph.addEdge(1, 7, .19);
        edgeWeightedGraph.addEdge(0, 2, .26);
        edgeWeightedGraph.addEdge(5, 7, .28);
        edgeWeightedGraph.addEdge(4, 5, .35);
        edgeWeightedGraph.addEdge(6, 2, .40);

        KruskalMst<Integer> kruskalMst = new KruskalMst<>(edgeWeightedGraph);

        assertThat(kruskalMst.weight(), is(equalTo(1.81)));
    }

}