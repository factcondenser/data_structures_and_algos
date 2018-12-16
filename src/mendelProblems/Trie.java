package mendelProblems;
import java.util.Stack;

/**
 * Problem 6: Trie
 *
 * Implement a trie as described here: https://www.quora.com/What-is-the-difference-between-a-tree-a-prefix-tree-and-a-radix-tree/answer/John-Kurlak
 *
 * To simplify the problem: your trie need only store lowercased, alphabetic strings (lowercase characters only)
 *
 *
 *
 abs
 absolve
 absolute
 effect
 effective
 efficient
 elegant'

 absolve
 ^
 ''
    ->a
        b
            *s
                o
                    l
                        v
                            *e
                        u
                            t
                                *e
    e
        f
            f
                e
                    c
                        *t
                            i
                                v
                                    *e
                i
                    c
                        i
                            e
                                n
                                    *t
       l
            e
                g
                    a
                        n
                            *t
 */
// Implement this class
public class Trie {

    // Define a trienode. Note that each node stores a character
    class Node {
        public char val;
        public boolean isLeaf;
        public Node[] children;

        // public Node(char val, boolean isLeaf) {
        // this.val = val;
        // this.isLeaf = isLeaf;
        // this.children = new Node[26];
        // }
        public Node(char val) {
            this.val = val;
            this.isLeaf = false;
            this.children = new Node[26];
        }

    }


    // Add members here
    private Node root;

    // Initialize an empty tree
    public Trie() {
        root = new Node((char) 0);
    }

    // If the trie does not already contain the string, add it to the trie
    public void add(String s) {
        if (!contains(s)) {
            Node curNode = root;
            for (char c : s.toCharArray()) {
                if (curNode.children[c - 'a'] == null) {
                    curNode.children[c - 'a'] = new Node(c);
                }
                curNode = curNode.children[c - 'a'];
            }
            curNode.isLeaf = true; // Should I write and use a setter method instead?
        }
    }

    // Return true if the trie contains the string, false otherwise
    public boolean contains(String s) {
        Node curNode = root;
        for (char c : s.toCharArray()) {
            if (curNode.children[c - 'a'] == null) {
                return false;
            }
            curNode = curNode.children[c - 'a'];
        }
        return curNode.isLeaf;
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
        printSortedHelper(root, "");
    }

    private void printSortedHelper(Node node, String str) {
        if (node.isLeaf) {
            System.out.println(str);
            return;
        }
        for (Node child : node.children) {
            if (child != null) {
                printSortedHelper(child, str + child.val);
            }
        }
    }
}
