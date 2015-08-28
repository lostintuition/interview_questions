package interviews.algorithms.graphs.mst;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.*;

public class LazyPrimMstTest {

    @Test
    public void testLazyPrimMst() {
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

        LazyPrimMst<Integer> lazyPrimMst = new LazyPrimMst<>(edgeWeightedGraph);

        assertThat(lazyPrimMst.weight(), is(closeTo(1.81, .001)));
    }
}