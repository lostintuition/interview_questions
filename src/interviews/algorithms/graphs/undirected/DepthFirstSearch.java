package interviews.algorithms.graphs.undirected;

import java.util.*;

public class DepthFirstSearch<T> {

    private Graph<T> graph;
    private int count;
    private Set<T> markedVertices;

    public DepthFirstSearch(Graph<T> graph) {
        this.graph = graph;
        this.markedVertices = new HashSet<>();
    }

    public void search(T sourceVertexName) {
        Stack<T> visitedVertices = new Stack<>();
        visitedVertices.push(sourceVertexName);
        while (!visitedVertices.isEmpty()) {
            T current = visitedVertices.pop();
            graph.getAdjacentVertices(current).stream()
                    .filter(adjacentVertex -> !adjacentVertex.known)
                    .forEach(adjacentVertex -> {
                        visitedVertices.push(adjacentVertex.name);
                        count++;
                        markedVertices.add(adjacentVertex.name);
                    });
        }
    }

    public int getCount() {
        return count;
    }

    public boolean marked(T vertexName) {
        return markedVertices.contains(vertexName);
    }
}
