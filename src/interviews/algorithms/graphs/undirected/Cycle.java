package interviews.algorithms.graphs.undirected;


import interviews.algorithms.graphs.Graph;
import interviews.algorithms.graphs.Vertex;

import java.util.Stack;

public class Cycle<T> {

    private Graph<T> graph;
    private boolean hasCycle;

    public Cycle(Graph<T> graph) {
        this.graph = graph;
        this.hasCycle = false;
        for (Vertex<T> vertex: graph.getVertices()) {
            if (!vertex.known) {
                dfs(vertex);
            }
        }
    }

    private void dfs(Vertex<T> sourceVertex) {
        Stack<ParentChildVertexPair> visitedVertices = new Stack<>();
        visitedVertices.push(new ParentChildVertexPair(sourceVertex, sourceVertex));
        while (!visitedVertices.isEmpty()) {
            ParentChildVertexPair currentVertex = visitedVertices.pop();
            if (!currentVertex.vertex.known) {
                currentVertex.vertex.known = true;
                for (Vertex<T> adjacentVertex: graph.getAdjacentVertices(currentVertex.vertex.name)) {
                    if (!adjacentVertex.known) {
                        visitedVertices.add(new ParentChildVertexPair(adjacentVertex, currentVertex.vertex));
                    } else if (!adjacentVertex.equals(currentVertex.parent)) {
                        hasCycle = true;
                    }
                }
            }
        }
    }

    public boolean hasCycle() {
        return hasCycle;
    }

    private class ParentChildVertexPair {
        public Vertex<T> parent;
        public Vertex<T> vertex;

        public ParentChildVertexPair(Vertex<T> vertex, Vertex<T> parent) {
            this.parent = parent;
            this.vertex = vertex;
        }
    }
}
