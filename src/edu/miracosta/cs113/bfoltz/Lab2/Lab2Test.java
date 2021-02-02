package edu.miracosta.cs113.bfoltz.Lab2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lab2Test {

    int[] numberArray = {5, 16, 64, 80};
    boolean[] results = {false, true, true, false};
    @Test
    void isPowerOf2() {
        assertEquals(results[0], Lab2.isPowerOf2(numberArray[0]));
        assertEquals(results[1], Lab2.isPowerOf2(numberArray[1]));
        assertEquals(results[2], Lab2.isPowerOf2(numberArray[2]));
        assertEquals(results[3], Lab2.isPowerOf2(numberArray[3]));
    }
}