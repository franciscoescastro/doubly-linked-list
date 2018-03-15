package test;

import doublyLinkedList.DoublyLinkedList;
import doublyLinkedList.filter.DoublyLinkedListFilter;
import doublyLinkedList.filter.OnProbationFilter;
import doublyLinkedList.filter.OnProbationStreamFilter;
import doublyLinkedList.model.Student;
import doublyLinkedList.strategy.StudentNameLexicographicalOrder;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class OnProbationStreamFilterTest {
    private DoublyLinkedList<Student> doublyLinkedList;

    @Before
    public void initialize() {
        doublyLinkedList = new DoublyLinkedList<Student>(
                new StudentNameLexicographicalOrder());
    }

    @Test
    public void testHasNext() {
        DoublyLinkedListFilter<Student> onProbationFilter = new OnProbationStreamFilter(doublyLinkedList.iterator());
        assertFalse(onProbationFilter.hasNext());
        doublyLinkedList.add(new Student("Solange", 818593862, 2.86f));
        doublyLinkedList.add(new Student("Leo", 818593861, 1.5f));
        doublyLinkedList.add(new Student("John Marcos", 818593860, 3));
        doublyLinkedList.add(new Student("Anastacio", 818593862, 1.75f));
        onProbationFilter = new OnProbationFilter(doublyLinkedList.iterator());
        for (int i = 0; i < 2; i++) {
            assertTrue(onProbationFilter.hasNext());
            onProbationFilter.next();
        }
        assertFalse(onProbationFilter.hasNext());
    }

    @Test
    public void testNext() {
        Student student1 = new Student("Anastacio", 818593862, 1.75f);
        Student student2 = new Student("Leo", 818593861, 1.5f);
        Student student3 = new Student("John Marcos", 818593860, 2);
        doublyLinkedList.add(new Student("Solange", 818593862, 2.86f));
        doublyLinkedList.add(student1);
        doublyLinkedList.add(student2);
        doublyLinkedList.add(student3);

        DoublyLinkedListFilter<Student> onProbationFilter = new OnProbationStreamFilter(doublyLinkedList.iterator());
        assertTrue(onProbationFilter.hasNext());

        Student student = onProbationFilter.next();
        assertNotNull(student);
        assertTrue(student.isOnProbation());
        assertEquals(student1, student);
        assertTrue(onProbationFilter.hasNext());

        student = onProbationFilter.next();
        assertNotNull(student);
        assertTrue(student.isOnProbation());
        assertEquals(student3, student);
        assertTrue(onProbationFilter.hasNext());

        student = onProbationFilter.next();
        assertNotNull(student);
        assertTrue(student.isOnProbation());
        assertEquals(student2, student);
        assertFalse(onProbationFilter.hasNext());

        try {
            onProbationFilter.next();
        } catch (Exception e) {
            NoSuchElementException noSuchElementException = new NoSuchElementException();
            assertEquals(noSuchElementException.getMessage(), e.getMessage());
        }
    }
}