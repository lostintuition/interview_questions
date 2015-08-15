package graphs;

import interviews.algorithms.graphs.Graph;
import interviews.algorithms.graphs.undirected.*;
import org.junit.Test;

/**
 * Created by garrettsato on 8/9/15.
 */
public class PathsTest {

    @Test
    public void testPaths() {
        Graph<Integer> graph = new UndirectedGraph<>();
        for (int i = 0; i < 6; i++) {
            graph.addVertex(i);
        }

        graph.addEdge(0, 5);
        graph.addEdge(2, 4);
        graph.addEdge(2, 3);
        graph.addEdge(1, 2);
        graph.addEdge(0, 1);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(0, 2);

        Paths<Integer> paths = new DepthFirstPaths<>(graph, 0);
        System.out.println(paths.hasPathTo(1));
        System.out.println(paths.pathTo(1));
        System.out.println(paths.pathTo(2));
        System.out.println(paths.pathTo(3));
        System.out.println(paths.pathTo(4));
        System.out.println(paths.pathTo(5));

        graph.reset();
        paths = new BreadFirstPaths<>(graph, 0);
        System.out.println(paths.hasPathTo(1));
        System.out.println(paths.pathTo(1));
        System.out.println(paths.pathTo(2));
        System.out.println(paths.pathTo(3));
        System.out.println(paths.pathTo(4));
        System.out.println(paths.pathTo(5));

    }
}