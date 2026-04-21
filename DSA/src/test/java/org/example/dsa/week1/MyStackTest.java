package org.example.dsa.week1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {

    private MyStack<Integer> stack;

    @BeforeEach
    void setUp() {
        stack = new MyStack<>();
    }

    @Test
    void isEmptyOnNew() {
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }

    @Test
    void isNotEmptyAfterPush() {
        stack.push(1);
        assertFalse(stack.isEmpty());
    }

    @Test
    void pushAndPop() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test
    void peekDoesNotRemove() {
        stack.push(42);
        assertEquals(42, stack.peek());
        assertEquals(42, stack.peek());
        assertEquals(1, stack.size());
    }

    @Test
    void popEmptyThrows() {
        assertThrows(EmptyStackException.class, () -> stack.pop());
    }

    @Test
    void peekEmptyThrows() {
        assertThrows(EmptyStackException.class, () -> stack.peek());
    }

    @Test
    void sizeTracksCorrectly() {
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.size());
        stack.pop();
        assertEquals(1, stack.size());
        stack.pop();
        assertEquals(0, stack.size());
    }
}
