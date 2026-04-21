package org.example.dsa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    private org.example.answers.MyArrayList<Integer> arr;

    @BeforeEach
    void setUp() {
        arr = new org.example.answers.MyArrayList<>();
        arr.set(0, 10);
        arr.set(1, 20);
        arr.set(2, 30);
        arr.set(3, 40);
        arr.set(4, 50);
    }

    @Test
    void getReturnsCorrectElement() {
        assertEquals(10, arr.get(0));
        assertEquals(30, arr.get(2));
        assertEquals(50, arr.get(4));
    }

    @Test
    void setUpdatesElement() {
        arr.set(2, 99);
        assertEquals(99, arr.get(2));
    }

    @Test
    void containsReturnsTrueWhenPresent() {
        assertTrue(arr.contains(20));
    }

    @Test
    void containsReturnsFalseWhenAbsent() {
        assertFalse(arr.contains(999));
    }

    @Test
    void indexOfReturnsCorrectIndex() {
        assertEquals(1, arr.indexOf(20));
    }

    @Test
    void indexOfReturnsMinusOneWhenAbsent() {
        assertEquals(-1, arr.indexOf(999));
    }

    @Test
    void getThrowsOnNegativeIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> arr.get(-1));
    }

    @Test
    void getThrowsOnIndexEqualToLength() {
        assertThrows(IndexOutOfBoundsException.class, () -> arr.get(5));
    }

    @Test
    void setWithABigIndexGrowsTheArray(){
        arr.set(5,87);
        assertEquals(arr.length(),10);
        assertThrows(NoSuchElementException.class, () -> arr.get(6));
    }
}
