package test;

import doublyLinkedList.util.StreamUtil;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class StreamUtilTest {
    @Test
    public void testIteratorToStream() {
        List<String> expectedStringList = Arrays.asList("A", "B", "C",
                "Francisco");

        Stream<String> stream = StreamUtil.iteratorToStream(expectedStringList.iterator(), false);
        assertNotNull(stream);

        Iterator<String> expectedIterator = expectedStringList.iterator();
        Iterator<String> streamIterator = stream.iterator();

        while (streamIterator.hasNext()) {
            assertEquals(expectedIterator.next(), streamIterator.next());
        }

        stream = StreamUtil.iteratorToStream(expectedStringList.iterator(), false);

        List<String> streamStringList = stream.collect(Collectors.toList());
        for (int i = 0; i < streamStringList.size(); i++) {
            assertEquals(expectedStringList.get(i), streamStringList.get(i));
        }
    }
}
