// Cristian Ruiz Martín y Mikolaj Zabski

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mps.deque.DoubleLinkedList;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("A DoubleLinkedList")
public class DoubleLinkedListTest {
    @Nested
    @DisplayName("when new")
    class WhenNew {

        DoubleLinkedList<Object> doubleLinkedList;

        @BeforeEach
        void createNewDoubleLinkedList() {
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
        void prepend() {
            doubleLinkedList.prepend(1);
            assertEquals(1, doubleLinkedList.size());
            assertEquals(1, doubleLinkedList.first());
            assertEquals(1, doubleLinkedList.last());
        }
        @Test
        @DisplayName("append")
        void append() {
            doubleLinkedList.append(2);
            assertEquals(1, doubleLinkedList.size());
            assertEquals(2, doubleLinkedList.first());
            assertEquals(2, doubleLinkedList.last());
        }

        @Test
        @DisplayName("deleteFirst throws exception")
        void deleteFirst() {
            assertThrows(Exception.class, () -> doubleLinkedList.deleteFirst());
        }

        @Test
        @DisplayName("deleteLast throws exception")
        void deleteLast() {
            assertThrows(Exception.class, () -> doubleLinkedList.deleteLast());
        }
    }

    @Nested
    @DisplayName("with one element")
    class AfterPrepending {

        DoubleLinkedList<Object> doubleLinkedList;

        @BeforeEach
        void prependElement() {
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
        void prepend() {
            doubleLinkedList.prepend(2);
            assertEquals(2, doubleLinkedList.size());
            assertEquals(2, doubleLinkedList.first());
            assertEquals(1, doubleLinkedList.last());
        }

        @Test
        @DisplayName("append another element")
        void append() {
            doubleLinkedList.append(3);
            assertEquals(2, doubleLinkedList.size());
            assertEquals(1, doubleLinkedList.first());
            assertEquals(3, doubleLinkedList.last());
        }

        @Test
        @DisplayName("deleteFirst deletes element")
        void deleteFirst() {
            doubleLinkedList.deleteFirst();
            assertEquals(0, doubleLinkedList.size());
            assertNull(doubleLinkedList.first());
            assertNull(doubleLinkedList.last());
        }

        @Test
        @DisplayName("deleteLast deletes element")
        void deleteLast() {
            doubleLinkedList.deleteLast();
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
        void prependTwoElements() {
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

}
