package edu.sdsu.doublylinkedlist.filter;

public interface DoublyLinkedListFilter<T> {
    public boolean hasNext();

    public T next();
}