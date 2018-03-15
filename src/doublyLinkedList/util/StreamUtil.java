package doublyLinkedList.util;

import java.util.Iterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class StreamUtil {

    public static <T> Stream<T> iteratorToStream(Iterator<T> iterator, boolean parallel) {
        Iterable<T> iterable = () -> iterator;
        Stream<T> stream = StreamSupport.stream(iterable.spliterator(), parallel);
        return stream;
    }
}