package doublyLinkedList.filter;

import doublyLinkedList.model.Student;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class OnProbationFilter implements DoublyLinkedListFilter<Student> {
    private Iterator<Student> iterator;
    private Student student = null;

    public OnProbationFilter(Iterator<Student> iterator) {
        this.iterator = iterator;
    }

    @Override
    public boolean hasNext() {
        if (this.student != null)
            return true;

        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.isOnProbation()) {
                this.student = student;
                break;
            }
        }
        return this.student != null;
    }

    @Override
    public Student next() {
        if (!hasNext())
            throw new NoSuchElementException();

        Student student = this.student;
        this.student = null;
        return student;
    }
}