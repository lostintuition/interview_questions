package interviews.algorithms.graphs.undirected;

import java.util.*;

public class BreadFirstPaths<T> implements Paths<T> {

    private Vertex<T> sourceVertex;
    private Graph<T> graph;

    public BreadFirstPaths(Graph<T> graph, T sourceVertexName) {
        this.graph = graph;
        this.sourceVertex = graph.getVertex(sourceVertexName);
        bfs();
    }

    private void bfs() {
        Queue<Vertex<T>> visitedVertices = new LinkedList<>();
        visitedVertices.add(sourceVertex);
        while (!visitedVertices.isEmpty()) {
            Vertex<T> currentVertex = visitedVertices.remove();
            graph.getAdjacentVertices(currentVertex.name).stream()
                    .filter(adjacentVertex -> !adjacentVertex.known)
                    .forEach(adjacentVertex -> {
                        visitedVertices.add(adjacentVertex);
                        adjacentVertex.known = true;
                        adjacentVertex.path = currentVertex;
                    });
        }

    }

    @Override
    public boolean hasPathTo(T targetVertexName) {
        return graph.getVertex(targetVertexName).known;
    }

    @Override
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
