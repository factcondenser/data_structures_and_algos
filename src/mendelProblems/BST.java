package mendelProblems;

import java.util.NoSuchElementException;
import java.util.Iterator;
import java.util.Stack;

/**
 * Problem 2: Binary Search Tree
 *
 * Implement a binary search tree of integers with add() and contains() functions
 *
 * Feel free to modify anything, as long as you deliver the functionality defined in the comments and method headers
 */
// Implement this class
public class BST implements Iterable<Integer> {
    // Define a treenode
    class Node implements Comparable<Node> {
        int val;
        Node left;
        Node right;
        Node(int val) {
            this.val = val;
        }

        public int compareTo(Node other) {
           return val - other.val;
        }
    }

    // Add members here
    private Node root;
//    private int min;
//    private int max;

    // Initialize a tree (initially empty)
    public BST() {
//        min = Integer.MAX_VALUE;
//        max = Integer.MIN_VALUE;
    }

    // If the tree does not already contain the value, add it to the tree
    public void add(int val) {
        if (!contains(val)) {
            addHelper(val, root);
//            if (val < min) {
//                min = val;
//            }
//            if (val > max) {
//                max = val;
//            }
        }
    }

    private void addHelper(int val, Node node) {
        if (node == null) {
            root = new Node(val);
        } else if (val <= node.val) {
            if (node.left == null) {
                node.left = new Node(val);
            } else {
                addHelper(val, node.left);
            }
        } else {
            if (node.right == null) {
                node.right = new Node(val);
            } else {
                addHelper(val, node.right);
            }
        }
    }

    // Return true if the tree contains the value, false otherwise
    public boolean contains(int val) {
        return containsHelper(val, root);
    }

    private boolean containsHelper(int val, Node node) {
        if (node == null) return false;
        if (node.val < val) {
            return containsHelper(val, node.left);
        }
        if (node.val > val) {
            return containsHelper(val, node.right);
        }
        return true;
    }

    // Implement this method and add it to the BST class
    public Iterator<Integer> iterator() {
        return new BSTIterator(root);
    }

    /**
     * Problem 4: Maximum and Minimum
     *
     * Add methods to get the minimum and maximum elements in the BST
     *
     * You may modify the BST class, but not in a way that disrupts previously implemented functionality
     *
     */
    // Implement these methods and add them to the BST class. Throw a NoSuchElementException if there is no maximum/minimum element
    public int maxValue() {
        if (root == null) throw new NoSuchElementException();
        return maxValue(root);
    }

    private int maxValue(Node node) {
        while (node.right != null) {
            node = node.right;
        }
        return node.val;
    }

    public int minValue() {
        if (root == null) throw new NoSuchElementException();
        return minValue(root);
    }

    private int minValue(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.val;
    }

    /**
     * Problem 5: Next and Previous
     *
     * Add the following methods:
     * next(value) returns the smallest element in the tree that is greater than value
     * prev(value) returns the smallest element in the tree that is less than value
     *
     * Consider that the input value does not necessarily have to be in the tree
     *
     * You may modify the BST class, but not in a way that disrupts previously implemented functionality
     *

                                    40
                5											60
        3               9							51				73
     1      4       7       20					46      52		66	    80

     if val is in tree:
     next:
     40->5->9->20
     40->60->51->52
     40->5->3->4
     prev:
     40->5->9->20
     40->5->3->4

     if val is NOT in the tree:
     next:
     8
     40->5->9->7->8
     10
     40->5->9->20->10
     6
     40->5->9->7->6
     prev:
     55
     40->60->51->52->55

     */
    // Implement these methods and add them to the BST class. Throw a NoSuchElementException if there is no such next/previous element
    public int next(int val) {
        Node node = root;
        Stack<Node> ancestors = new Stack<>();
        while (node != null) {
            if (val == node.val) break;
            ancestors.push(node);
            node = (val < node.val) ? node.left : node.right;
        }
        // val is not in the tree, or val is in tree but right child does not exist
        if (node == null || node.right == null) {
            Node next = minAncestor(new Node(val), ancestors);
            if (next == null) throw new NoSuchElementException(); // next does not exist
            return next.val; // next exists
        }
        // val is in the tree and right child exists
        return minValue(node.right);
    }

    private Node minAncestor(Node node, Stack<Node> ancestors) {
        Node min = new Node(Integer.MAX_VALUE);
        while (!ancestors.empty()) {
            Node other = ancestors.pop();
            if (node.compareTo(other) < 0 && other.compareTo(min) < 0) {
                min = other;
            }
        }
        return (min.val == Integer.MAX_VALUE) ? null : min;
    }

    public int prev(int val) {
        Node node = root;
        Stack<Node> ancestors = new Stack<>();
        while (node != null) {
            if (val == node.val) break;
            ancestors.push(node);
            node = (val < node.val) ? node.left : node.right;
        }
        // val is not in the tree, or val is in the tree but left child does not exist
        if (node == null || node.left == null) {
            Node prev = maxAncestor(new Node(val), ancestors);
            if (prev == null) throw new NoSuchElementException(); // prev does not exist
            return prev.val; // prev exists
        }
        // val is in the tree and left child exists
        return maxValue(node.left);
    }

    private Node maxAncestor(Node node, Stack<Node> ancestors) {
        Node max = new Node(Integer.MIN_VALUE);
        while (!ancestors.empty()) {
            Node other = ancestors.pop();
            if (node.compareTo(other) > 0 && other.compareTo(max) > 0) {
                max = other;
            }
        }
        return (max.val == Integer.MIN_VALUE) ? null : max;
    }
}
