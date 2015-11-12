package interviews.algorithms.trees;

public class Node {
    public int key;
    public Object value;
    public Node left, right;

    public Node(int key, Object value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof  Node) {
            Node other = (Node) o;
            return this.key == other.key;
        }
        return false;
    }
}