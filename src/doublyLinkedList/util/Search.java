package doublyLinkedList.util;

import doublyLinkedList.DoublyLinkedList;
import doublyLinkedList.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Search {

    public static List<Student> getStudentsOnProbation(List<Student> doublyLinkedList) {
        return doublyLinkedList.stream()
                .filter(student -> student.isOnProbation())
                .collect(Collectors.toList());
    }

    public static List<Student> getStudentsGP4(List<Student> doublyLinkedList) {
        List<Student> studentList = new ArrayList<Student>();
        doublyLinkedList.stream().filter(student -> student.hasGPA4())
                .collect(Collectors.toCollection(DoublyLinkedList<Student>::new))
                .descendingIterator()
                .forEachRemaining(student -> studentList.add(student));
        return studentList;
    }
}
