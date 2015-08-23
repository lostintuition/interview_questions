package interviews.algorithms.graphs.directed;

import java.util.Collection;

public class TopologicalSort<T> {

    private Collection<T> order;

    public TopologicalSort(Digraph<T> graph) {
        DepthFirstOrder<T> depthFirstOrder = new DepthFirstOrder<>(graph);
        DirectedCycle<T> directedCycle = new DirectedCycle<>(graph);

        if (!directedCycle.hasCycle()) {
            order = depthFirstOrder.pre();
        }
    }

    public boolean isDAG() {
        return order != null;
    }

    public Collection<T> order() {
        return order;
    }
}
