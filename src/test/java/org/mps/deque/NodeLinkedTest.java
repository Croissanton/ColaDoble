package org.mps.deque;// Cristian Ruiz Martín y Mikolaj Zabski

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class NodeLinkedTest {
    @Nested
    @DisplayName("when new")
    class WhenNew {

        LinkedNode<Object> linkedNode;

        @BeforeEach
        void createNewLinkedNode() {
            linkedNode = new LinkedNode<>(null, null, null);
        }

        @Test
        @DisplayName("is empty")
        void isEmpty() {
            assertNull(linkedNode.getItem());
            assertNull(linkedNode.getPrevious());
            assertNull(linkedNode.getNext());
        }

        @Test
        @DisplayName("null is first and last")
        void isFirstAndLastNode() {
            assertTrue(linkedNode.isFirstNode());
            assertTrue(linkedNode.isLastNode());
        }

        @Test
        @DisplayName("is a terminal node")
        void isNotATerminalNode() {
            assertFalse(linkedNode.isNotATerminalNode());
        }

        @Test
        @DisplayName("set item")
        @CsvSource({"item1", "item2", "item3","1"})
        void setItem() {
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
        void isNotATerminalNode() {
            assertFalse(linkedNode.isNotATerminalNode());
        }
    }

    @Nested
    @DisplayName("when next is not null")
    class whenNextIsNotNull {
        LinkedNode<Object> linkedNode;

        @BeforeEach
        void createNewLinkedNode() {
            linkedNode = new LinkedNode<>(1, null, new LinkedNode<>(2,null,null));
        }

        @Test
        @DisplayName("is not terminal node")
        void isNotATerminalNode() {
            assertFalse(linkedNode.isNotATerminalNode());
        }
    }

    @Nested
    @DisplayName("when previous and next are not null")
    class whenPreviousAndNextAreNotNull {
        LinkedNode<Object> linkedNode;

        @BeforeEach
        void createNewLinkedNode() {
            linkedNode = new LinkedNode<>(1, new LinkedNode<>(2,null,null), new LinkedNode<>(3,null,null));
        }

        @Test
        @DisplayName("is not terminal node")
        void isNotATerminalNode() {
            assertTrue(linkedNode.isNotATerminalNode());
        }
    }

}
