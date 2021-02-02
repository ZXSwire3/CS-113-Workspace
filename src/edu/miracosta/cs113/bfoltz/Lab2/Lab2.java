package edu.miracosta.cs113.bfoltz.Lab2;

public class Lab2 {

    public static boolean isPowerOf2(int n) {
        while (n % 2 == 0) {
            n = n/2;
        }
        return n == 1;
    }
}
