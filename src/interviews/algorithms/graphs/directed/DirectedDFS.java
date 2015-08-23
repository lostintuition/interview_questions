package interviews.algorithms.graphs.directed;


import interviews.algorithms.graphs.Vertex;

import java.util.List;
import java.util.Stack;

public class DirectedDFS<T> {

    private Digraph<T> graph;

    public DirectedDFS(Digraph<T> graph, T sourceVertexName) {
        this.graph = graph;
        dfs(graph.getVertex(sourceVertexName));
    }

    public DirectedDFS(Digraph<T> graph, List<T> sources) {
        this.graph = graph;
        for (T source: sources) {
            dfs(graph.getVertex(source));
        }
    }

    public void dfs(Vertex<T> source) {
        Stack<Vertex<T>> visitedVertices = new Stack<>();
        visitedVertices.push(source);
        while (!visitedVertices.isEmpty()) {
            Vertex<T> currentVertex = visitedVertices.pop();
            if (!currentVertex.known) {
                currentVertex.known = true;
                graph.getAdjacentVertices(currentVertex.name).stream()
                        .filter(adjacentVertex -> !adjacentVertex.known)
                        .forEach(adjacentVertex -> {
                            visitedVertices.push(adjacentVertex);
                            adjacentVertex.path = currentVertex;
                        });
            }
        }
    }

    boolean isReachable(T vertexName) {
        return graph.getVertex(vertexName).known;
    }
}
