package interviews.algorithms.graphs.sp;

import org.junit.Test;

import java.util.Collection;
import java.util.LinkedList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;


public class DijkstraShortestPathsTest {

    @Test
    public void testShortestPaths() {
        EdgeWeightedDigraph<Integer> graph = new EdgeWeightedDigraph<>();
        for (int i = 0; i < 8; i++) {
            graph.addVertex(i);
        }

        graph.addEdge(4, 5, .35);
        graph.addEdge(5, 4, .35);
        graph.addEdge(4, 7, .37);
        graph.addEdge(5, 7, .28);
        graph.addEdge(7, 5, .28);
        graph.addEdge(5, 1, .32 );
        graph.addEdge(0, 4, .38);
        graph.addEdge(0, 2, .26);
        graph.addEdge(7, 3, .39);
        graph.addEdge(1, 3, .29);
        graph.addEdge(2, 7, .34);
        graph.addEdge(6, 2, .40);
        graph.addEdge(3, 6, .52);
        graph.addEdge(6, 0, .58);
        graph.addEdge(6, 4, .93);

        DijkstraShortestPaths<Integer> dijkstraShortestPaths = new DijkstraShortestPaths<>(graph, 0);

        Collection<DirectedEdge<Integer>> path = new LinkedList<>();
        path.add(new DirectedEdge<>(0, 2, .26));
        path.add(new DirectedEdge<>(2, 7, .34));
        path.add(new DirectedEdge<>(7, 3, .39));
        path.add(new DirectedEdge<>(3, 6, .52));

        assertThat(dijkstraShortestPaths.distanceTo(6), is(closeTo(1.51, .001)));
        assertThat(dijkstraShortestPaths.distanceTo(3), is(closeTo(.99, .001)));
        assertThat(dijkstraShortestPaths.pathTo(6), contains(path.toArray()));
    }
}