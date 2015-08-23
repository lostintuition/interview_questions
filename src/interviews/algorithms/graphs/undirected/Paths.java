package interviews.algorithms.graphs.undirected;

import java.util.*;

public interface Paths<T> {

    boolean hasPathTo(T targetVertexName);

    List<T> pathTo(T targetVertexName);
}
