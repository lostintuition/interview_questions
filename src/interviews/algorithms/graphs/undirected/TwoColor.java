package interviews.algorithms.graphs.undirected;

import interviews.algorithms.graphs.Graph;
import interviews.algorithms.graphs.Vertex;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


public class TwoColor<T> {

    private Graph<T> graph;
    private Map<T, Color> vertexNameToColor;
    private boolean isTwoColorable;

    public TwoColor(Graph<T> graph) {
        this.graph = graph;
        this.isTwoColorable = true;
        vertexNameToColor = new HashMap<>();
        for (Vertex<T> vertex: graph.getVertices()) {
            if (!vertex.known) {
                dfs(vertex);
            }
        }
    }

    private void dfs(Vertex<T> sourceVertex) {
        Stack<Vertex<T>> visitedVertices = new Stack<>();
        visitedVertices.push(sourceVertex);
        vertexNameToColor.put(sourceVertex.name, Color.RED);

        while (!visitedVertices.isEmpty()) {
            Vertex<T> currentVertex = visitedVertices.pop();
            if (!currentVertex.known) {
                currentVertex.known = true;
                Color currentVertexColor = vertexNameToColor.get(currentVertex.name);
                for (Vertex<T> adjacentVertex: graph.getAdjacentVertices(currentVertex.name)) {
                    Color adjacentVertexColor = vertexNameToColor.get(adjacentVertex.name);
                    if (!adjacentVertex.known) {
                        visitedVertices.push(adjacentVertex);
                        vertexNameToColor.put(adjacentVertex.name, Color.getOppositeColor(currentVertexColor));
                    } else if (currentVertexColor == adjacentVertexColor) {
                        isTwoColorable = false;
                    }
                }
            }
        }
    }

    public boolean isBipartite() {
        return isTwoColorable;
    }

    private enum Color {
        RED, BLUE;

        public static Color getOppositeColor(Color color) {
            return color == RED ? BLUE : RED;
        }
    }
}
