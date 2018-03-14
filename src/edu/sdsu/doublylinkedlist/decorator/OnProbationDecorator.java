package edu.sdsu.doublylinkedlist.decorator;

import edu.sdsu.doublylinkedlist.DoublyLinkedList;
import edu.sdsu.doublylinkedlist.filter.DoublyLinkedListFilter;
import edu.sdsu.doublylinkedlist.filter.OnProbationStreamFilter;
import edu.sdsu.doublylinkedlist.model.Student;

import java.lang.reflect.Array;
import java.util.Iterator;

public class OnProbationDecorator extends DoublyLinkedListDecorator<Student> {
    public OnProbationDecorator(DoublyLinkedListComponent<Student> component) {
        super(component);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(DoublyLinkedList.class.getSimpleName()).append(" [");
        Object[] array = this.toArray();
        if (array.length > 0) {
            for (Object obj : array) {
                builder.append((Student) obj).append(", ");
            }
            builder.replace(builder.length() - 2, builder.length(), "");
        }
        builder.append("]");
        return builder.toString();
    }

    @Override
    public Iterator<Student> iterator() {
        return new OnProbationIterator();
    }

    @Override
    public Object[] toArray() {
        OnProbationIterator iterator = (OnProbationIterator) this.iterator();
        int size = iterator.getNumberOfElements();

        Object[] array = new Object[size];
        int i = 0;
        while (iterator.hasNext()) {
            array[i++] = iterator.next();
        }
        return array;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <E> E[] toArray(E[] a) {
        OnProbationIterator iterator = new OnProbationIterator();
        if (a.length < iterator.getNumberOfElements()) {
            a = (E[]) Array.newInstance(a.getClass().getComponentType(), iterator.getNumberOfElements());
        }

        int i = 0;
        while (iterator.hasNext()) {
            a[i++] = (E) iterator.next();
        }
        return a;
    }

    private class OnProbationIterator implements Iterator<Student> {
        private DoublyLinkedListFilter<Student> onProbationFilter =
                new OnProbationStreamFilter(OnProbationDecorator.this.getComponent().iterator());

        @Override
        public boolean hasNext() {
            return onProbationFilter.hasNext();
        }

        @Override
        public Student next() {
            return onProbationFilter.next();
        }

        public int getNumberOfElements() {
            int count = 0;
            OnProbationIterator iterator = new OnProbationIterator();
            while (iterator.hasNext()) {
                count++;
                iterator.next();
            }
            return count;
        }
    }
}