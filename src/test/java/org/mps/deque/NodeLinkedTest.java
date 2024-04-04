package org.mps.deque;// Cristian Ruiz Martín y Mikolaj Zabski

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

/*
1. "when new" -> "is empty" -> checks that the linked node is empty
2. "when new" -> "null is first and last" -> checks that the linked node is the first and last node
3. "when new" -> "is a terminal node" -> checks that the linked node is a terminal node
4. "when new" -> "set item" -> checks that the linked node sets an item
5. "when previous is not null" -> "is not terminal node" -> checks that the linked node is not a terminal node
6. "when next is not null" -> "is not terminal node" -> checks that the linked node is not a terminal node
7. "when previous and next are not null" -> "is not terminal node" -> checks that the linked node is not a terminal node



 */
public class NodeLinkedTest {
    @Nested
    @DisplayName("when new")
    class WhenNew {

        LinkedNode<Object> linkedNode;

        @BeforeEach
        void createNewLinkedNodeWhenNew() {
            linkedNode = new LinkedNode<>(null, null, null);
        }

        @Test
        @DisplayName("is empty")
        void isEmptyWhenNew() {
            assertNull(linkedNode.getItem());
            assertNull(linkedNode.getPrevious());
            assertNull(linkedNode.getNext());
        }

        @Test
        @DisplayName("null is first and last")
        void isFirstAndLastNodeWhenNew() {
            assertTrue(linkedNode.isFirstNode());
            assertTrue(linkedNode.isLastNode());
        }

        @Test
        @DisplayName("is a terminal node")
        void isNotATerminalNodeWhenNew() {
            assertFalse(linkedNode.isNotATerminalNode());
        }

        @Test
        @DisplayName("set item")
        @CsvSource({"item1", "item2", "item3","1"})
        void setItemWhenNew() {
            linkedNode.setItem("item");
            assertEquals("item", linkedNode.getItem());
        }
    }

    @Nested
    @DisplayName("when previous is not null")
    class whenPreviousIsNotNull {
        LinkedNode<Object> linkedNode;

        @BeforeEach
        void createNewLinkedNode() {
            linkedNode = new LinkedNode<>(1, new LinkedNode<>(2,null,null), null);
        }

        @Test
        @DisplayName("is not terminal node")
        void isNotATerminalNodeWhenPrevNotNull() {
            assertFalse(linkedNode.isNotATerminalNode());
        }
    }

    @Nested
    @DisplayName("when next is not null")
    class whenNextIsNotNull {
        LinkedNode<Object> linkedNode;

        @BeforeEach
        void createNewLinkedNodeWhenPrevIsNull() {
            linkedNode = new LinkedNode<>(1, null, new LinkedNode<>(2,null,null));
        }

        @Test
        @DisplayName("is not terminal node")
        void isNotATerminalNodeWhenPrevIsNull() {
            assertFalse(linkedNode.isNotATerminalNode());
        }
    }

    @Nested
    @DisplayName("when previous and next are not null")
    class whenPreviousAndNextAreNotNull {
        LinkedNode<Object> linkedNode;

        @BeforeEach
        void createNewLinkedNodeWhenPrevAndNextNotNull() {
            linkedNode = new LinkedNode<>(1, new LinkedNode<>(2,null,null), new LinkedNode<>(3,null,null));
        }

        @Test
        @DisplayName("is not terminal node")
        void isNotATerminalNodeWhenPrevAndNextNotNull() {
            assertTrue(linkedNode.isNotATerminalNode());
        }
    }

}
