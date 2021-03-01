package edu.miracosta.cs113.bfoltz.Lab3;

public class Lab3 {

    public static boolean isY1GreaterThanY2() {
        for(int i = 0; i < 100; i+=10) {
            int result1 = 100 * i + 10;
            int result2 = 5 * i * i + 2;
            return result1 > result2;
        }
        return false;
    }

}
