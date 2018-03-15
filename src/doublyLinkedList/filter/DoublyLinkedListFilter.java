package doublyLinkedList.filter;

public interface DoublyLinkedListFilter<T> {
    public boolean hasNext();

    public T next();
}