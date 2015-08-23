package interviews.algorithms.graphs.undirected;

import interviews.algorithms.graphs.Graph;
import interviews.algorithms.graphs.Vertex;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ConnectedComponents<T> {

    private Map<T, Integer> vertexNameToComponentId;
    private int count;
    private Graph<T> graph;

    public ConnectedComponents(Graph<T> graph) {
        this.graph = graph;
        count = 0;
        vertexNameToComponentId = new HashMap<>();
        for (Vertex<T> vertex: graph.getVertices()) {
            if (!vertex.known) {
                count++;
                dfs(vertex);
            }
        }
    }

    public void dfs(Vertex<T> sourceVertex) {
        Stack<Vertex<T>> visitedVertices = new Stack<>();
        visitedVertices.add(sourceVertex);

        while (!visitedVertices.isEmpty()) {
            Vertex<T> current = visitedVertices.pop();
            if (!current.known) {
                current.known = true;
                vertexNameToComponentId.put(current.name, count);
                graph.getAdjacentVertices(current.name).stream()
                        .filter(adjacentVertex -> !adjacentVertex.known)
                        .forEach(adjacentVertex -> {
                            adjacentVertex.path = current;
                            visitedVertices.add(adjacentVertex);
                        });
            }
        }
    }

    public boolean connected(T v, T w) {
        return vertexNameToComponentId.get(v).equals(vertexNameToComponentId.get(w));
    }

    public int count() {
        return count;
    }

    public int id(T v) {
        return vertexNameToComponentId.get(v);
    }
}
