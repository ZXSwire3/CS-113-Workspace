package edu.miracosta.cs113.bfoltz.Homework5.src.edu.miracosta.cs113;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Objects;

public class ArrayListStack<E> implements StackInterface<E> {

    private ArrayList<E> stack;
    private int count;

    public ArrayListStack() {
        stack = new ArrayList<>();
        count = -1;
    }
    @Override
    public boolean empty() {
        return stack.isEmpty();
    }

    @Override
    public E peek() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.get(count);
    }

    @Override
    public E pop() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.remove(count--);
    }

    @Override
    public E push(E obj) {
        stack.add(obj);
        count++;
        return obj;
    }

    @Override
    public String toString() {
        return "" + stack;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayListStack<?> that = (ArrayListStack<?>) o;
        return stack.equals(that.stack);
    }

}
