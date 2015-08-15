package graphs;

import interviews.algorithms.graphs.Graph;
import interviews.algorithms.graphs.undirected.TwoColor;
import interviews.algorithms.graphs.undirected.UndirectedGraph;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

public class TwoColorTest {

    @Test
    public void testNonBipartiteGraph() {
        Graph<Integer> graph = UndirectedGraph.tinyIntegerGraph();
        TwoColor<Integer> twoColor = new TwoColor<>(graph);

        assertThat(twoColor.isBipartite(), is(false));
    }

    @Test
    public void testGraphWithoutCycle() {
        Graph<Integer> bipartiteGraph = createSimpleBipartiteGraph();
        TwoColor<Integer> twoColor = new TwoColor<>(bipartiteGraph);

        assertThat(twoColor.isBipartite(), is(true));
    }

    private Graph<Integer> createSimpleBipartiteGraph() {
        Graph<Integer> bipartiteGraph = new UndirectedGraph<>();

        for (int i = 0; i < 6; i++) {
            bipartiteGraph.addVertex(i);
        }

        bipartiteGraph.addEdge(0, 1);
        bipartiteGraph.addEdge(2, 3);
        bipartiteGraph.addEdge(4, 5);

        return bipartiteGraph;
    }
}