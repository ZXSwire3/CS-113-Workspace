package edu.miracosta.cs113.bfoltz.Homework5.src.edu.miracosta.cs113;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class CircularArrayQueue<E> {

    private E[] circularArray;
    private int size;
    private int capacity;
    private int front;
    private int rear;
    private static final int DEFAULT_CAPACITY = 10;

    public CircularArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    public CircularArrayQueue(int initialCapacity) {
        capacity = initialCapacity;
        circularArray = (E[]) new Object[capacity];
        front = 0;
        rear = capacity - 1;
        size = 0;
    }

    public boolean add(E e) {
        if (size == capacity) {
            reallocate();
        }
        size++;
        //increases by one and then mod is important when rear is past capacity
        rear = (rear + 1) % capacity;
        circularArray[rear] = e;
        return true;
    }

    public boolean offer(E e) {
        return add(e);
    }

    public E remove() {
        if (size == 0) {
            throw new NoSuchElementException();
        }

        E result = circularArray[front];

        front = (front + 1) % capacity;
        size--;
        return result;
    }

    public E poll() {
        if (size == 0) {
            return null;
        }
        E result = circularArray[front];
        front = (front + 1) % capacity;
        size--;
        return result;
    }

    public E element() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return circularArray[front];
    }

    public E peek() {
        if (size == 0) {
            return null;
        }
        else {
            return circularArray[front];
        }
    }

    @SuppressWarnings("unchecked")
    private void reallocate() {
        int newCapacity = 2 * capacity;
        E[] newData = (E[]) new Object[newCapacity];

        //copies circular array from front to capacity minus the value of front because front could be in the middle of
        //the array and sub front from capacity it finds the end of where front loops
        System.arraycopy(circularArray, front, newData, 0, capacity - front);
        //copies from beginning of array to the end of the array, which is rear
        System.arraycopy(circularArray,0, newData, capacity - front, rear);

        front = 0;
        rear = size - 1;
        capacity = newCapacity;
        circularArray = newData;
    }
}
