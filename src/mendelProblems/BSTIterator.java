package mendelProblems;

import java.util.Iterator;
import java.util.Stack;

/**
 * Problem 3: Iterator
 *
 * Implement an iterator over your BST, and be able to get an iterator from the BST
 *
 * You may modify the BST class, but not in a way that disrupts previously implemented functionality
 *
 */
// Implement this class
class BSTIterator implements Iterator<Integer> {
    // Add members here
    private Stack<BST.Node> stack = new Stack<>();

    // Create a constructor for the iterator
    public BSTIterator(BST.Node root) {
        pushLefts(root);
    }

    public boolean hasNext() {
        return !stack.empty();
    }

    // Returns the next element and advances the iterator. Throw a NoSuchElementException if there is no such element
    public Integer next() {
        BST.Node tmp = stack.pop();
        BST.Node right = tmp.right;
        pushLefts(right);
        return tmp.val;
    }

    private void pushLefts(BST.Node node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
