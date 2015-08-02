package trees;

public class IntNode {
    public int key;
    public Object value;

    public IntNode(int key, Object value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
