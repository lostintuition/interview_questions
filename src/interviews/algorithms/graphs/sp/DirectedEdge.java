package interviews.algorithms.graphs.sp;

import java.util.Objects;

public class DirectedEdge<T> implements Comparable<DirectedEdge<T>>
{
    private final T from;
    private final T to;
    private final double weight;

    public DirectedEdge(T from, T to, double weight)
    {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
    public double weight() {
        return weight;
    }

    public T from() {
        return from;
    }

    public T other(T vertex) {
        return to;
    }

    public int compareTo(DirectedEdge that) {
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
        if (o instanceof DirectedEdge) {
            DirectedEdge<T> other = (DirectedEdge<T>) o;
            return Objects.equals(this.from, other.from) && Objects.equals(this.to, other.to);
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.from) + Objects.hashCode(this.to);
    }

    public String toString() {
        return String.format("%s-%s %.2f", from, to, weight);
    }
}