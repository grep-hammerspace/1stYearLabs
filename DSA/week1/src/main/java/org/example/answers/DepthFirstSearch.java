package org.example.answers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class DepthFirstSearch {

    // DFS explores as deep as possible along each branch before backtracking.
    // The recursion call stack acts as the implicit DFS stack.
    public List<Integer> dfs(Map<Integer, List<Integer>> graph, int start) {
        List<Integer> visited = new ArrayList<>();
        dfsRec(graph, start, new HashSet<>(), visited);
        return visited;
    }

    // seen prevents revisiting nodes, which is necessary for graphs that may
    // contain cycles (unlike trees, which are acyclic by definition).
    private void dfsRec(Map<Integer, List<Integer>> graph, int node,
                        Set<Integer> seen, List<Integer> visited) {
        if (seen.contains(node)) return; // Already explored this node — skip to avoid loops.
        seen.add(node);
        visited.add(node);
        // getOrDefault handles nodes with no outgoing edges without throwing NullPointerException.
        List<Integer> neighbours = graph.getOrDefault(node, List.of());
        for (int neighbour : neighbours) {
            dfsRec(graph, neighbour, seen, visited);
        }
    }

    // Same traversal order as the recursive version, but uses an explicit stack
    // to avoid StackOverflowError on very deep graphs.
    public List<Integer> dfsIterative(Map<Integer, List<Integer>> graph, int start) {
        List<Integer> visited = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        while (!stack.isEmpty()) {
            int node = stack.pop();
            // A node may be pushed multiple times before it's processed, so check again here.
            if (seen.contains(node)) continue;
            seen.add(node);
            visited.add(node);
            List<Integer> neighbours = graph.getOrDefault(node, List.of());
            // Push neighbours in reverse order so the first neighbour is processed first
            // (the stack reverses insertion order), matching the recursive DFS behaviour.
            for (int i = neighbours.size() - 1; i >= 0; i--) {
                stack.push(neighbours.get(i));
            }
        }
        return visited;
    }
}
