package edu.sdsu.doublylinkedlist;


import edu.sdsu.doublylinkedlist.decorator.DoublyLinkedListComponent;
import edu.sdsu.doublylinkedlist.node.DoublyLinkedNode;
import edu.sdsu.doublylinkedlist.node.NullDoublyLinkedNodeMultiton;
import edu.sdsu.doublylinkedlist.strategy.LinkedOrder;
import edu.sdsu.doublylinkedlist.strategy.Order;

import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.util.*;
import java.util.function.Supplier;


public class DoublyLinkedList<T> extends AbstractSequentialList<T> implements List<T>,
        DoublyLinkedListComponent<T>, Supplier<DoublyLinkedList<T>> {
    private int size;
    private DoublyLinkedNode<T> first;
    private DoublyLinkedNode<T> last;
    private Order<T> order;
    private final Class<T> classT;

    public DoublyLinkedList() {
        this(new LinkedOrder<T>());
    }

    public DoublyLinkedList(Order<T> order) {
        classT = getGenericClassT();
        this.order = order;
        first = NullDoublyLinkedNodeMultiton.getInstance(classT);
        last = NullDoublyLinkedNodeMultiton.getInstance(classT);
    }

    @SuppressWarnings("unchecked")
    private Class<T> getGenericClassT() {
        return (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0].getClass();
    }

    @Override
    public boolean add(T t) {
        DoublyLinkedNode<T> newNode = order.allocate(first, t);
        if (!newNode.hasPrevious()) {
            first = newNode;
        }
        if (!newNode.hasNext()) {
            last = newNode;
        }
        size++;
        return true;
    }

    @Override
    public T get(int index) {
        checkIndexOutOfBounds(index);
        return getElement(index);
    }

    private void checkIndexOutOfBounds(int index)
            throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    "IndexOutOfBoundsException => Index: " + index
                            + ", DoublyLinkedList size: " + size);
        }
    }

    private T getElement(int index) {
        T t = null;
        for (T current : this) {
            if (index-- == 0) {
                t = current;
                break;
            }
        }
        return t;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object[] toArray() {
        return this.stream().toArray();
    }

    @Override
    @SuppressWarnings("unchecked")
    public <E> E[] toArray(E[] a) {
        if (a.length < size) {
            a = (E[]) Array.newInstance(a.getClass().getComponentType(), size);
        }
        int i = 0;
        Iterator<T> iterator = iterator();
        while (iterator.hasNext()) {
            a[i++] = (E) iterator.next();
        }
        return a;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getClass().getSimpleName()).append(" [");
        if (!isEmpty()) {
            for (T t : this) {
                builder.append(t).append(", ");
            }
            builder.replace(builder.length() - 2, builder.length(), "");
        }
        builder.append("]");
        return builder.toString();
    }

    @Override
    public void clear() {
        first = NullDoublyLinkedNodeMultiton.getInstance(classT);
        last = NullDoublyLinkedNodeMultiton.getInstance(classT);
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new DoublyLinkedNodeIterator();
    }

    private class DoublyLinkedNodeIterator implements Iterator<T> {
        private int cursor = 0;
        private DoublyLinkedNode<T> node = DoublyLinkedList.this.first;

        @Override
        public boolean hasNext() {
            return cursor < DoublyLinkedList.this.size;
        }

        @Override
        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();
            T t = (T) node.getValue();
            node = node.getNext();
            cursor++;
            return t;
        }
    }

    public Iterator<T> descendingIterator() {
        return new DoublyLinkedNodeDescendingIterator();
    }

    private class DoublyLinkedNodeDescendingIterator implements Iterator<T> {
        private int count = size;
        private DoublyLinkedNode<T> node = DoublyLinkedList.this.last;

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public T next() {
            T t = (T) node.getValue();
            node = node.getPrevious();
            count--;
            return t;
        }
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public DoublyLinkedList<T> get() {
        return new DoublyLinkedList<T>(order);
    }
}