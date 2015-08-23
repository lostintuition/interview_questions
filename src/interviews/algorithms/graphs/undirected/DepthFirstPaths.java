package interviews.algorithms.graphs.undirected;

import interviews.algorithms.graphs.Graph;
import interviews.algorithms.graphs.Vertex;

import java.util.*;

public class DepthFirstPaths<T> implements Paths<T> {

    private Graph<T> graph;
    private Vertex<T> sourceVertex;

    public DepthFirstPaths(Graph<T> graph, T sourceVertexName) {
        this.sourceVertex = graph.getVertex(sourceVertexName);
        this.graph = graph;
        dfs();
    }

    public void dfs() {
        Stack<Vertex<T>> visitedVertices = new Stack<>();
        visitedVertices.push(sourceVertex);

        while (!visitedVertices.isEmpty()){
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

    public boolean hasPathTo(T targetVertexName) {
        return graph.getVertex(targetVertexName).known;
    }

    public List<T> pathTo(T targetVertexName) {
        List<T> path = new ArrayList<>();
        Vertex<T> targetVertex = graph.getVertex(targetVertexName);
        if (!targetVertex.known) {
            return path;
        }

        Vertex<T> currentVertex = targetVertex;
        while (!currentVertex.name.equals(sourceVertex.name)) {
            path.add(currentVertex.name);
            currentVertex = currentVertex.path;
        }

        path.add(currentVertex.name);
        Collections.reverse(path);
        return path;
    }
}
