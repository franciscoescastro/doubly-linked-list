package test;

import doublyLinkedList.model.Student;
import doublyLinkedList.node.DoublyLinkedNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DoublyLinkedNodeTest {
    private DoublyLinkedNode<Student> doublyLinkedNode1;
    private DoublyLinkedNode<Student> doublyLinkedNode2;

    @Before
    public void initialize() {
        doublyLinkedNode1 = new DoublyLinkedNode<Student>(new Student("Francisco", 818593862, 3));
        doublyLinkedNode2 = new DoublyLinkedNode<Student>(new Student("Carlos Lo", 818593861, 4));
    }

    @Test
    public void testAddPrevious() {
        doublyLinkedNode1.addBefore(doublyLinkedNode2);
        assertEquals(doublyLinkedNode1.getPrevious(), doublyLinkedNode2);
        assertEquals(doublyLinkedNode2.getNext(), doublyLinkedNode1);
    }

    @Test
    public void testAddNext() {
        doublyLinkedNode1.addAfter(doublyLinkedNode2);
        assertEquals(doublyLinkedNode1.getNext(), doublyLinkedNode2);
        assertEquals(doublyLinkedNode2.getPrevious(), doublyLinkedNode1);
    }

    @Test
    public void testHasNext() {
        assertFalse(doublyLinkedNode1.hasNext());
        doublyLinkedNode1.addAfter(doublyLinkedNode2);
        assertTrue(doublyLinkedNode1.hasNext());
    }

    @Test
    public void testHasPrevious() {
        assertFalse(doublyLinkedNode1.hasPrevious());
        doublyLinkedNode1.addBefore(doublyLinkedNode2);
        assertTrue(doublyLinkedNode1.hasPrevious());
    }
}