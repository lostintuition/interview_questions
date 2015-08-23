package interviews.algorithms.uf;


import java.util.*;

public class WeightedQuickUnionFind<T> {
    private int count;
    private Map<T, UnionFindElement> nameToElement;

    public WeightedQuickUnionFind(Collection<T> elements) {
        count = elements.size();
        nameToElement = new HashMap<>();

        for (T element: elements) {
            UnionFindElement unionFindElement = new UnionFindElement(element, element);
            nameToElement.put(element, unionFindElement);
        }
    }

    public int count() {
        return count;
    }

    public boolean connected(T p, T q) {
        return find(p).equals(find(q));
    }

    public T find(T p) {
        T root = findRoot(p);
        compressPath(p, root);
        return root;
    }

    private T findRoot(T p) {
        UnionFindElement current = nameToElement.get(p);
        while (!current.name.equals((current.parent))) {
            current = nameToElement.get(current.parent);
        }

        return current.name;
    }

    private void compressPath(T p, T root) {
        UnionFindElement current = nameToElement.get(p);
        while (!current.name.equals(root)) {
            T parent = current.parent;
            current.parent = root;
            current = nameToElement.get(parent);
        }
    }


    public void union(T p, T q) {
        UnionFindElement i = nameToElement.get(find(p));
        UnionFindElement j = nameToElement.get(find(q));
        if (i.name.equals(j.name)) {
            return;
        }

        if (i.size < j.size) {
            i.parent = j.name;
            j.size += i.size;
        } else {
            j.parent = i.name;
            i.size += j.size;

        }

        count--;
    }

    private class UnionFindElement {

        public T name;
        public T parent;
        public int size;

        public UnionFindElement(T name, T parent) {
            this.name = name;
            this.parent = parent;
            this.size = 1;
        }
    }
}
