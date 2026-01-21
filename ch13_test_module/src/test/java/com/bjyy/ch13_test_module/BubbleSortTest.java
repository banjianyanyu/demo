package com.bjyy.ch13_test_module;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {
    
    @Test
    void testBubbleSortAsc() {
        int[] arr = {5, 2, 9, 1, 5, 6};
        int[] expected = {1, 2, 5, 5, 6, 9};
        assertArrayEquals(expected, BubbleSort.bubbleSortAsc(arr));
    }
    
    @Test
    void testBubbleSortDesc() {
        int[] arr = {5, 2, 9, 1, 5, 6};
        int[] expected = {9, 6, 5, 5, 2, 1};
        assertArrayEquals(expected, BubbleSort.bubbleSortDesc(arr));
    }
    
    @Test
    void testBubbleSortAscWithEmptyArray() {
        int[] arr = {};
        int[] expected = {};
        assertArrayEquals(expected, BubbleSort.bubbleSortAsc(arr));
    }
    
    @Test
    void testBubbleSortDescWithEmptyArray() {
        int[] arr = {};
        int[] expected = {};
        assertArrayEquals(expected, BubbleSort.bubbleSortDesc(arr));
    }
    
    @Test
    void testBubbleSortAscWithSingleElement() {
        int[] arr = {42};
        int[] expected = {42};
        assertArrayEquals(expected, BubbleSort.bubbleSortAsc(arr));
    }
    
    @Test
    void testBubbleSortDescWithSingleElement() {
        int[] arr = {42};
        int[] expected = {42};
        assertArrayEquals(expected, BubbleSort.bubbleSortDesc(arr));
    }
    
    @Test
    void testBubbleSortAscWithAlreadySortedArray() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, BubbleSort.bubbleSortAsc(arr));
    }
    
    @Test
    void testBubbleSortDescWithAlreadySortedArray() {
        int[] arr = {5, 4, 3, 2, 1};
        int[] expected = {5, 4, 3, 2, 1};
        assertArrayEquals(expected, BubbleSort.bubbleSortDesc(arr));
    }
    
    @Test
    void testBubbleSortAscWithAllSameElements() {
        int[] arr = {3, 3, 3, 3, 3};
        int[] expected = {3, 3, 3, 3, 3};
        assertArrayEquals(expected, BubbleSort.bubbleSortAsc(arr));
    }
    
    @Test
    void testBubbleSortDescWithAllSameElements() {
        int[] arr = {3, 3, 3, 3, 3};
        int[] expected = {3, 3, 3, 3, 3};
        assertArrayEquals(expected, BubbleSort.bubbleSortDesc(arr));
    }
    
    @Test
    void testBubbleSortAscWithNegativeNumbers() {
        int[] arr = {-3, 10, -5, 7, 0};
        int[] expected = {-5, -3, 0, 7, 10};
        assertArrayEquals(expected, BubbleSort.bubbleSortAsc(arr));
    }
    
    @Test
    void testBubbleSortDescWithNegativeNumbers() {
        int[] arr = {-3, 10, -5, 7, 0};
        int[] expected = {10, 7, 0, -3, -5};
        assertArrayEquals(expected, BubbleSort.bubbleSortDesc(arr));
    }
}