package edu.sdsu.doublylinkedlist.node;

import java.util.HashMap;
import java.util.Map;

public class NullDoublyLinkedNodeMultiton {
    private static Map<Class<?>, Object> map = new HashMap<Class<?>, Object>();

    private NullDoublyLinkedNodeMultiton() {
    }

    @SuppressWarnings("unchecked")
    public static <T> NullDoublyLinkedNode<T> getInstance(Class<T> clazz) {
        if (!map.containsKey(clazz)) {
            map.put(clazz, new NullDoublyLinkedNode<T>());
        }
        return (NullDoublyLinkedNode<T>) map.get(clazz);
    }
}