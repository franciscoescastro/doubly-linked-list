package edu.sdsu.doublylinkedlist.test;

import edu.sdsu.doublylinkedlist.model.Student;
import edu.sdsu.doublylinkedlist.node.NullDoublyLinkedNode;
import edu.sdsu.doublylinkedlist.node.NullDoublyLinkedNodeMultiton;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class NullDoublyLinkedNodeMultitonTest {
    @Test
    public void testGetInstance() {
        Class<Student> studentClass = Student.class;
        NullDoublyLinkedNode<Student> studentNode = new NullDoublyLinkedNode<Student>();
        NullDoublyLinkedNode<Student> nullStudentNode = NullDoublyLinkedNodeMultiton.getInstance(studentClass);

        assertEquals(studentNode.getValue(), nullStudentNode.getValue());
        assertEquals(studentNode.getNext(), nullStudentNode.getNext());
        assertEquals(studentNode.getPrevious(), nullStudentNode.getPrevious());
        assertEquals(studentNode.getClass(), nullStudentNode.getClass());
        assertEquals(NullDoublyLinkedNode.class, NullDoublyLinkedNodeMultiton.getInstance(studentClass).getClass());
        assertSame(nullStudentNode, NullDoublyLinkedNodeMultiton.getInstance(studentClass));
        assertSame(nullStudentNode, NullDoublyLinkedNodeMultiton.getInstance(studentClass));
        assertSame(nullStudentNode, NullDoublyLinkedNodeMultiton.getInstance(studentClass));

        Class<Integer> integerClass = Integer.class;

        NullDoublyLinkedNode<Integer> nullIntegerNode = NullDoublyLinkedNodeMultiton.getInstance(integerClass);
        assertEquals(studentNode.getValue(), nullIntegerNode.getValue());
        assertEquals(studentNode.getNext(), nullIntegerNode.getNext());
        assertEquals(studentNode.getPrevious(), nullIntegerNode.getPrevious());
        assertEquals(studentNode.getClass(), nullIntegerNode.getClass());
        assertEquals(NullDoublyLinkedNode.class, NullDoublyLinkedNodeMultiton.getInstance(studentClass).getClass());
        assertSame(nullIntegerNode, NullDoublyLinkedNodeMultiton.getInstance(integerClass));
        assertSame(nullIntegerNode, NullDoublyLinkedNodeMultiton.getInstance(integerClass));
        assertSame(nullIntegerNode, NullDoublyLinkedNodeMultiton.getInstance(integerClass));
    }
}