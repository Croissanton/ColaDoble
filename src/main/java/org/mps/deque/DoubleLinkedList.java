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

        if(size() == 0){
            LinkedNode<T> newNode = new LinkedNode<T>(value, null, null);
            last = newNode;
            first = newNode;
        }
        else{
            LinkedNode<T> newNode = new LinkedNode<T>(value, null, first);
            first.setPrevious(newNode);
            first = newNode;
        }
        ++size;
    }

    @Override
    public void append(T value) {
        // TODO
        if(size() == 0){
            LinkedNode<T> newNode = new LinkedNode<T>(value, null, null);
            last = newNode;
            first = newNode;
        }
        else{
            LinkedNode<T> newNode = new LinkedNode<T>(value, last, null);
            last.setNext(newNode);
            last = newNode;
        }
        ++size;
    }

    @Override
    public void deleteFirst() {
        // TODO
        if (size() == 0){
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
        --size;
    }

    @Override
    public void deleteLast() {
        // TODO
        if (size() == 0){
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
        --size;
    }

    @Override
    public T first() {
        // TODO
        return first != null ? first.getItem() : null;
    }

    @Override
    public T last() {
        // TODO
        return last != null ? last.getItem() : null;
    }

    @Override
    public int size() {
        // TODO
        return size;
    }
}
