package org.example.dsa.week1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {

    private org.example.dsa.week1.MyLinkedList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new org.example.dsa.week1.MyLinkedList<>();
    }

    @Test
    void addFirstPrepends() {
        list.addFirst(1);
        list.addFirst(2);
        assertEquals(2, list.get(0));
        assertEquals(1, list.get(1));
    }

    @Test
    void addLastAppends() {
        list.addLast(1);
        list.addLast(2);
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
    }

    @Test
    void removeFirstFromSingleElement() {
        list.addFirst(42);
        assertEquals(42, list.removeFirst());
        assertTrue(list.isEmpty());
    }

    @Test
    void removeLastFromSingleElement() {
        list.addFirst(42);
        assertEquals(42, list.removeLast());
        assertTrue(list.isEmpty());
    }

    @Test
    void removeFirstUpdatesHead() {
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.removeFirst();
        assertEquals(2, list.get(0));
        assertEquals(2, list.size());
    }

    @Test
    void removeLastUpdatesTail() {
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.removeLast();
        assertEquals(2, list.size());
        assertEquals(2, list.get(1));
    }

    @Test
    void removeFirstEmptyThrows() {
        assertThrows(NoSuchElementException.class, () -> list.removeFirst());
    }

    @Test
    void removeLastEmptyThrows() {
        assertThrows(NoSuchElementException.class, () -> list.removeLast());
    }

    @Test
    void getValidIndex() {
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        assertEquals(10, list.get(0));
        assertEquals(30, list.get(2));
    }

    @Test
    void getInvalidIndexThrows() {
        list.addLast(10);
        list.addLast(20);
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(5));
    }

    @Test
    void containsHitAndMiss() {
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        assertTrue(list.contains(20));
        assertFalse(list.contains(99));
    }

    @Test
    void sizeAfterAddRemove() {
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.removeFirst();
        assertEquals(2, list.size());
    }

    @Test
    void testPeekFirstDoesNotRemove(){
        list.addFirst(1);
        list.addFirst(2);
        assertEquals(2, list.peekFirst());
        assertEquals(2, list.peekFirst());
    }

    @Test
    void testPeekLastDoesNotRemove(){
        list.addLast(1);
        list.addLast(2);
        assertEquals(2, list.peekLast());
        assertEquals(2, list.peekLast());
    }
}
