package mendelProblems;

import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.Set;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashSet;

public class Graph {

    class Node {
        int val;
        List<Node> children;

        public Node(int val) {
            this.val = val;
            this.children = new ArrayList<>();
        }
    }

    // Use order of children in nodes
    public List<Integer> BFS(Node origin) {
        List<Integer> result = new ArrayList<>();
        if (origin == null) return result;

        Queue<Node> toVisit = new LinkedList<>();
        Set<Node> visited = new HashSet<>();

        toVisit.add(origin);
        visited.add(origin);
        while (!toVisit.isEmpty()) {
            Node curNode = toVisit.remove();
            result.add(curNode.val);
            for (Node node : curNode.children) {
                if (!visited.contains(node)) {
                    toVisit.add(node);
                    visited.add(node);
                }
            }
        }
        return result;
    }

    // Return num of connected components
    public int numConnectedComponents(Set<Node> graph) {
        if (graph == null) return 0;

        Set<Node> set = new HashSet<>();
        int result = 0;
        for (Node node : graph) {
            if (!set.contains(node)) {
                result++;
                Queue<Node> toVisit = new LinkedList<>();

                toVisit.add(node);
                while(!toVisit.isEmpty()) {
                    set.add(node);

                    for (Node node : node.children) {
                        if (!set.contains(node)) {
                            toVisit.add(node);
                        }
                    }
                }
            }
        }
        return result;
    }

    // Return -1 if no such path //
    public int shortestPath(Node src, Node dst) {
        if (src == null || dst == null) return -1;
        if (src == dst) return 0;

        int result = 0;
        Queue<Node> toVisit = new LinkedList<>();
        Set<Node> visited = new HashSet<>();

        toVisit.add(src);
        visited.add(src);
        while (!toVisit.isEmpty()) {
            Node curNode = toVisit.remove();
            if (curNode == dst) return result;
            result++;
            for (Node node : curNode.children) {
                if (!visited.contains(node)) {
                    toVisit.add(node);
                    visited.add(curNode);
                }
            }
        }
        return -1;
    }

    // Recursive and iterative
    public List<Integer> recursiveDFS(Node origin) {
        List<Integer> result = new ArrayList<>();
        if (origin == null) return result;

        Set<Node> visited = new HashSet<>();
        visited.add(origin);
        visit(origin, visited, result);
        return result;
    }

    private void visit(Node curNode, Set<Node> visited, List<Integer> list) {
        list.add(curNode.val);
        for (Node node : curNode.children) {
            if (!visited.contains(node)) {
                visited.add(node);
                visit(node, visited, list);
            }
        }
    }

    public List<Integer> iterativeDFS(Node origin) {
        List<Integer> result = new ArrayList<>();
        if (origin == null) return result;

        Stack<Node> toVisit = new Stack<>();
        Set<Node> visited = new HashSet<>();

        toVisit.push(origin);
        visited.add(origin);
        while (!toVisit.empty()) {
            Node curNode = toVisit.pop();
            result.add(curNode.val);
            for (Node node : curNode.children) {
                if (!visited.contains(node)) {
                    toVisit.push(node);
                    visited.add(node);
                }
            }
        }
        return result;
    }
}

//class weightedGraphProblems {
//
//    // adj[i][j][w] means there is an edge from node i to node j with weight w
//    // 0 <= i, j < n
//    int[][][] adj;
//
//    // Apply Djikstra's Algorithm
//    public int shortestPath(int src, int dst) {
//
//    }
//
//    // Apply Prim's Algorithm
//    public int minimumSpanningTree(int origin) {
//
//    }
//}