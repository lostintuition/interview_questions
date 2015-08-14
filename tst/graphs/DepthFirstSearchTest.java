package graphs;

import interviews.algorithms.graphs.undirected.DepthFirstSearch;
import interviews.algorithms.graphs.undirected.Graph;
import interviews.algorithms.graphs.undirected.UndirectedGraph;
import org.junit.Test;

public class DepthFirstSearchTest {

    @Test
    public void testDfs() {
        Graph<Integer> graph = new UndirectedGraph<>();
        for (int i = 0; i < 6; i++) {
            graph.addVertex(i);
        }
        for (int i = 1; i < 10; i++) {
            graph.addEdge(i - 1, i);
        }

        DepthFirstSearch<Integer> dfs = new DepthFirstSearch<>(graph);
        dfs.search(0);
        System.out.println(dfs.marked(1));
    }
}