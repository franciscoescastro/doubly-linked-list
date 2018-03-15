package test;

import doublyLinkedList.DoublyLinkedList;
import doublyLinkedList.model.Student;
import doublyLinkedList.strategy.StudentNameLexicographicalOrder;
import doublyLinkedList.util.Search;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SearchTest {
    private List<Student> doublyLinkedList;

    @Before
    public void initialize() {
        doublyLinkedList = new DoublyLinkedList<Student>(
                new StudentNameLexicographicalOrder());
    }

    @Test
    public void testGetStudentsOnProbation() {
        List<Student> actualList = Search.getStudentsOnProbation(doublyLinkedList);
        assertTrue(actualList.isEmpty());
        Student student1 = new Student("Wolf", 818593861, 0.5f);
        Student student2 = new Student("Miriam", 818593863, 2.3f);
        doublyLinkedList.add(student1);
        doublyLinkedList.add(new Student("Francisco", 818593862, 4));
        doublyLinkedList.add(student2);
        actualList = Search.getStudentsOnProbation(doublyLinkedList);
        assertEquals(2, actualList.size());

        List<Student> expectedList = new ArrayList<Student>();
        expectedList.add(student2);
        expectedList.add(student1);

        for (int i = 0; i < expectedList.size(); i++) {
            assertEquals(expectedList.get(i), actualList.get(i));
        }
    }

    @Test
    public void testGetStudentsGP4() {
        List<Student> actualList = Search.getStudentsGP4(doublyLinkedList);
        assertTrue(actualList.isEmpty());

        Student student1 = new Student("Miriam", 818593863, 4);
        Student student2 = new Student("Wolf", 818593861, 4);
        doublyLinkedList.add(new Student("Francisco", 818593862, 3));
        doublyLinkedList.add(student1);
        doublyLinkedList.add(student2);
        actualList = Search.getStudentsGP4(doublyLinkedList);

        assertEquals(2, actualList.size());

        List<Student> expectedList = new ArrayList<Student>();
        expectedList.add(student2);
        expectedList.add(student1);
        for (int i = 0; i < expectedList.size(); i++) {
            assertEquals(expectedList.get(i), actualList.get(i));
        }
    }
}