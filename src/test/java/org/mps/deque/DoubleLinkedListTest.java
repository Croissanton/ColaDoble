package org.mps.deque;// Cristian Ruiz Martín y Mikolaj Zabski

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("A DoubleLinkedList")
public class DoubleLinkedListTest {
    @Nested
    @DisplayName("when new")
    class WhenNew {

        DoubleLinkedList<Object> doubleLinkedList;

        @BeforeEach
        void isInstantiatedAndNew() {
            doubleLinkedList = new DoubleLinkedList<>();
        }
        @Test
        @DisplayName("is empty")
        void isEmpty() {
            assertEquals(0, doubleLinkedList.size());
            assertNull(doubleLinkedList.first());
            assertNull(doubleLinkedList.last());
        }
        @Test
        @DisplayName("prepend")
        void prependingElement() {
            doubleLinkedList.prepend(1);
            assertEquals(1, doubleLinkedList.size());
            assertEquals(1, doubleLinkedList.first());
            assertEquals(1, doubleLinkedList.last());
        }
        @Test
        @DisplayName("append")
        void appendAnElement() {
            doubleLinkedList.append(2);
            assertEquals(1, doubleLinkedList.size());
            assertEquals(2, doubleLinkedList.first());
            assertEquals(2, doubleLinkedList.last());
        }

        @Test
        @DisplayName("throws DoubleLinkedQueueException when deleting first")
        void throwsExceptionWhenDeletingFirst() {
            assertThrows(Exception.class, () -> doubleLinkedList.deleteFirst());
        }

        @Test
        @DisplayName("throws DoubleLinkedQueueException when deleting last")
        void throwsExceptionWhenDeletingLast() {
            assertThrows(Exception.class, () -> doubleLinkedList.deleteLast());
        }

        @Test
        @DisplayName("throws DoubleLinkedQueueException when getting an element")
        void throwsExceptionWhenGetting() {
            assertThrows(Exception.class, () -> doubleLinkedList.get(0));
        }

        @Test
        @DisplayName("throws DoubleLinkedQueueException when removing an element")
        void throwsExceptionWhenRemoving() {
            assertThrows(Exception.class, () -> doubleLinkedList.remove(0));
        }

        @Test
        @DisplayName("throws DoubleLinkedQueueException when sorting")
        void throwsExceptionWhenSorting() {
            assertThrows(Exception.class, () -> doubleLinkedList.sort(Comparator.comparingInt(o -> (int) o)));
        }
    }

    @Nested
    @DisplayName("with one element")
    class AfterPrepending {

        DoubleLinkedList<Object> doubleLinkedList;

        @BeforeEach
        void isInstantiatedAndPrepended() {
            doubleLinkedList = new DoubleLinkedList<>();
            doubleLinkedList.prepend(1);
            // doubleLinkedList.append(1); sería equivalente
        }

        @Test
        @DisplayName("is not empty")
        void isNotEmpty() {
            assertEquals(1, doubleLinkedList.size());
            assertEquals(1, doubleLinkedList.first());
            assertEquals(1, doubleLinkedList.last());
        }

        @Test
        @DisplayName("prepend another element")
        void prependingAnElement() {
            doubleLinkedList.prepend(2);
            assertEquals(2, doubleLinkedList.size());
            assertEquals(2, doubleLinkedList.first());
            assertEquals(1, doubleLinkedList.last());
        }

        @Test
        @DisplayName("append another element")
        void appendingAnElement() {
            doubleLinkedList.append(3);
            assertEquals(2, doubleLinkedList.size());
            assertEquals(1, doubleLinkedList.first());
            assertEquals(3, doubleLinkedList.last());
        }

        @Test
        @DisplayName("deleteFirst deletes element and is empty")
        void deletingFirstElement() {
            doubleLinkedList.deleteFirst();
            assertEquals(0, doubleLinkedList.size());
            assertNull(doubleLinkedList.first());
            assertNull(doubleLinkedList.last());
        }

        @Test
        @DisplayName("deleteLast deletes element and is empty")
        void deletingLastElement() {
            doubleLinkedList.deleteLast();
            assertEquals(0, doubleLinkedList.size());
            assertNull(doubleLinkedList.first());
            assertNull(doubleLinkedList.last());
        }

        @Test
        @DisplayName("getting an element")
        void get() {
            assertEquals(1, doubleLinkedList.get(0));
        }

        @Test
        @DisplayName("deleting an element makes the list empty")
        void remove() {
            doubleLinkedList.remove(1);
            assertEquals(0, doubleLinkedList.size());
            assertNull(doubleLinkedList.first());
            assertNull(doubleLinkedList.last());
        }
    }

    @Nested
    @DisplayName("with two elements")
    class AfterPrependingTwoElements {

        DoubleLinkedList<Object> doubleLinkedList;

        @BeforeEach
        void IsInstantiatedAndTwoElementsPrepended() {
            doubleLinkedList = new DoubleLinkedList<>();
            doubleLinkedList.prepend(2);
            doubleLinkedList.prepend(1);
            //1 2
        }

        @Test
        @DisplayName("is not empty")
        void isNotEmpty() {
            assertEquals(2, doubleLinkedList.size());
            assertEquals(1, doubleLinkedList.first());
            assertEquals(2, doubleLinkedList.last());
        }

        @Test
        @DisplayName("prepend another element")
        void prepend() {
            doubleLinkedList.prepend(3);
            assertEquals(3, doubleLinkedList.size());
            assertEquals(3, doubleLinkedList.first());
            assertEquals(2, doubleLinkedList.last());
        }

        @Test
        @DisplayName("append another element")
        void append() {
            doubleLinkedList.append(4);
            assertEquals(3, doubleLinkedList.size());
            assertEquals(1, doubleLinkedList.first());
            assertEquals(4, doubleLinkedList.last());
        }

        @Test
        @DisplayName("deleteFirst deletes element")
        void deleteFirst() {
            doubleLinkedList.deleteFirst();
            assertEquals(1, doubleLinkedList.size());
            assertEquals(2, doubleLinkedList.first());
            assertEquals(2, doubleLinkedList.last());
        }

        @Test
        @DisplayName("deleteLast deletes element")
        void deleteLast() {
            doubleLinkedList.deleteLast();
            assertEquals(1, doubleLinkedList.size());
            assertEquals(1, doubleLinkedList.first());
            assertEquals(1, doubleLinkedList.last());
        }

        @Test
        @DisplayName("get element")
        void get() {
            assertEquals(1, doubleLinkedList.get(0));
            assertEquals(2, doubleLinkedList.get(1));
        }

        @Test
        @DisplayName("delete element")
        void remove() {
            doubleLinkedList.remove(1);
            assertEquals(1, doubleLinkedList.size());
            assertEquals(2, doubleLinkedList.first());
            assertEquals(2, doubleLinkedList.last());
        }
    }

    // No hace falta hacer un nested para el caso donde se añade un elemento al final,
    // ya que es simétrico al caso de prepend (puesto que si hay solo un elemento, el primero y el último son el mismo).
    // Se puede hacer un test directamente en el nivel superior.

    @Test
    @DisplayName("Appending to an empty list results in a list with one element, which is both the first and the last")
    void appendToEmptyList() {
        DoubleLinkedList<Object> doubleLinkedList = new DoubleLinkedList<>();
        doubleLinkedList.append(1);
        assertEquals(1, doubleLinkedList.size());
        assertEquals(1, doubleLinkedList.first());
        assertEquals(1, doubleLinkedList.last());
    }

    @Test
    @DisplayName("Sorting a list with more than two elements")
    void sort() {
        DoubleLinkedList<Object> doubleLinkedList = new DoubleLinkedList<>();
        doubleLinkedList.append(3);
        doubleLinkedList.append(1);
        doubleLinkedList.append(2);
        doubleLinkedList.sort(Comparator.comparingInt(o -> (int) o));
        assertEquals(1, doubleLinkedList.get(0));
        assertEquals(2, doubleLinkedList.get(1));
        assertEquals(3, doubleLinkedList.get(2));
    }

    @Test
    @DisplayName("Getting an element out of bounds throws an exception")
    void getOutOfBounds() {
        DoubleLinkedList<Object> doubleLinkedList = new DoubleLinkedList<>();
        assertThrows(Exception.class, () -> doubleLinkedList.get(0));
    }

    @Test
    @DisplayName("Contains returns true if the element is in the list")
    void contains() {
        DoubleLinkedList<Object> doubleLinkedList = new DoubleLinkedList<>();
        doubleLinkedList.append(1);
        doubleLinkedList.append(2);
        doubleLinkedList.append(3);
        assertTrue(doubleLinkedList.contains(2));
    }

    @Test
    @DisplayName("Contains returns false if the element is not in the list")
    void notContains() {
        DoubleLinkedList<Object> doubleLinkedList = new DoubleLinkedList<>();
        doubleLinkedList.append(1);
        doubleLinkedList.append(2);
        doubleLinkedList.append(3);
        assertFalse(doubleLinkedList.contains(4));
    }

}
