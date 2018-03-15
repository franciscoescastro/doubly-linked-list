package doublyLinkedList.strategy;

import doublyLinkedList.node.DoublyLinkedNode;
import doublyLinkedList.node.NullDoublyLinkedNode;

public class LinkedOrder<T> implements Order<T> {
    @Override
    public DoublyLinkedNode<T> allocate(DoublyLinkedNode<T> first, T t) {
        DoublyLinkedNode<T> previous = new NullDoublyLinkedNode<T>();
        DoublyLinkedNode<T> current = first;

        while (current.getValue() != null) {
            previous = current;
            current = current.getNext();
        }
        return new DoublyLinkedNode<T>(t, previous, current);
    }
}