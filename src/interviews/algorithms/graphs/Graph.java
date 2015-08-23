package interviews.algorithms.graphs;

import java.util.Collection;
import java.util.List;

public interface Graph<T> {

    int numVertices();

    int numEdges();

    void addEdge(T startingVertexName, T endingVertexName);

    void addVertex(T vertexName);

    Collection<Vertex<T>> getAdjacentVertices(T vertexName);

    String toString();

    Vertex<T> getVertex(T vertexName);

    void reset();

    List<Vertex<T>> getVertices();
}
