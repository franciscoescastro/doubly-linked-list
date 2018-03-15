package test;

import doublyLinkedList.model.Student;
import org.junit.Test;

import java.security.InvalidParameterException;

import static org.junit.Assert.*;

public class StudentTest {
    @Test
    public void testSetName() {
        Student student = new Student();
        String name = null;
        try {
            student.setName(name);
        } catch (Exception e) {
            assertEquals(new InvalidParameterException().getMessage(), e.getMessage());
        }

        name = "";
        try {
            student.setName(name);
        } catch (Exception e) {
            assertEquals(new InvalidParameterException().getMessage(), e.getMessage());
        }
    }

    @Test
    public void testSetRedId() {
        Student student = new Student();
        int redId = 0;

        Exception actualException = null;
        try {
            student.setRedId(redId);
        } catch (Exception e) {
            actualException = e;
        }
        assertNotNull(actualException);
        assertEquals(new InvalidParameterException().getMessage(), actualException.getMessage());

        actualException = null;
        redId = -10;
        try {
            student.setRedId(redId);
        } catch (Exception e) {
            actualException = e;
        }
        assertNotNull(actualException);
        assertEquals(new InvalidParameterException().getMessage(), actualException.getMessage());
    }

    @Test
    public void testSetGpa() {
        Student student = new Student();
        float gpa = -1;

        Exception actualException = null;
        try {
            student.setGpa(gpa);
        } catch (Exception e) {
            actualException = e;
        }

        assertNotNull(actualException);
        assertEquals(new InvalidParameterException().getMessage(), actualException.getMessage());

        actualException = null;
        gpa = 0;
        try {
            student.setGpa(gpa);
        } catch (Exception e) {
            actualException = e;
        }

        assertNull(actualException);
    }

    @Test
    public void testIsOnProbation() {
        String name = "Francisco";
        int redId = 818593861;
        float gpa = 2.0f;

        Student student = new Student(name, redId, gpa);
        assertTrue(student.isOnProbation());

        student.setGpa(2.849f);
        assertTrue(student.isOnProbation());

        student.setGpa(2.85f);
        assertFalse(student.isOnProbation());
    }

    @Test
    public void testHasGPA4() {
        String name = "Francisco";
        int redId = 818593861;
        float gpa = 4.0f;

        Student student = new Student(name, redId, gpa);
        assertTrue(student.hasGPA4());

        student.setGpa(3.99f);
        assertFalse(student.hasGPA4());
    }

    @Test
    public void testEqualsObject() {
        Student student1 = new Student("Francisco", 818593861, 2.0f);
        Student student2 = new Student("Francisco", 818593862, 3.0f);
        Student student3 = new Student("Francisco", 818593861, 2.0f);

        assertNotEquals(student1, student2);
        assertNotEquals(student2, student3);
        assertEquals(student1, student3);
    }

    @Test
    public void testToString() {
        String name = "Francisco";
        int redId = 818593861;
        float gpa = 4.0f;

        Student student = new Student(name, redId, gpa);
        assertTrue(student.toString().contains(name));
        assertTrue(student.toString().contains(String.valueOf(redId)));
        assertTrue(student.toString().contains(String.valueOf(gpa)));
    }
}