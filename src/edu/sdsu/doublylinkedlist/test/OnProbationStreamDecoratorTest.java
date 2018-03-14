package edu.sdsu.doublylinkedlist.test;

import edu.sdsu.doublylinkedlist.DoublyLinkedList;
import edu.sdsu.doublylinkedlist.decorator.DoublyLinkedListDecorator;
import edu.sdsu.doublylinkedlist.decorator.OnProbationStreamDecorator;
import edu.sdsu.doublylinkedlist.model.Student;
import edu.sdsu.doublylinkedlist.strategy.StudentNameLexicographicalOrder;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class OnProbationStreamDecoratorTest {
    private DoublyLinkedList<Student> doublyLinkedList;
    private DoublyLinkedListDecorator<Student> onProbationDecorator;

    @Before
    public void initialize() {
        doublyLinkedList = new DoublyLinkedList<Student>(new StudentNameLexicographicalOrder());
        onProbationDecorator = new OnProbationStreamDecorator(doublyLinkedList);
    }

    @Test
    public void testToString() {
        assertNotNull(onProbationDecorator.toString());
        Student student1 = new Student("Miriam", 818593861, 0.5f);
        Student student2 = new Student("Bia", 818593863, 4);
        Student student3 = new Student("Solange", 818593862, 1.8f);
        doublyLinkedList.add(student1);
        doublyLinkedList.add(student2);
        doublyLinkedList.add(student3);

        String onProbationDecoratorListToString = onProbationDecorator.toString();
        assertNotNull(onProbationDecoratorListToString);

        assertTrue(onProbationDecoratorListToString.contains(doublyLinkedList.getClass().getSimpleName()));
        assertTrue(onProbationDecoratorListToString.contains(student1.toString()));
        assertTrue(onProbationDecoratorListToString.contains(student3.toString()));
        assertFalse(onProbationDecoratorListToString.contains(student2.toString()));
    }

    @Test
    public void testToArray() {
        assertEquals(0, onProbationDecorator.toArray().length);

        doublyLinkedList.add(new Student("Miriam", 818593863, 4));
        Student student1 = new Student("Wolf", 818593861, 0.5f);
        Student student2 = new Student("Francisco", 818593862, 1.8f);
        doublyLinkedList.add(student1);
        doublyLinkedList.add(student2);
        doublyLinkedList.add(new Student("Karla", 818593824, 3));

        Object[] objectArray = onProbationDecorator.toArray();

        assertNotNull(objectArray);
        assertEquals(2, objectArray.length);
        assertEquals(student2, objectArray[0]);
        assertEquals(student1, objectArray[1]);
    }

    @Test
    public void testToArrayWithParameteArrayLengthLessThanListProbationSize() {
        Student student1 = new Student("Francisco", 818593862, 1.8f);
        Student student2 = new Student("Wolf", 818593861, 0.5f);
        Student student3 = new Student("Miriam", 818593863, 4);
        doublyLinkedList.add(student1);
        doublyLinkedList.add(student2);
        doublyLinkedList.add(student3);

        Student[] studentArray = new Student[1];
        studentArray = onProbationDecorator.toArray(studentArray);

        assertNotNull(studentArray);
        assertEquals(2, studentArray.length);
        assertEquals(student1, studentArray[0]);
        assertEquals(student2, studentArray[1]);
    }

    @Test
    public void testToArrayWithParameterArrayLengthEqualToListProbationSize() {
        Student student1 = new Student("Miriam", 818593863, 4);
        Student student2 = new Student("Wolf", 818593861, 0.5f);
        Student student3 = new Student("Francisco", 818593862, 1.8f);
        Student student4 = new Student("Bia", 818593862, 2);
        doublyLinkedList.add(student1);
        doublyLinkedList.add(student2);
        doublyLinkedList.add(student3);
        doublyLinkedList.add(student4);

        Student[] studentArray = new Student[2];
        studentArray = onProbationDecorator.toArray(studentArray);

        assertNotNull(studentArray);
        assertEquals(3, studentArray.length);
        assertEquals(student4, studentArray[0]);
        assertEquals(student3, studentArray[1]);
        assertEquals(student2, studentArray[2]);
    }

    @Test
    public void testToArrayWithParameterArrayLengthBiggerThanListProbationSize() {
        Student student1 = new Student("Wolf", 818593861, 0.5f);
        Student student2 = new Student("Francisco", 818593862, 1.8f);
        Student student3 = new Student("Miriam", 818593863, 4);
        doublyLinkedList.add(student1);
        doublyLinkedList.add(student2);
        doublyLinkedList.add(student3);

        Student[] studentArray = new Student[4];
        studentArray = onProbationDecorator.toArray(studentArray);

        assertNotNull(studentArray);
        assertEquals(4, studentArray.length);
        assertEquals(student2, studentArray[0]);
        assertEquals(student1, studentArray[1]);
        assertNull(studentArray[2]);
        assertNull(studentArray[3]);
    }

    @Test
    public void testOnProbationIterator() {
        doublyLinkedList.add(new Student("Miriam", 818593863, 4));
        Student student1 = new Student("Wolf", 818593861, 0.5f);
        Student student2 = new Student("Francisco", 818593862, 1.8f);
        doublyLinkedList.add(student1);
        doublyLinkedList.add(student2);

        Iterator<Student> iterator = onProbationDecorator.iterator();
        assertTrue(iterator.hasNext());
        Student student = iterator.next();
        assertNotNull(student);
        assertTrue(student.isOnProbation());
        assertEquals(student2, student);

        assertTrue(iterator.hasNext());
        student = iterator.next();
        assertNotNull(student);
        assertTrue(student.isOnProbation());
        assertEquals(student1, student);

        assertFalse(iterator.hasNext());
        try {
            iterator.next();
        } catch (Exception e) {
            NoSuchElementException nee = new NoSuchElementException();
            assertEquals(nee.getMessage(), e.getMessage());
        }
    }

    @Test
    public void testIterator() {
        doublyLinkedList.add(new Student("Miriam", 818593863, 4));
        Student student1 = new Student("Wolf", 818593861, 0.5f);
        Student student2 = new Student("Francisco", 818593862, 1.8f);
        doublyLinkedList.add(student1);
        doublyLinkedList.add(student2);

        Iterator<Student> iterator = onProbationDecorator.iterator();
        assertNotNull(iterator);

        int count = 0;
        while (iterator.hasNext()) {
            count++;
            Student student = iterator.next();
            assertNotNull(student);
            assertTrue(student.isOnProbation());
        }
        assertEquals(2, count);
    }
}