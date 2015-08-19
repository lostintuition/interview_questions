package interviews.algorithms.uf;


public class WeightedQuickUnionFind {

    private int[] id;
    private int count;
    private int[] size;

    public WeightedQuickUnionFind(int n) {
        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }

        size = new int[n];
        for (int i = 0; i < n; i++) {
            size[i] = 1;
        }
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        int root = findRoot(p);
        compressPath(p, root);
        return root;
    }

    private int findRoot(int p) {
        int current = p;
        while (current != id[current]) {
            current = id[current];
        }

        return current;
    }

    private void compressPath(int p, int root) {
        int current = p;
        while (current != id[current]) {
            int parent = id[current];
            id[current] = root;
            current = parent;
        }
    }


    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) {
            return;
        }

        if (size[i] < size[j]) {
            id[i] = j;
            size[j] += size[i];
        } else {
            id[j] = i;
            size[i] += size[j];
        }

        count--;
    }
}
