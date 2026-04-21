package org.example.dsa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DFSTest {

    private org.example.dsa.DepthFirstSearch dfs;

    // Connected graph: 0-1, 0-2, 1-3, 2-3
    private final Map<Integer, List<Integer>> connected = Map.of(
        0, List.of(1, 2),
        1, List.of(0, 3),
        2, List.of(0, 3),
        3, List.of(1, 2)
    );

    // Disconnected: node 4 is unreachable from 0
    private final Map<Integer, List<Integer>> disconnected = Map.of(
        0, List.of(1),
        1, List.of(0),
        4, List.of()
    );

    // Cyclic: 0→1→2→0
    private final Map<Integer, List<Integer>> cyclic = Map.of(
        0, List.of(1),
        1, List.of(2),
        2, List.of(0)
    );

    @BeforeEach
    void setUp() {
        dfs = new org.example.dsa.DepthFirstSearch();
    }

    @Test
    void dfsVisitsAllNodesInConnectedGraph() {
        List<Integer> result = dfs.dfs(connected, 0);
        assertEquals(new HashSet<>(List.of(0, 1, 2, 3)), new HashSet<>(result));
    }

    @Test
    void dfsStartNodeIsFirst() {
        assertEquals(0, dfs.dfs(connected, 0).get(0));
    }

    @Test
    void dfsDisconnectedGraphDoesNotVisitUnreachableNodes() {
        List<Integer> result = dfs.dfs(disconnected, 0);
        assertFalse(result.contains(4));
    }

    @Test
    void dfsSingleNode() {
        List<Integer> result = dfs.dfs(Map.of(0, List.of()), 0);
        assertEquals(List.of(0), result);
    }

    @Test
    void dfsCyclicGraphTerminates() {
        List<Integer> result = dfs.dfs(cyclic, 0);
        assertEquals(3, result.size());
    }

    @Test
    void iterativeAndRecursiveVisitSameNodes() {
        List<Integer> recursive = dfs.dfs(connected, 0);
        List<Integer> iterative = dfs.dfsIterative(connected, 0);
        assertEquals(new HashSet<>(recursive), new HashSet<>(iterative));
    }
}
