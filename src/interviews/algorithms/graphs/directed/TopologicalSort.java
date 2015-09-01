package interviews.algorithms.graphs.directed;

import interviews.algorithms.graphs.sp.DirectedEdge;
import interviews.algorithms.graphs.sp.EdgeWeightedDigraph;

import java.util.Collection;

public class TopologicalSort<T> {

    private Collection<T> order;

    public TopologicalSort(Digraph<T> graph) {
        DepthFirstOrder<T> depthFirstOrder = new DepthFirstOrder<>(graph);
        DirectedCycle<T> directedCycle = new DirectedCycle<>(graph);

        if (!directedCycle.hasCycle()) {
            order = depthFirstOrder.reversePost();
        }
    }

    public TopologicalSort(EdgeWeightedDigraph<T> graph) {
        Digraph<T> digraph = new Digraph<>();
        for (T vertexName: graph.getVertices()) {
            digraph.addVertex(vertexName);
            for (DirectedEdge<T> adjacentEdge: graph.getAdjacentEdges(vertexName)) {
                digraph.addEdge(adjacentEdge.from(), adjacentEdge.to());
            }
        }

        DepthFirstOrder<T> depthFirstOrder = new DepthFirstOrder<>(digraph);
        DirectedCycle<T> directedCycle = new DirectedCycle<>(digraph);

        if (!directedCycle.hasCycle()) {
            order = depthFirstOrder.reversePost();
        }
    }

    public boolean isDAG() {
        return order != null;
    }

    public Collection<T> order() {
        return order;
    }
}
