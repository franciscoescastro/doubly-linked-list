package edu.sdsu.doublylinkedlist.decorator;

public interface DoublyLinkedListComponent<T> extends Iterable<T> {
    public String toString();

    public Object[] toArray();

    public <E> E[] toArray(E[] a);
}