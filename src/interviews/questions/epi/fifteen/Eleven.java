package interviews.questions.epi.fifteen;

import base.InterviewQuestion;
import interviews.algorithms.trees.BinarySearchTree;
import interviews.algorithms.trees.Node;

/**
 * Design efficient algorithms for inserting and removing keys in a BST. Assume that all
 * elements in the BST are unique, and that your insertion method must preserve this property.
 */
public class Eleven implements InterviewQuestion {

    @Override
    public void evaluate() {
        BinarySearchTree bst = BinarySearchTree.generateExampleTree();
        insertIterative(bst, new Node(7, "7"));
        insertIterative(bst, new Node(3, "3"));
        insertIterative(bst, new Node(1, "1"));
        insertIterative(bst, new Node(9, "9"));
        bst.print();

        deleteIterative(bst, new Node(10, "10"));
        deleteIterative(bst, new Node(2, "2"));
        deleteIterative(bst, new Node(1, "1"));
        deleteIterative(bst, new Node(6, "6"));
        deleteIterative(bst, new Node(12, "12"));

        bst.print();
    }

    private void deleteIterative(BinarySearchTree tree, Node deletionNode) {
        Node parent = tree.root;
        Node current = tree.root;

        while (current != null && current.key != deletionNode.key) {
            parent = current;
            current = deletionNode.key < current.key ? current.left : current.right;
        }

        if (current == null) {
            return;
        }

        Node childNode;
        if (current.left == null && current.right == null) {
            childNode = null;
        } else if (current.left == null || current.right == null) {
            childNode = current.left != null ? current.left : current.right;
        } else {
            Node minimumChildInRightSubtree = current.right;
            while (minimumChildInRightSubtree.left != null) {
                minimumChildInRightSubtree = minimumChildInRightSubtree.left;
            }
            minimumChildInRightSubtree.left = current.left;
            childNode = current.right;
        }

        if (current.key < parent.key) {
            parent.left = childNode;
        } else if (current.key > parent.key){
            parent.right = childNode;
        } else {
            tree.root = childNode;
        }
    }

    private void insertIterative(BinarySearchTree tree, Node insertionNode) {
        if (tree.root == null) {
            tree.root = insertionNode;
            return;
        }

        Node current = tree.root;
        Node parent = null;

        while (current != null) {
            parent = current;
            if (current.key == insertionNode.key) {
                System.out.println("Found duplicate, returning");
                return;
            } else if (insertionNode.key < current.key) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        if (insertionNode.key < parent.key) {
            parent.left = insertionNode;
        } else {
            parent.right = insertionNode;
        }
    }

    private void insertRecursive(BinarySearchTree tree, Node insertionNode) {
        if (tree.root == null) {
            tree.root = insertionNode;
        }

        Node value = searchForValue(tree.root, insertionNode);
        if (value.key == insertionNode.key) {
            System.out.println("Nothing to do here, the key already exists");
        } else if (insertionNode.key < value.key) {
            value.left = insertionNode;
        } else {
            value.right = insertionNode;
        }
    }

    private Node searchForValue(Node current, Node insertionNode) {
        if (insertionNode.key == current.key) {
            return current;
        } else if (insertionNode.key < current.key) {
            return current.left == null ? current : searchForValue(current.left, insertionNode);
        } else {
            return current.right == null ? current : searchForValue(current.right, insertionNode);
        }
    }
}
