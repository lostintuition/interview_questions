package interviews.algorithms.graphs.sp;

import interviews.algorithms.graphs.directed.TopologicalSort;
import interviews.algorithms.graphs.mst.Edge;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class AcyclicShortestPaths<T> {

    private EdgeWeightedDigraph<T> graph;
    private Map<T, Vertex> vertexNameToVertex;

    public AcyclicShortestPaths(EdgeWeightedDigraph<T> graph, T sourceVertexName) {
        this.graph = graph;
        this.vertexNameToVertex = new HashMap<>();

        TopologicalSort<T> toplogicalSort = new TopologicalSort<>(graph);
    }

    private class Vertex implements Comparable<Vertex> {

        double distance;
        T vertexName;
        DirectedEdge<T> edgeTo;

        public Vertex(T vertexName, double distance) {
            this.vertexName = vertexName;
            this.distance = distance;
            this.edgeTo = null;
        }


        @Override
        public int compareTo(Vertex that) {
            if (this.distance < that.distance) {
                return -1;
            } else if (this.distance > that.distance) {
                return 1;
            } else {
                return 0;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof Edge) {
                Vertex other = (Vertex) o;
                return Objects.equals(this.distance, other.distance);
            }

            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(this.vertexName);
        }
    }
}
