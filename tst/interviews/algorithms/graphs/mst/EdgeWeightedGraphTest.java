package interviews.algorithms.graphs.mst;

import org.junit.Test;

import static org.junit.Assert.*;


public class EdgeWeightedGraphTest {

    @Test
    public void edgeWeightedGraph() {
        EdgeWeightedGraph<Integer> edgeWeightedGraph = EdgeWeightedGraph.tinyIntegerGraph();
        System.out.println(edgeWeightedGraph.getEdges().size());
    }
}