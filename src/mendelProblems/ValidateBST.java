package mendelProblems;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Problem 1: Valid Binary Search Tree
 *
 * Determine if the given tree is a valid binary search tree
 *
 * Assume a tree is a binary search tree iff:
 * 1. The left subtree of node with key k has only values less than k
 * 2. The right subtree of a node with key k has only values greater than k
 * 3. The left and right subtrees are also binary search trees
 *
 */
public class ValidateBST {
    // Defines tree node. Do not modify.
    static class Node {
        int val;
        Node left;
        Node right;
        public Node(int val) {this.val = val;}
    }

    // Keep track of max and min; use definition of BST
    public static boolean isValidBST(Node root) {
        if (root == null) return true;
        return helper(root, null, null);
    }

    private static boolean helper(Node root, Integer min, Integer max) {
        if (root == null) return true;
        if (max != null && root.val >= max) return false;
        if (min != null && root.val <= min) return false;
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }

    // Generate array via in-order traversal; check if array is sorted
    public static boolean isValidBSTSlow(Node root) {
        if (root == null) return true;

        ArrayList<Integer> vals = new ArrayList<>();
        buildList(root, vals);

        Iterator<Integer> itr = vals.iterator();
        int cur = itr.next();
        while (itr.hasNext()) {
            int tmp = itr.next();
            if (tmp <= cur) {
                return false;
            } else {
                cur = tmp;
            }
        }
        return true;
    }

    private static void buildList(Node root, ArrayList<Integer> vals) {
        if (root.left != null) {
            buildList(root.left, vals);
        }
        vals.add(root.val);
        if (root.right != null) {
            buildList(root.right, vals);
        }
    }
}
