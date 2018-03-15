package doublyLinkedList.node;

public class NullDoublyLinkedNode<T> extends DoublyLinkedNode<T> {

    @Override
    public T getValue() {
        return null;
    }

    @Override
    public DoublyLinkedNode<T> getPrevious() {
        return null;
    }

    @Override
    public DoublyLinkedNode<T> getNext() {
        return null;
    }

    @Override
    public void addBefore(DoublyLinkedNode<T> previous) {
    }

    @Override
    public void addAfter(DoublyLinkedNode<T> next) {
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }
}