package edu.sdsu.doublylinkedlist.strategy;

import edu.sdsu.doublylinkedlist.model.Student;
import edu.sdsu.doublylinkedlist.node.DoublyLinkedNode;
import edu.sdsu.doublylinkedlist.node.NullDoublyLinkedNode;

public class StudentNameLexicographicalOrder implements Order<Student> {

    @Override
    public DoublyLinkedNode<Student> allocate(DoublyLinkedNode<Student> first, Student student) {
        DoublyLinkedNode<Student> previous = new NullDoublyLinkedNode<Student>();
        DoublyLinkedNode<Student> current = first;

        while (isInLexicographicalOrder(current.getValue(), student)) {
            previous = current;
            current = current.getNext();
        }
        return new DoublyLinkedNode<Student>(student, previous, current);
    }

    private boolean isInLexicographicalOrder(Student student1, Student student2) {
        return student1 != null
                && student2 != null
                && student1.getName().compareToIgnoreCase(student2.getName()) < 0;
    }
}