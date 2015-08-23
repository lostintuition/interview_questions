package interviews.algorithms.graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Vertex<T> {

    public T name;
    public boolean known;
    public Vertex<T> path;
    public List<Vertex<T>> adjacentVertices;

    public Vertex(T value) {
        this.name = value;
        this.adjacentVertices = new LinkedList<Vertex<T>>();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Vertex) {
            Vertex other = (Vertex) o;
            return Objects.equals(name, other.name);
        }
        return false;
    }

    @Override
    public String toString() {
        return name.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public void reset() {
        path = null;
        known = false;
    }
}
