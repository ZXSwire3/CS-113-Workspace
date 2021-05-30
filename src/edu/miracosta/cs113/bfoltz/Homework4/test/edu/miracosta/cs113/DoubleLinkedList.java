package edu.miracosta.cs113.bfoltz.Homework4.test.edu.miracosta.cs113;

import java.util.*;

public class DoubleLinkedList<E> extends AbstractSequentialList<E>
{  // Data fields
    	private Node<E> head = null;   // points to the head of the list
    	private Node<E> tail = null;   //points to the tail of the list
    	private int size = 0;    // the number of items in the list
  
  public void add(int index, E obj) {
      listIterator(index).add(obj);
  }
  public void addFirst(E obj) {
      Node current = new Node(obj);
      if (head != null) {
          current.next = head;
          head.prev = current;
      }
      head = current;

      size++;
  }
  public void addLast(E obj) { // Fill Here
      Node current = new Node(obj);
      if (tail != null) {
          current.prev = tail;
          tail.next = current;
      }

      tail = current;
      size++;
  }

  public E get(int index) {
      if (index < 0 || index >= size) {
          throw new IndexOutOfBoundsException();
      }
      ListIterator<E> iter = listIterator(index);
      return iter.next();
  }
  public E getFirst() { return head.data;  }
  public E getLast() { return tail.data;  }

  public int size() {
      return size;
  }

  public E remove(int index)
  {     E returnValue = null;
        ListIterator<E> iter = listIterator(index);
        if (iter.hasNext())
        {   returnValue = iter.next();
            iter.remove();
        }
        else {   throw new IndexOutOfBoundsException();  }
        return returnValue;
  }

  public Iterator iterator() { return new ListIter(0);  }
  public ListIterator listIterator() { return new ListIter(0);  }
  public ListIterator listIterator(int index){return new ListIter(index);}
  public ListIterator listIterator(ListIterator iter)
  {     return new ListIter( (ListIter) iter);  }

  // Inner Classes
  private static class Node<E>
  {     private E data;
        private Node<E> next = null;
        private Node<E> prev = null;

        private Node(E dataItem) {  //constructor
            data = dataItem;
        }
  }  // end class Node

  public class ListIter implements ListIterator<E> 
  {
        private Node<E> nextItem;      // the current node
        private Node<E> lastItemReturned;   // the previous node
        private int index = 0;

      public ListIter(int i) {
          // Validate i parameter.
          if (i < 0 || i > size) {
              throw new IndexOutOfBoundsException("Invalid index " + i);
          }
          lastItemReturned = null; // No item returned yet.
          // Special case of last item.
          if (i == size) {
              index = size;
              nextItem = null;
          } else { // Start at the beginning
              nextItem = head;
              for (index = 0; index < i; index++) {
                  nextItem = nextItem.next;
              }
          } //end else
      }  // end constructor

    public ListIter(ListIter other) {
        nextItem = other.nextItem;
        index = other.index;
    }

    public boolean hasNext() {
        return nextItem != null;
    }

    public boolean hasPrevious() {
        return index > 0;
    }
    public int previousIndex() {
        return index - 1;
    }
    public int nextIndex() {
        return index;
    }
    public void set(E o)  {
        if (lastItemReturned != null) {
            lastItemReturned.data = o;
        } else {
            throw new IllegalStateException();
        }
    }  // not implemented
    public void remove(){
        if (lastItemReturned != null) {
            if (lastItemReturned.prev != null) {
                lastItemReturned.prev.next = lastItemReturned.next;
            } else {
                head = lastItemReturned.next;
                if(head == null) {
                    tail = null;
                } else {
                    head.prev = null;
                }
            }

            if (lastItemReturned.next != null) {
                lastItemReturned.next.prev = lastItemReturned.prev;
            } else {
                tail = lastItemReturned.prev;
                if (tail == null) {
                    head = null;
                } else {
                    tail.next = null;
                }
            }

            lastItemReturned = null;
            index--;
            size--;
        } else {
            throw new IllegalStateException();
        }
    }

    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        lastItemReturned = nextItem;
        nextItem = nextItem.next;
        index++;
        return lastItemReturned.data;
    }

    public E previous() 
    {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        if (nextItem == null) { // Iterator is past the last element
            nextItem = tail;
        } else {
            nextItem = nextItem.prev;
        }
        lastItemReturned = nextItem;
        index--;
        return lastItemReturned.data;
    }

    public void add(E obj) {
        if (head == null) { // Add to an empty list.
            head = new Node<>(obj);
            tail = head;
        } else if (nextItem == head) { //insert at head
            //Create a new node.
            Node<E> newNode = new Node<>(obj);
            //Link it to the nextItem.
            newNode.next = nextItem;
            //Link nextItem to the new node.
            nextItem.prev = newNode;
            //The new node is now th head.
            head = newNode;
        } else if (nextItem == null) { //insert at tail
            //Create a new node.
            Node<E> newNode = new Node<E>(obj);
            //Link the tail to the new node.
            tail.next = newNode;
            //Link the new node to the tail
            newNode.prev = tail;
            //The new node is the new tail.
            tail = newNode;
        } else { //Insert into the middle
            //Create a new node.
            Node<E> newNode = new Node<E>(obj);
            //Link it to nextItem.prev.
            newNode.prev = nextItem.prev;
            nextItem.prev.next = newNode;
            //Link it to the nextItem.
            newNode.next = nextItem;
            nextItem.prev = newNode;
        }
        size++;
        index++;
        lastItemReturned = null;
    }
  }// end of inner class ListIter
}// end of class DoubleLinkedList
