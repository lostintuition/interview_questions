package interviews.algorithms.graphs.mst;

import java.util.Objects;

public class Edge<T> implements Comparable<Edge<T>>
{
    private final T v;
    private final T w;
    private final double weight;

    public Edge(T v, T w, double weight)
    {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }
    public double weight() {
        return weight;
    }

    public T either() {
        return v;
    }

    public T other(T vertex) {
        if (vertex.equals(v)) {
            return w;
        } else if (vertex.equals(w)) {
            return v;
        } else {
            throw new RuntimeException("Inconsistent edge");
        }
    }

    public int compareTo(Edge that) {
        if (this.weight() < that.weight()) {
            return -1;
        } else if (this.weight() > that.weight()) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Edge) {
            Edge<T> other = (Edge<T>) o;
            return Objects.equals(this.v, other.v) && Objects.equals(this.w, other.w);
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.v) + Objects.hashCode(this.w);
    }

    public String toString() {
        return String.format("%s-%s %.2f", v, w, weight);
    }
}