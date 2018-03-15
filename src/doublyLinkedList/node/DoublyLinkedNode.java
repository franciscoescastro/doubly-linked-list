package doublyLinkedList.node;

public class DoublyLinkedNode<T> {
    private T value;
    private DoublyLinkedNode<T> previous;
    private DoublyLinkedNode<T> next;

    protected DoublyLinkedNode() {
        value = null;
        previous = null;
        next = null;
    }

    @SuppressWarnings("unchecked")
    public DoublyLinkedNode(T value) {
        this.value = value;
        previous = NullDoublyLinkedNodeMultiton.getInstance((Class<T>) this.value.getClass());
        next = NullDoublyLinkedNodeMultiton.getInstance((Class<T>) this.value.getClass());
    }

    public T getValue() {
        return value;
    }

    public DoublyLinkedNode(T value, DoublyLinkedNode<T> previous, DoublyLinkedNode<T> next) {
        this.value = value;
        addBefore(previous);
        addAfter(next);
    }

    public DoublyLinkedNode<T> getPrevious() {
        return previous;
    }

    public void addBefore(DoublyLinkedNode<T> previous) {
        previous.next = this;
        this.previous = previous;
    }

    public DoublyLinkedNode<T> getNext() {
        return next;
    }

    public void addAfter(DoublyLinkedNode<T> next) {
        next.previous = this;
        this.next = next;
    }

    public boolean hasNext() {
        return this.next.getValue() != null;
    }

    public boolean hasPrevious() {
        return this.previous.getValue() != null;
    }
}