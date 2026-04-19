package org.example.dsa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class MyQueueTest {

    private org.example.answers.MyQueue<Integer> queue;

    @BeforeEach
    void setUp() {
        queue = new org.example.answers.MyQueue<>();
    }

    @Test
    void isEmptyOnNew() {
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }

    @Test
    void enqueueAndDequeue() {
        queue.enqueue(1);
        assertEquals(1, queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @Test
    void fifoOrder() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
    }

    @Test
    void peekDoesNotRemove() {
        queue.enqueue(10);
        assertEquals(10, queue.peek());
        assertEquals(10, queue.peek());
        assertEquals(1, queue.size());
    }

    @Test
    void dequeueEmptyThrows() {
        assertThrows(NoSuchElementException.class, () -> queue.dequeue());
    }

    @Test
    void peekEmptyThrows() {
        assertThrows(NoSuchElementException.class, () -> queue.peek());
    }

    @Test
    void sizeTracksCorrectly() {
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(2, queue.size());
        queue.dequeue();
        assertEquals(1, queue.size());
    }
}
