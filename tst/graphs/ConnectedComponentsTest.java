package graphs;

import interviews.algorithms.graphs.undirected.ConnectedComponents;
import interviews.algorithms.graphs.undirected.Graph;
import interviews.algorithms.graphs.undirected.UndirectedGraph;
import interviews.algorithms.graphs.undirected.Vertex;
import org.junit.Test;

import java.util.*;

/**
 * Created by garrettsato on 8/10/15.
 */
public class ConnectedComponentsTest {

    @Test
    public void testConnectedComponents() {
        Graph<Integer> graph = UndirectedGraph.tinyIntegerGraph();
        ConnectedComponents<Integer> cc = new ConnectedComponents<>(graph);

        System.out.println(cc.count());
        Map<Integer, List<Integer>> componentIdToVertices = new HashMap<>();
        for (int i = 1; i <= cc.count(); i++) {
            componentIdToVertices.put(i, new ArrayList<>());
        }

        for (Vertex<Integer> vertex: graph.getVertices()) {
            Integer componentId = cc.id(vertex.name);
            componentIdToVertices.get(componentId).add(vertex.name);
        }

        System.out.println(componentIdToVertices);
    }
}