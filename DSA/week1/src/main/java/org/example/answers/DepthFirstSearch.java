package org.example.answers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class DepthFirstSearch {

    public List<Integer> dfs(Map<Integer, List<Integer>> graph, int start) {
        List<Integer> visited = new ArrayList<>();
        dfsRec(graph, start, new HashSet<>(), visited);
        return visited;
    }

    private void dfsRec(Map<Integer, List<Integer>> graph, int node,
                        Set<Integer> seen, List<Integer> visited) {
        if (seen.contains(node)) return;
        seen.add(node);
        visited.add(node);
        List<Integer> neighbours = graph.getOrDefault(node, List.of());
        for (int neighbour : neighbours) {
            dfsRec(graph, neighbour, seen, visited);
        }
    }

    public List<Integer> dfsIterative(Map<Integer, List<Integer>> graph, int start) {
        List<Integer> visited = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (seen.contains(node)) continue;
            seen.add(node);
            visited.add(node);
            List<Integer> neighbours = graph.getOrDefault(node, List.of());
            for (int i = neighbours.size() - 1; i >= 0; i--) {
                stack.push(neighbours.get(i));
            }
        }
        return visited;
    }
}
