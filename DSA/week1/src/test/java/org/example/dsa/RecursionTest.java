package org.example.dsa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecursionTest {

    private org.example.dsa.Recursion r;

    @BeforeEach
    void setUp() {
        r = new org.example.dsa.Recursion();
    }

    @Test
    void factorialZero() {
        assertEquals(1L, r.factorial(0));
    }

    @Test
    void factorialOne() {
        assertEquals(1L, r.factorial(1));
    }

    @Test
    void factorialPositive() {
        assertEquals(120L, r.factorial(5));
    }

    @Test
    void factorialNegativeThrows() {
        assertThrows(IllegalArgumentException.class, () -> r.factorial(-1));
    }

    @Test
    void fibonacciZero() {
        assertEquals(0, r.fibonacci(0));
    }

    @Test
    void fibonacciOne() {
        assertEquals(1, r.fibonacci(1));
    }

    @Test
    void fibonacciPositive() {
        assertEquals(55, r.fibonacci(10));
    }

    @Test
    void fibonacciNegativeThrows() {
        assertThrows(IllegalArgumentException.class, () -> r.fibonacci(-1));
    }

    @Test
    void sumOfDigits() {
        assertEquals(6, r.sumOfDigits(123));
        assertEquals(1, r.sumOfDigits(1000));
    }


    @Test
    void powerPositiveExp() {
        assertEquals(1024L, r.power(2, 10));
    }

    @Test
    void powerZeroExp() {
        assertEquals(1L, r.power(99, 0));
    }

    @Test
    void powerNegativeExpThrows() {
        assertThrows(IllegalArgumentException.class, () -> r.power(2, -1));
    }
}
