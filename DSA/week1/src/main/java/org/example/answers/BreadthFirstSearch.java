package org.example.answers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstSearch {

    public List<Integer> bfs(Map<Integer, List<Integer>> graph, int start) {
        List<Integer> visited = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        seen.add(start);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited.add(node);
            for (int neighbour : graph.getOrDefault(node, List.of())) {
                if (!seen.contains(neighbour)) {
                    seen.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }
        return visited;
    }
}
