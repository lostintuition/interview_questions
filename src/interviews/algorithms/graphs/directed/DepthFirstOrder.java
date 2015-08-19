package interviews.algorithms.graphs.directed;

import interviews.algorithms.graphs.Vertex;

import java.util.*;

public class DepthFirstOrder<T> {

    private Queue<T> pre;
    private Queue<T> post;
    private Deque<T> reversePost;

    public DepthFirstOrder(Digraph<T> graph) {
        pre = new LinkedList<>();
        post = new LinkedList<>();
        reversePost = new ArrayDeque<>();

        for (Vertex<T> vertex : graph.getVertices()) {
            if (!vertex.known) {
                dfs(graph, vertex);
            }
        }
    }

    private void dfs(Digraph<T> graph, Vertex<T> currentVertex) {
        pre.add(currentVertex.name);
        currentVertex.known = true;

        for (Vertex<T> adjacentVertex : graph.getAdjacentVertices(currentVertex.name)) {
            if (!adjacentVertex.known) {
                System.out.println(adjacentVertex);
                dfs(graph, adjacentVertex);
            }
        }

        post.add(currentVertex.name);
        reversePost.push(currentVertex.name);
    }

    public Collection<T> pre() {
        return new ArrayList<>(pre);
    }

    public Collection<T> post() {
        return new ArrayList<>(post);
    }

    public Collection<T> reversePost() {
        return new ArrayList<>(reversePost);
    }
}