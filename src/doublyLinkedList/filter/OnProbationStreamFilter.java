package doublyLinkedList.filter;

import doublyLinkedList.model.Student;
import doublyLinkedList.util.StreamUtil;

import java.util.Iterator;

public class OnProbationStreamFilter implements DoublyLinkedListFilter<Student> {
    private Iterator<Student> iterator;

    public OnProbationStreamFilter(Iterator<Student> iterator) {
        this.iterator = generateOnProbationIterator(iterator);
    }

    private Iterator<Student> generateOnProbationIterator(Iterator<Student> iterator) {
        return StreamUtil.iteratorToStream(iterator, false)
                .filter(student -> student.isOnProbation()).iterator();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Student next() {
        return iterator.next();
    }
}