// Cristian Ruiz Martín y Mikolaj Zabski

package org.mps.deque;

import java.util.Comparator;

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

    @Override
    public T get(int index) {
        // TODO
        if (index < 0 || index >= size()){
            throw new DoubleLinkedQueueException("Index out of bounds");
        }
        LinkedNode<T> current = first;
        for (int i = 0; i < index; ++i){
            current = current.getNext();
        }
        return current.getItem();
    }

    @Override
    public boolean contains(T value) {
        // TODO
        LinkedNode<T> current = first;
        while (current != null){
            if (current.getItem().equals(value)){
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    @Override
    public void remove(T value) {
        // TODO
        if(size() == 0){
            throw new DoubleLinkedQueueException("The deque is empty");
        }
        LinkedNode<T> current = first;
        while (current != null){
            if (current.getItem().equals(value)){
                if (current == first){
                    deleteFirst();
                }
                else if (current == last){
                    deleteLast();
                }
                else{
                    current.getPrevious().setNext(current.getNext());
                    current.getNext().setPrevious(current.getPrevious());

                    current.setNext(null);
                    current.setPrevious(null);
                    --size;
                }
                return;
            }
            current = current.getNext();
        }
    }

    @Override
    public void sort(Comparator<? super T> comparator) {
        // TODO
        if (size() < 2){
            throw new DoubleLinkedQueueException("The deque is too small to be sorted");
        }
        LinkedNode<T> current = first;
        while (current != null){
            LinkedNode<T> next = current.getNext();
            while (next != null){
                if (comparator.compare(current.getItem(), next.getItem()) > 0){
                    T temp = current.getItem();
                    current.setItem(next.getItem());
                    next.setItem(temp);
                }
                next = next.getNext();
            }
            current = current.getNext();
        }
    }
}
