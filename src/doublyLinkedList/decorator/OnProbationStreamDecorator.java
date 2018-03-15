package doublyLinkedList.decorator;

import doublyLinkedList.DoublyLinkedList;
import doublyLinkedList.model.Student;
import doublyLinkedList.util.StreamUtil;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.stream.Stream;

public class OnProbationStreamDecorator extends DoublyLinkedListDecorator<Student> {

    public OnProbationStreamDecorator(DoublyLinkedListComponent<Student> component) {
        super(component);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(DoublyLinkedList.class.getSimpleName()).append(" [");
        Student[] studentArray = generateStudentOnProbationStream().toArray(Student[]::new);
        if (studentArray.length > 0) {
            for (Student student : studentArray) {
                builder.append(student).append(", ");
            }
            builder.replace(builder.length() - 2, builder.length(), "");
        }
        builder.append("]");
        return builder.toString();
    }

    @Override
    public Iterator<Student> iterator() {
        return generateStudentOnProbationStream().iterator();
    }

    @Override
    public Object[] toArray() {
        return generateStudentOnProbationStream().toArray();
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        int numberOfElements = getNumberOfElementsInIterator(iterator());
        if (a.length < numberOfElements) {
            a = (T[]) Array.newInstance(a.getClass().getComponentType(), numberOfElements);
        }

        Iterator<Student> iterator = iterator();
        int i = 0;
        while (iterator.hasNext()) {
            a[i++] = (T) iterator.next();
        }
        return a;
    }

    private Stream<Student> generateStudentOnProbationStream() {
        return StreamUtil.iteratorToStream(getComponent().iterator(), false)
                .filter(student -> student.isOnProbation());
    }

    private int getNumberOfElementsInIterator(Iterator<Student> iterator) {
        int count = 0;
        while (iterator.hasNext()) {
            count++;
            iterator.next();
        }
        return count;
    }
}