package org.mps.deque;// Cristian Ruiz Martín y Mikolaj Zabski

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

/*
1. "when new" -> "is empty" -> checks if the list is empty when it is created.
2. "when new" -> "prepend" -> checks if the list is not empty after prepending an element.
3. "when new" -> "append" -> checks if the list is not empty after appending an element.
4. "when new" -> "throws DoubleLinkedQueueException when deleting first" -> checks if an exception is thrown when trying to delete the first element of an empty list.
5. "when new" -> "throws DoubleLinkedQueueException when deleting last" -> checks if an exception is thrown when trying to delete the last element of an empty list.
6. "with one element" -> "is not empty" -> checks if the list is not empty when it has one element.
7. "with one element" -> "prepend another element" -> checks if the list is not empty after prepending another element.
8. "with one element" -> "append another element" -> checks if the list is not empty after appending another element.
9. "with one element" -> "deleteFirst deletes element and is empty" -> checks if the list is empty after deleting the first element.
10. "with one element" -> "deleteLast deletes element and is empty" -> checks if the list is empty after deleting the last element.
11. "with two elements" -> "is not empty" -> checks if the list is not empty when it has two elements.
12. "with two elements" -> "prepend another element" -> checks if the list is not empty after prepending another element.
13. "with two elements" -> "append another element" -> checks if the list is not empty after appending another element.
14. "with two elements" -> "deleteFirst deletes element" -> checks if the list has one element after deleting the first element.
15. "with two elements" -> "deleteLast deletes element" -> checks if the list has one element after deleting the last element.

*/
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
        void prependingElementToEmpty() {
            doubleLinkedList.prepend(1);
            assertEquals(1, doubleLinkedList.size());
            assertEquals(1, doubleLinkedList.first());
            assertEquals(1, doubleLinkedList.last());
        }
        @Test
        @DisplayName("append")
        void appendAnElementToEmpty() {
            doubleLinkedList.append(2);
            assertEquals(1, doubleLinkedList.size());
            assertEquals(2, doubleLinkedList.first());
            assertEquals(2, doubleLinkedList.last());
        }

        @Test
        @DisplayName("throws DoubleLinkedQueueException when deleting first")
        void throwsExceptionWhenDeletingFirstInEmpty() {
            assertThrows(Exception.class, () -> doubleLinkedList.deleteFirst());
        }

        @Test
        @DisplayName("throws DoubleLinkedQueueException when deleting last")
        void throwsExceptionWhenDeletingLastInEmpty() {
            assertThrows(Exception.class, () -> doubleLinkedList.deleteLast());
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
        void isNotEmptyInListWithOneElement() {
            assertEquals(1, doubleLinkedList.size());
            assertEquals(1, doubleLinkedList.first());
            assertEquals(1, doubleLinkedList.last());
        }

        @Test
        @DisplayName("prepend another element")
        void prependingAnElementToListWithOneElement() {
            doubleLinkedList.prepend(2);
            assertEquals(2, doubleLinkedList.size());
            assertEquals(2, doubleLinkedList.first());
            assertEquals(1, doubleLinkedList.last());
        }

        @Test
        @DisplayName("append another element")
        void appendingAnElementToListWithOneElement() {
            doubleLinkedList.append(3);
            assertEquals(2, doubleLinkedList.size());
            assertEquals(1, doubleLinkedList.first());
            assertEquals(3, doubleLinkedList.last());
        }

        @Test
        @DisplayName("deleteFirst deletes element and is empty")
        void deletingFirstElementFromListWithOneElement() {
            doubleLinkedList.deleteFirst();
            assertEquals(0, doubleLinkedList.size());
            assertNull(doubleLinkedList.first());
            assertNull(doubleLinkedList.last());
        }

        @Test
        @DisplayName("deleteLast deletes element and is empty")
        void deletingLastElementFromListWithOneElement() {
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
        void IsInstantiatedAndTwoElementsPrepended() {
            doubleLinkedList = new DoubleLinkedList<>();
            doubleLinkedList.prepend(2);
            doubleLinkedList.prepend(1);
            //1 2
        }

        @Test
        @DisplayName("is not empty")
        void isNotEmptyInListWithTwoElements() {
            assertEquals(2, doubleLinkedList.size());
            assertEquals(1, doubleLinkedList.first());
            assertEquals(2, doubleLinkedList.last());
        }

        @Test
        @DisplayName("prepend another element")
        void prependToListWithTwoElements() {
            doubleLinkedList.prepend(3);
            assertEquals(3, doubleLinkedList.size());
            assertEquals(3, doubleLinkedList.first());
            assertEquals(2, doubleLinkedList.last());
        }

        @Test
        @DisplayName("append another element")
        void appendToListWithTwoElements() {
            doubleLinkedList.append(4);
            assertEquals(3, doubleLinkedList.size());
            assertEquals(1, doubleLinkedList.first());
            assertEquals(4, doubleLinkedList.last());
        }

        @Test
        @DisplayName("deleteFirst deletes element")
        void deleteFirstFromListWithTwoElements() {
            doubleLinkedList.deleteFirst();
            assertEquals(1, doubleLinkedList.size());
            assertEquals(2, doubleLinkedList.first());
            assertEquals(2, doubleLinkedList.last());
        }

        @Test
        @DisplayName("deleteLast deletes element")
        void deleteLastFromListWithTwoElements() {
            doubleLinkedList.deleteLast();
            assertEquals(1, doubleLinkedList.size());
            assertEquals(1, doubleLinkedList.first());
            assertEquals(1, doubleLinkedList.last());
        }

    }

}
