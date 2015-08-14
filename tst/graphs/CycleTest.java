package graphs;

import interviews.algorithms.graphs.undirected.Cycle;
import interviews.algorithms.graphs.undirected.Graph;
import interviews.algorithms.graphs.undirected.UndirectedGraph;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

public class CycleTest {

    @Test
    public void testGraphWithCycles() {
        Graph<Integer> cycleGraph = UndirectedGraph.tinyIntegerGraph();
        Cycle<Integer> cycle = new Cycle<>(cycleGraph);

        assertThat(cycle.hasCycle(), is(true));
    }

    @Test
    public void testGraphWithoutCycle() {
        Graph<Integer> noCycleGraph = createSimpleGraphWithoutCycle();
        Cycle<Integer> noCycle = new Cycle<>(noCycleGraph);

        assertThat(noCycle.hasCycle(), is(false));
    }

    private Graph<Integer> createSimpleGraphWithoutCycle() {
        Graph<Integer> noCycleGraph = new UndirectedGraph<>();

        for (int i = 0; i < 6; i++) {
            noCycleGraph.addVertex(i);
        }

        for (int i = 1; i < 6; i++) {
            noCycleGraph.addEdge(i - 1, i);
        }

        return noCycleGraph;
    }
}