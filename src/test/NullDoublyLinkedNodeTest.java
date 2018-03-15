package test;

import doublyLinkedList.model.Student;
import doublyLinkedList.node.DoublyLinkedNode;
import doublyLinkedList.node.NullDoublyLinkedNodeMultiton;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

public class NullDoublyLinkedNodeTest {
    private DoublyLinkedNode<Student> doublyLinkedNode1;
    private DoublyLinkedNode<Student> doublyLinkedNode2;

    @Before
    public void initialize() {
        doublyLinkedNode1 = NullDoublyLinkedNodeMultiton.getInstance(Student.class);
        doublyLinkedNode2 = NullDoublyLinkedNodeMultiton.getInstance(Student.class);
    }

    @Test
    public void testAddPrevious() {
        doublyLinkedNode1.addBefore(doublyLinkedNode2);
        assertNull(doublyLinkedNode1.getPrevious());
        assertNull(doublyLinkedNode2.getNext());
    }

    @Test
    public void testAddNext() {
        doublyLinkedNode1.addAfter(doublyLinkedNode2);
        assertNull(doublyLinkedNode1.getNext());
        assertNull(doublyLinkedNode2.getPrevious());
    }

    @Test
    public void testHasNext() {
        assertFalse(doublyLinkedNode1.hasNext());
        doublyLinkedNode1.addAfter(doublyLinkedNode2);
        assertFalse(doublyLinkedNode1.hasNext());
    }

    @Test
    public void testHasPrevious() {
        assertFalse(doublyLinkedNode1.hasPrevious());
        doublyLinkedNode1.addBefore(doublyLinkedNode2);
        assertFalse(doublyLinkedNode1.hasPrevious());
    }
}