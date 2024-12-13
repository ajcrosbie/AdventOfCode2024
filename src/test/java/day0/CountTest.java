package day0;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.Arrays;


import org.junit.jupiter.api.Test;

public class CountTest {

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
}
