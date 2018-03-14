package edu.sdsu.doublylinkedlist.strategy;

import edu.sdsu.doublylinkedlist.node.DoublyLinkedNode;

public interface Order<T> {
    public DoublyLinkedNode<T> allocate(DoublyLinkedNode<T> first, T t);
}