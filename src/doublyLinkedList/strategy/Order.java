package doublyLinkedList.strategy;

import doublyLinkedList.node.DoublyLinkedNode;

public interface Order<T> {
    public DoublyLinkedNode<T> allocate(DoublyLinkedNode<T> first, T t);
}