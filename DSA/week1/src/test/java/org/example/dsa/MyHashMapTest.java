package org.example.dsa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyHashMapTest {

    private org.example.dsa.MyHashMap<String, Integer> map;

    @BeforeEach
    void setUp() {
        map = new org.example.dsa.MyHashMap<>();
    }

    @Test
    void isEmptyOnNew() {
        assertTrue(map.isEmpty());
        assertEquals(0, map.size());
    }

    @Test
    void putAndGet() {
        map.put("a", 1);
        assertEquals(1, map.get("a"));
    }

    @Test
    void putOverwritesExistingKey() {
        map.put("a", 1);
        map.put("a", 99);
        assertEquals(99, map.get("a"));
        assertEquals(1, map.size());
    }

    @Test
    void getMissingKeyReturnsNull() {
        assertNull(map.get("missing"));
    }

    @Test
    void removeExistingKeyReturnsOldValue() {
        map.put("a", 1);
        assertEquals(1, map.remove("a"));
        assertFalse(map.containsKey("a"));
    }

    @Test
    void removeMissingKeyReturnsNull() {
        assertNull(map.remove("missing"));
    }

    @Test
    void containsKeyTrueAndFalse() {
        map.put("a", 1);
        assertTrue(map.containsKey("a"));
        assertFalse(map.containsKey("b"));
    }

    @Test
    void sizeAfterPutAndRemove() {
        map.put("a", 1);
        map.put("b", 2);
        assertEquals(2, map.size());
        map.remove("a");
        assertEquals(1, map.size());
    }
}
