package edu.sdsu.doublylinkedlist.decorator;

public abstract class DoublyLinkedListDecorator<T> implements DoublyLinkedListComponent<T> {
    private DoublyLinkedListComponent<T> component;

    public DoublyLinkedListDecorator(DoublyLinkedListComponent<T> component) {
        this.component = component;
    }

    public DoublyLinkedListComponent<T> getComponent() {
        return component;
    }
}