package mendelProblems;

public class Trees {
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
    class ValidateBST {
        // Defines tree node. Do not modify.
        public class Node {
            public int val;
            public Node left;
            public Node right;
            public Node(int val) {this.val = val;}
        }
        public boolean isValidBST(Node root) {

        }
    }

    /**
     * Problem 2: Binary Search Tree
     *
     * Implement a binary search tree of integers with add() and contains() functions
     *
     * Feel free to modify anything, as long as you deliever the functionality defined in the comments and method headers
     */
// Implement this class
    class BST {
        // Define a treenode
        class Node {


        }

        // Add members here

        // Initialize a tree (initially empty)
        public BST() {

        }

        // If the tree does not already contain the value, add it to the tree
        public void add(int val) {

        }

        // Return true if the tree contains the value, false otherwise
        public boolean contains(int val) {

        }
    }

    /**
     * Problem 3: Iterator
     *
     * Implement an iterator over your BST, and be able to get an iterator from the BST
     *
     * You may modify the BST class, but not in a way that disrupts previously implemented functionality
     *
     */
// Implement this class
    class Iterator {

        // Add members here

        // Create a constructor for the iterator

        // Checks if there is a next element
        public boolean hasNext() {

        }

        // Returns the next element and advances the iterator. Throw a NoSuchElementException if there is no such element
        public int next() {

        }
    }
    // Implement this method and add it to the BST class
    public Iterator iterator() {

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

    }
    public int minValue() {

    }

    /**
     * Problem 5: Next and Previous
     *
     * Add the following methods:
     * next(value) returns the smallest element in the tree that is greater than value
     * prev(value) returns the smallest element in the tree that is less than value
     *
     * Consider that the input value does not neccesarily have to be in the tree
     *
     * You may modify the BST class, but not in a way that disrupts previously implemented functionality
     *
     */
// Implement these methods and add them to the BST class. Throw a NoSuchElementException if there is no such next/previous element
    public int next(int val) {

    }
    public int prev(int val) {

    }

    /**
     * Problem 6: Trie
     *
     * Implement a trie as described here: https://www.quora.com/What-is-the-difference-between-a-tree-a-prefix-tree-and-a-radix-tree/answer/John-Kurlak
     *
     * To simplify the problem: your trie need only store lowercased, alphabetic strings (lowercase characters only)
     *
     */
// Implement this class
    class Trie {

        // Define a trienode. Note that each node stores a character
        class Node {
            public char val;

        }

        // Add members here

        // Initialize an empty tree
        public Trie() {

        }

        // If the trie does not already contain the string, add it to the trie
        public void add(String s) {

        }

        // Return true if the trie contains the string, false otherwise
        public boolean contains(String s) {

        }
    }

    /**
     * Problem 7: Alphabetize
     *
     * Print the trie in alphabetical order, without using extra space (i.e. don't simply get all the strings in the tree and sort them)
     * You may have to make modifications to your previous implementation. Do so without disrupting the previously specified functionality
     *
     */
// Implement this method and add it to the Trie class
    public void printSorted() {

    }
}
