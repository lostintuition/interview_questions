package interviews.algorithms.graphs.directed;

import interviews.algorithms.graphs.Vertex;

import java.util.*;

public class DirectedCycle<T> {

    private Digraph<T> graph;
    private List<T> cycle;

    public DirectedCycle(Digraph<T> graph) {
        this.graph = graph;
        for (Vertex<T> vertex: graph.getVertices()) {
            dfs(vertex);
        }
    }

    private void dfs(Vertex<T> source) {
        Stack<Vertex<T>> visitedVertices = new Stack<>();
        Set<Vertex<T>> onPath = new HashSet<>();
        visitedVertices.push(source);
        while (!visitedVertices.isEmpty()) {
            Vertex<T> currentVertex = visitedVertices.pop();
            if (!currentVertex.known) {
                currentVertex.known = true;
                onPath.add(currentVertex);
                for (Vertex<T> adjacentVertex: graph.getAdjacentVertices(currentVertex.name)) {
                    if (!adjacentVertex.known) {
                        visitedVertices.push(adjacentVertex);
                        adjacentVertex.path = currentVertex;
                    } else if (onPath.contains(adjacentVertex)) {
                        cycle = pathTo(adjacentVertex.name, currentVertex.name);
                        return;
                    }
                }
            }
        }
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public List<T> cycle() {
        return cycle;
    }

    private List<T> pathTo(T sourceVertexName, T targetVertexName) {
        List<T> path = new ArrayList<>();
        Vertex<T> targetVertex = graph.getVertex(targetVertexName);
        if (!targetVertex.known) {
            return path;
        }

        Vertex<T> currentVertex = targetVertex;
        while (!currentVertex.name.equals(sourceVertexName)) {
            path.add(currentVertex.name);
            currentVertex = currentVertex.path;
        }

        path.add(currentVertex.name);
        path.add(targetVertex.name);
        Collections.reverse(path);
        return path;
    }
}
