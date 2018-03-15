package test;

import doublyLinkedList.model.Student;
import doublyLinkedList.node.DoublyLinkedNode;
import doublyLinkedList.node.NullDoublyLinkedNode;
import doublyLinkedList.strategy.Order;
import doublyLinkedList.strategy.StudentNameLexicographicalOrder;
import org.junit.Test;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

public class StudentNameLexicographicalOrderTest {
    @Test
    public void testAllocate() {
        Student student1 = new Student("Francisco", 818593862, 3);

        DoublyLinkedNode<Student> first = new NullDoublyLinkedNode<Student>();

        Order<Student> order = new StudentNameLexicographicalOrder();
        DoublyLinkedNode<Student> node1 = order.allocate(first, student1);

        assertTrue(node1.getPrevious() instanceof NullDoublyLinkedNode);
        assertTrue(node1.getNext() instanceof NullDoublyLinkedNode);

        Student student2 = new Student("Leo", 818593861, 1.5f);
        DoublyLinkedNode<Student> node2 = order.allocate(node1, student2);

        assertSame(node1, node2.getPrevious());
        assertTrue(node2.getNext() instanceof NullDoublyLinkedNode);
        Student student3 = new Student("John", 818593860, 2);
        DoublyLinkedNode<Student> node3 = order.allocate(node1, student3);

        assertSame(node1, node3.getPrevious());
        assertSame(node2, node3.getNext());

        Student student4 = new Student("Dan", 818593815, 2);
        DoublyLinkedNode<Student> node4 = order.allocate(node1, student4);

        assertTrue(node4.getPrevious() instanceof NullDoublyLinkedNode);
        assertSame(node4.getNext(), node1);

        Student student5 = new Student("Wolf", 818598432, 2);
        DoublyLinkedNode<Student> node5 = order.allocate(node4, student5);

        assertSame(node5.getPrevious(), node2);
        assertTrue(node5.getNext() instanceof NullDoublyLinkedNode);
    }
}