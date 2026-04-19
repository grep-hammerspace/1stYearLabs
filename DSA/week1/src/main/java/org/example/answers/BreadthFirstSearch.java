package org.example.answers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstSearch {

    // BFS visits all nodes at the current depth before moving to the next level,
    // which guarantees the shortest path (in terms of edge count) in unweighted graphs.
    public List<Integer> bfs(Map<Integer, List<Integer>> graph, int start) {
        List<Integer> visited = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        // A queue gives FIFO ordering — nodes discovered earlier are explored earlier,
        // which is what produces the level-by-level traversal.
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        // Mark the start node as seen immediately so it is never enqueued again
        // if another path leads back to it (important for cyclic graphs).
        seen.add(start);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited.add(node);
            for (int neighbour : graph.getOrDefault(node, List.of())) {
                // Only enqueue unseen neighbours to prevent processing the same node twice.
                if (!seen.contains(neighbour)) {
                    seen.add(neighbour); // Mark before enqueue, not after, to avoid duplicates in the queue.
                    queue.add(neighbour);
                }
            }
        }
        return visited;
    }
}
