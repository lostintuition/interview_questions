package interviews.algorithms.graphs.directed;

import interviews.algorithms.graphs.Vertex;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

public class DirectedDFSTest {

    @Test
    public void testReachability() {
        Digraph<Integer> graph = Digraph.tinyIntegerGraph();
        DirectedDFS<Integer> dfs = new DirectedDFS<>(graph, 1);

        printReachableVertices(graph, dfs);

        graph.reset();
        dfs = new DirectedDFS<>(graph, 2);
        printReachableVertices(graph, dfs);

        graph.reset();
        dfs = new DirectedDFS<>(graph, new LinkedList<>(Arrays.asList(1, 2, 6)));
        printReachableVertices(graph, dfs);
    }

    private void printReachableVertices(Digraph<Integer> graph, DirectedDFS<Integer> dfs) {
        for (Vertex<Integer> vertex: graph.getVertices()) {
            if (dfs.isReachable(vertex.name)) {
                System.out.print(vertex.name + " ");
            }
        }
        System.out.println();
    }
}