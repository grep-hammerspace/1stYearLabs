package org.example.dsa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BFSTest {

    private org.example.dsa.BreadthFirstSearch bfs;

    // Level-structured graph from node 0:
    //   Level 0: 0
    //   Level 1: 1, 2
    //   Level 2: 3, 4
    private final Map<Integer, List<Integer>> levelGraph = Map.of(
        0, List.of(1, 2),
        1, List.of(3),
        2, List.of(4),
        3, List.of(),
        4, List.of()
    );

    // Disconnected: node 5 unreachable
    private final Map<Integer, List<Integer>> disconnected = Map.of(
        0, List.of(1),
        1, List.of(0),
        5, List.of()
    );

    // Cyclic: 0→1→2→0
    private final Map<Integer, List<Integer>> cyclic = Map.of(
        0, List.of(1),
        1, List.of(2),
        2, List.of(0)
    );

    @BeforeEach
    void setUp() {
        bfs = new org.example.dsa.BreadthFirstSearch();
    }

    @Test
    void bfsVisitsAllNodesInConnectedGraph() {
        List<Integer> result = bfs.bfs(levelGraph, 0);
        assertEquals(new HashSet<>(List.of(0, 1, 2, 3, 4)), new HashSet<>(result));
    }

    @Test
    void bfsLevelOrder() {
        List<Integer> result = bfs.bfs(levelGraph, 0);
        // 0 first, then 1 and 2 before 3 and 4
        assertEquals(0, result.get(0));
        assertTrue(result.indexOf(1) < result.indexOf(3));
        assertTrue(result.indexOf(2) < result.indexOf(4));
    }

    @Test
    void bfsDisconnectedGraphDoesNotVisitUnreachableNodes() {
        List<Integer> result = bfs.bfs(disconnected, 0);
        assertFalse(result.contains(5));
    }

    @Test
    void bfsSingleNode() {
        List<Integer> result = bfs.bfs(Map.of(0, List.of()), 0);
        assertEquals(List.of(0), result);
    }

    @Test
    void bfsCyclicGraphTerminates() {
        List<Integer> result = bfs.bfs(cyclic, 0);
        assertEquals(3, result.size());
    }
}
