package day0;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Iterator;

import org.junit.jupiter.api.Test;

public class TestCount {

    @Test
    public void testEmptyCounter() {
        Counter<String> counter = new Counter<>();
        assertEquals(0, counter.getCount("apple"), "Count for 'apple' should be 0.");
    }

    @Test
    public void testAddToCount() {
        Counter<String> counter = new Counter<>();
        counter.addToCount("apple");
        assertEquals(1, counter.getCount("apple"), "Count for 'apple' should be 1.");
    }

    @Test
    public void testAddToCountMultiple() {
        Counter<String> counter = new Counter<>();
        counter.addToCount("apple");
        counter.addToCount("apple");
        assertEquals(2, counter.getCount("apple"), "Count for 'apple' should be 2.");
    }

    @Test
    public void testConstructorWithIterable() {
        Counter<String> counter = new Counter<>(Arrays.asList("apple", "banana", "apple"));
        assertEquals(2, counter.getCount("apple"), "Count for 'apple' should be 2.");
        assertEquals(1, counter.getCount("banana"), "Count for 'banana' should be 1.");
    }

    @Test
    public void testIterator() {

        Iterator<String> iterator = counter.iterator();

        assertEquals("apple", iterator.next(), "Iterator should return 'apple' first.");

        assertEquals("banana", iterator.next(), "Iterator should return 'banana' next.");

        assertEquals("apple", iterator.next(), "Iterator should return 'apple' again.");

        assertFalse(iterator.hasNext(), "Iterator should not have more elements.");
    }
}
