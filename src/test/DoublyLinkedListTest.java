package test;

import doublyLinkedList.DoublyLinkedList;
import doublyLinkedList.model.Student;
import doublyLinkedList.strategy.StudentNameLexicographicalOrder;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class DoublyLinkedListTest {

    private List<Student> doublyLinkedList;

    @Before
    public void initialize() {
        doublyLinkedList = new DoublyLinkedList<Student>(new StudentNameLexicographicalOrder());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(doublyLinkedList.isEmpty());
    }

    @Test
    public void testAdd() {
        assertTrue(doublyLinkedList.add(new Student("Francisco", 818593862, 3)));
        assertTrue(doublyLinkedList.add(new Student("Pablo", 818593861, 2)));
        assertTrue(doublyLinkedList.add(new Student("Miriam", 818593863, 4)));
        assertEquals(3, doublyLinkedList.size());
    }

    @Test
    public void testGet() {
        Student student1 = new Student("Pablo", 818593861, 2);
        Student student2 = new Student("Francisco", 818593862, 3);
        Student student3 = new Student("Miriam", 818593863, 4);
        doublyLinkedList.add(student1);
        doublyLinkedList.add(student2);
        doublyLinkedList.add(student3);
        assertEquals(student1, doublyLinkedList.get(2));
        assertEquals(student2, doublyLinkedList.get(0));
        assertEquals(student3, doublyLinkedList.get(1));
    }

    @Test
    public void testIndexOutOfBoundsException() {
        doublyLinkedList.add(new Student("Miriam", 818593863, 4));
        doublyLinkedList.add(new Student("Pablo", 818593861, 2));
        doublyLinkedList.add(new Student("Francisco", 818593862, 3));
        doublyLinkedList.add(new Student("Bia", 818593864, 2.84f));

        try {
            doublyLinkedList.get(4);
        } catch (IndexOutOfBoundsException e) {
            assertEquals("IndexOutOfBoundsException => Index: 4, DoublyLinkedList size: 4",
                    e.getMessage());
        }
    }

    @Test
    public void testToArray() {
        Student student1 = new Student("Francisco", 818593862, 1.8f);
        Student student2 = new Student("Wolf", 818593861, 0.5f);
        Student student3 = new Student("Miriam", 818593863, 4);
        doublyLinkedList.add(student1);
        doublyLinkedList.add(student2);
        doublyLinkedList.add(student3);

        Object[] objectArray = doublyLinkedList.toArray();

        assertNotNull(objectArray);
        assertEquals(3, objectArray.length);
        assertEquals(student1, objectArray[0]);
        assertEquals(student3, objectArray[1]);
        assertEquals(student2, objectArray[2]);
    }

    @Test
    public void testToArrayWithParameteArrayLengthLessThanListSize() {
        Student student1 = new Student("Francisco", 818593862, 1.8f);
        Student student2 = new Student("Wolf", 818593861, 0.5f);
        Student student3 = new Student("Miriam", 818593863, 4);
        doublyLinkedList.add(student1);
        doublyLinkedList.add(student2);
        doublyLinkedList.add(student3);

        Student[] studentArray = new Student[1];
        studentArray = doublyLinkedList.toArray(studentArray);

        assertNotNull(studentArray);
        assertEquals(3, studentArray.length);
        assertEquals(student1, studentArray[0]);
        assertEquals(student3, studentArray[1]);
        assertEquals(student2, studentArray[2]);
    }

    @Test
    public void testToArrayWithParameterArrayLengthEqualToListSize() {
        Student student1 = new Student("Francisco", 818593862, 1.8f);
        Student student2 = new Student("Wolf", 818593861, 0.5f);
        Student student3 = new Student("Miriam", 818593863, 4);
        Student student4 = new Student("Bia", 818593862, 4);
        doublyLinkedList.add(student1);
        doublyLinkedList.add(student2);
        doublyLinkedList.add(student3);
        doublyLinkedList.add(student4);

        Student[] studentArray = new Student[4];
        studentArray = doublyLinkedList.toArray(studentArray);

        assertNotNull(studentArray);
        assertEquals(4, studentArray.length);
        assertEquals(student4, studentArray[0]);
        assertEquals(student1, studentArray[1]);
        assertEquals(student3, studentArray[2]);
        assertEquals(student2, studentArray[3]);
    }

    @Test
    public void testToArrayWithParameterArrayLengthBiggerThanListSize() {
        Student student1 = new Student("Francisco", 818593862, 1.8f);
        Student student2 = new Student("Wolf", 818593861, 0.5f);
        Student student3 = new Student("Miriam", 818593863, 4);
        doublyLinkedList.add(student1);
        doublyLinkedList.add(student2);
        doublyLinkedList.add(student3);

        Student[] studentArray = new Student[5];
        studentArray = doublyLinkedList.toArray(studentArray);

        assertNotNull(studentArray);
        assertEquals(5, studentArray.length);
        assertEquals(student1, studentArray[0]);
        assertEquals(student3, studentArray[1]);
        assertEquals(student2, studentArray[2]);
        assertNull(studentArray[3]);
        assertNull(studentArray[4]);
    }

    @Test
    public void testIterator() {
        doublyLinkedList.add(new Student("Miriam", 818593863, 4));
        doublyLinkedList.add(new Student("Wolf", 818593861, 0.5f));
        doublyLinkedList.add(new Student("Francisco", 818593862, 1.8f));

        Iterator<Student> iterator = doublyLinkedList.iterator();
        assertNotNull(iterator);

        int count = 0;
        while (iterator.hasNext()) {
            count++;
            Student student = iterator.next();
            assertNotNull(student);
        }
        assertEquals(3, count);
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testDoublyLinkedNodeIterator() {
        Student student1 = new Student("Wolf", 818593861, 0.5f);
        Student student2 = new Student("Francisco", 818593862, 1.8f);
        Student student3 = new Student("Miriam", 818593863, 4);
        doublyLinkedList.add(student1);
        doublyLinkedList.add(student2);
        doublyLinkedList.add(student3);

        Iterator<Student> iterator = doublyLinkedList.iterator();
        assertTrue(iterator.hasNext());
        Student student = (Student) iterator.next();
        assertNotNull(student);
        assertEquals(student2, student);

        assertTrue(iterator.hasNext());
        student = (Student) iterator.next();
        assertNotNull(student);
        assertEquals(student3, student);

        assertTrue(iterator.hasNext());
        student = (Student) iterator.next();
        assertNotNull(student);
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
    public void testClear() {
        doublyLinkedList.add(new Student("Miriam", 818593863, 4));
        doublyLinkedList.add(new Student("Pablo", 818593861, 2));
        doublyLinkedList.add(new Student("Francisco", 818593862, 3));
        doublyLinkedList.add(new Student("Bia", 818593864, 2.84f));

        assertFalse(doublyLinkedList.isEmpty());

        doublyLinkedList.clear();
        assertTrue(doublyLinkedList.isEmpty());
    }

    @Test
    public void testToString() {
        assertNotNull(doublyLinkedList.toString());
        Student student1 = new Student("Miriam", 818593861, 0.5f);
        Student student2 = new Student("Solange", 818593862, 1.8f);
        Student student3 = new Student("Bia", 818593863, 4);
        doublyLinkedList.add(student1);
        doublyLinkedList.add(student2);
        doublyLinkedList.add(student3);

        String doublyLinkedListToString = doublyLinkedList.toString();
        assertNotNull(doublyLinkedListToString);
        assertTrue(doublyLinkedListToString.contains(doublyLinkedList.getClass().getSimpleName()));
        assertTrue(doublyLinkedListToString.contains(student1.toString()));
        assertTrue(doublyLinkedListToString.contains(student2.toString()));
        assertTrue(doublyLinkedListToString.contains(student3.toString()));
    }

    @Test
    public void testListIterator() {
        assertNull(doublyLinkedList.listIterator(1));
    }
}