package org.mps.deque;// Cristian Ruiz Martín y Mikolaj Zabski

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

/*
1. "is empty" Lista vacía -> size = 0, first = null, last = null
2. "prepend" Lista vacia -> prepend(1) -> size = 1, first = 1, last = 1
3. "append" Lista vacía -> append(2) -> size = 1, first = 2, last = 2
4. "throws DoubleLinkedQueueException when deleting first" Lista vacía -> deleteFirst() -> excepción
5. "throws DoubleLinkedQueueException when deleting last" Lista vacía -> deleteLast() -> excepción
6. "throws DoubleLinkedQueueException when getting an element" Lista vacía -> get(0) -> excepción
7. "throws DoubleLinkedQueueException when removing an element" Lista vacía -> remove(0) -> excepción
8. "throws DoubleLinkedQueueException when sorting" Lista vacía -> sort(Comparator.comparingInt(o -> (int) o)) -> excepción
9. "is not empty" Lista con un elemento -> size = 1, first = 1, last = 1
10. "prepend another element" Lista con un elemento -> prepend(2) -> size = 2, first = 2, last = 1
11. "append another element" Lista con un elemento -> append(3) -> size = 2, first = 1, last = 3
12. "deleteFirst deletes element and is empty" Lista con un elemento -> deleteFirst() -> size = 0, first = null, last = null
13. "deleteLast deletes element and is empty" Lista con un elemento -> deleteLast() -> size = 0, first = null, last = null
14. "getting an element" Lista con un elemento -> get(0) -> 1
15. "deleting an element makes the list empty" Lista con un elemento -> remove(1) -> size = 0, first = null, last = null
16. "is not empty" Lista con dos elementos -> size = 2, first = 1, last = 2
17. "prepend another element" Lista con dos elementos -> prepend(3) -> size = 3, first = 3, last = 2
18. "append another element" Lista con dos elementos -> append(4) -> size = 3, first = 1, last = 4
19. "deleteFirst deletes element" Lista con dos elementos -> deleteFirst() -> size = 1, first = 2, last = 2
20. "deleteLast deletes element" Lista con dos elementos -> deleteLast() -> size = 1, first = 1, last = 1
21. "get element" Lista con dos elementos -> get(0) -> 1, get(1) -> 2
22. "delete element" Lista con dos elementos -> remove(1) -> size = 1, first = 2, last = 2
23. "Sorting a list with more than two elements" Lista con tres elementos -> append(3), append(1), append(2) -> sort(Comparator.comparingInt(o -> (int) o)) -> get(0) -> 1, get(1) -> 2, get(2) -> 3
24. "Getting an element out of bounds throws an exception" Lista vacía -> get(0) -> excepción
25. "Contains returns true if the element is in the list" Lista con tres elementos -> append(1), append(2), append(3) -> contains(2) -> true
26. "Contains returns false if the element is not in the list" Lista con tres elementos -> append(1), append(2), append(3) -> contains(4) -> false
27. "Remove element not in the list" Lista con tres elementos -> append(1), append(2), append(3) -> remove(4) -> size = 3
28. "Remove last element in the list" Lista con tres elementos -> append(1), append(2), append(3) -> remove(3) -> size = 2
29. "Remove middle element in the list" Lista con tres elementos -> append(1), append(2), append(3) -> remove(2) -> size = 2
30. "get negative index throws exception" Lista vacía -> get(-1) -> excepción





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

        @Test
        @DisplayName("throws DoubleLinkedQueueException when getting an element")
        void throwsExceptionWhenGettingInEmpty() {
            assertThrows(Exception.class, () -> doubleLinkedList.get(0));
        }

        @Test
        @DisplayName("throws DoubleLinkedQueueException when removing an element")
        void throwsExceptionWhenRemovingInEmpty() {
            assertThrows(Exception.class, () -> doubleLinkedList.remove(0));
        }

        @Test
        @DisplayName("throws DoubleLinkedQueueException when sorting")
        void throwsExceptionWhenSortingInEmpty() {
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

        @Test
        @DisplayName("getting an element")
        void gettingFromListWithOneElement() {
            assertEquals(1, doubleLinkedList.get(0));
        }

        @Test
        @DisplayName("deleting an element makes the list empty")
        void removingFromListWithOneElement() {
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

        @Test
        @DisplayName("get element with two elements")
        void gettingFromListWithTwoElements() {
            assertEquals(1, doubleLinkedList.get(0));
            assertEquals(2, doubleLinkedList.get(1));
        }

        @Test
        @DisplayName("remove element with two elements")
        void removingFromListWithTwoElements() {
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
    @DisplayName("Sorting a list with more than two elements")
    void sortingWithMoreThanTwo() {
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
    void containedInList() {
        DoubleLinkedList<Object> doubleLinkedList = new DoubleLinkedList<>();
        doubleLinkedList.append(1);
        doubleLinkedList.append(2);
        doubleLinkedList.append(3);
        assertTrue(doubleLinkedList.contains(2));
    }

    @Test
    @DisplayName("Contains returns false if the element is not in the list")
    void notContainedInList() {
        DoubleLinkedList<Object> doubleLinkedList = new DoubleLinkedList<>();
        doubleLinkedList.append(1);
        doubleLinkedList.append(2);
        doubleLinkedList.append(3);
        assertFalse(doubleLinkedList.contains(4));
    }

    @Test
    @DisplayName("Remove element not in the list")
    void removeNotInList() {
        DoubleLinkedList<Object> doubleLinkedList = new DoubleLinkedList<>();
        doubleLinkedList.append(1);
        doubleLinkedList.append(2);
        doubleLinkedList.append(3);
        doubleLinkedList.remove(4);
        assertEquals(3, doubleLinkedList.size());
    }

    @Test
    @DisplayName("Remove last element in the list")
    void removeLastElement() {
        DoubleLinkedList<Object> doubleLinkedList = new DoubleLinkedList<>();
        doubleLinkedList.append(1);
        doubleLinkedList.append(2);
        doubleLinkedList.append(3);
        doubleLinkedList.remove(3);
        assertEquals(2, doubleLinkedList.size());
    }

    @Test
    @DisplayName("Remove middle element in the list")
    void removeMiddleElement() {
        DoubleLinkedList<Object> doubleLinkedList = new DoubleLinkedList<>();
        doubleLinkedList.append(1);
        doubleLinkedList.append(2);
        doubleLinkedList.append(3);
        doubleLinkedList.remove(2);
        assertEquals(2, doubleLinkedList.size());
    }

    @Test
    @DisplayName("get negative index throws exception")
    void getNegativeIndex() {
        DoubleLinkedList<Object> doubleLinkedList = new DoubleLinkedList<>();
        assertThrows(Exception.class, () -> doubleLinkedList.get(-1));
    }


}
