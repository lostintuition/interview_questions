package interviews.algorithms.trees;


public class BinarySearchTree {

    public Node root;

    public BinarySearchTree(Node root) {
        this.root = root;
    }

    public static BinarySearchTree generateExampleTree() {
        Node[] nodes = new Node[7];
        for (int i = 0; i < 7; i++) {
            nodes[i] = new Node(i * 2, Integer.toString(i * 2));
        }

        nodes[3].left = nodes[1];
        nodes[1].left = nodes[0];
        nodes[1].right = nodes[2];
        nodes[3].right = nodes[5];
        nodes[5].left = nodes[4];
        nodes[5].right = nodes[6];

        return new BinarySearchTree(nodes[3]);
    }

    public void print() {
        recursivelyPrint(root);
    }

    private void recursivelyPrint(Node current) {
        if (current == null) {
            return;
        }

        recursivelyPrint(current.left);
        System.out.println(current);
        recursivelyPrint(current.right);
    }
}
