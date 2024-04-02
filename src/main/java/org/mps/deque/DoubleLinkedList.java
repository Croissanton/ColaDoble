// Cristian Ruiz Martín y Mikolaj Zabski

package org.mps.deque;

public class DoubleLinkedList<T> implements DoubleLinkedQueue<T> {

    private LinkedNode<T> first;
    private LinkedNode<T> last;
    private int size;

    public DoubleLinkedList() {
        // TODO
        first = null;
        last = null;
        size = 0;
        
    }

    @Override
    public void prepend(T value) {
        // TODO
        LinkedNode<T> newNode = new LinkedNode<T>(value, null, first);
        if (first != null){
            first.setPrevious(newNode);
            if(last == null){
                last = first;
            }
        }
        else{
            last = newNode;
        }
        first = newNode;
    }

    @Override
    public void append(T value) {
        // TODO
        LinkedNode<T> newNode = new LinkedNode<T>(value, last, null);
        if (last != null){
            last.setNext(newNode);
            if(first == null){
                first = last;
            }
        }
        else{
            first = newNode;
        }
        last = newNode;
    }

    @Override
    public void deleteFirst() {
        // TODO
        if (first == null){
            throw new DoubleLinkedQueueException("The deque is empty");
        }
        if (first.getNext() == null){
            first = null;
            last = null;
        }
        else{
            first = first.getNext();
            first.setPrevious(null);
        }
    }

    @Override
    public void deleteLast() {
        // TODO
        if (last == null){
            throw new DoubleLinkedQueueException("The deque is empty");
        }
        if (last.getPrevious() == null){
            first = null;
            last = null;
        }
        else{
            last = last.getPrevious();
            last.setNext(null);
        }
    }

    @Override
    public T first() {
        // TODO
        return first.getItem();
    }

    @Override
    public T last() {
        // TODO
        return last.getItem();
    }

    @Override
    public int size() {
        // TODO
        LinkedNode<T> current = first;
        int count = 0;
        while (current != null){
            count++;
            current = current.getNext();
        }
        return count;
    }
}
