package interviews.algorithms.graphs.directed;

import interviews.algorithms.graphs.Vertex;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.Assert.*;

/**
 * Created by garrettsato on 8/15/15.
 */
public class DirectedCycleTest {
    @Test
    public void testDirectedCycle() {
        Digraph<Integer> graph = Digraph.tinyIntegerGraph();
        DirectedCycle<Integer> cycle = new DirectedCycle<>(graph);

        System.out.println(cycle.hasCycle());
        System.out.println(cycle.cycle());
    }
}