package test;

import doublyLinkedList.model.Student;
import doublyLinkedList.node.DoublyLinkedNode;
import doublyLinkedList.node.NullDoublyLinkedNode;
import doublyLinkedList.strategy.LinkedOrder;
import doublyLinkedList.strategy.Order;
import org.junit.Test;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

public class LinkedOrderTest {
    @Test
    public void testAllocate() {
        Student student1 = new Student("Francisco", 818593862, 3);

        DoublyLinkedNode<Student> first = new NullDoublyLinkedNode<Student>();

        Order<Student> order = new LinkedOrder<Student>();
        DoublyLinkedNode<Student> node1 = order.allocate(first, student1);

        assertTrue(node1.getPrevious() instanceof NullDoublyLinkedNode);
        assertTrue(node1.getNext() instanceof NullDoublyLinkedNode);

        Student student2 = new Student("Leo", 818593861, 1.5f);
        DoublyLinkedNode<Student> node2 = order.allocate(node1, student2);

        assertSame(node1.getNext(), node2);
        assertSame(node1, node2.getPrevious());
        assertTrue(node2.getNext() instanceof NullDoublyLinkedNode);
        Student student3 = new Student("John", 818593860, 2);
        DoublyLinkedNode<Student> node3 = order.allocate(node1, student3);

        assertSame(node2.getNext(), node3);
        assertSame(node2, node3.getPrevious());

        Student student4 = new Student("Dan", 818593815, 2);
        DoublyLinkedNode<Student> node4 = order.allocate(node1, student4);

        assertSame(node3.getNext(), node4);
        assertTrue(node4.getNext() instanceof NullDoublyLinkedNode);
    }
}