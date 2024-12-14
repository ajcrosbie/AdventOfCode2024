package day1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class D1question2Test {

    @Test
    public void testRemoveIndex_ValidIndex() {
        int[] input = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 4, 5}; // After removing index 2 (value 3)

        assertArrayEquals(expected, D1question2.removeIndex(input, 2));
    }

    @Test
    public void testRemoveIndex_RemoveFirst() {
        int[] input = {1, 2, 3, 4, 5};
        int[] expected = {2, 3, 4, 5}; // After removing index 0 (value 1)

        assertArrayEquals(expected, D1question2.removeIndex(input, 0));
    }

    @Test
    public void testRemoveIndex_RemoveLast() {
        int[] input = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4}; // After removing last index 4 (value 5)

        assertArrayEquals(expected, D1question2.removeIndex(input, 4));
    }

    @Test
    public void testCheckWithout_NoElementRemoved() {
        int[] input = {1, 2, 3, 4, 5};
        assertEquals(-1, D1question2.checkWithout(input, -1)); // Fully increasing sequence
    }

    @Test
    public void testCheckWithout_RemoveBreakingElement() {
        int[] input = {1, 2, 6, 4, 5}; // Removing 6 fixes the sequence
        assertEquals(2, D1question2.checkWithout(input, -1)); // Breaking index is 2
    }

    @Test
    public void testCheckWithout_AlreadyValid() {
        int[] input = {5, 3, 1}; // Fully decreasing sequence
        assertEquals(-1, D1question2.checkWithout(input, -1)); // No index needs removal
    }

    @Test
    public void testCheckWithout_RemoveOutOfBoundsElement() {
        int[] input = {1, 2, 6, 4, 5}; // Removing 6 fixes the sequence
        assertEquals(-1, D1question2.checkWithout(input, 2)); // Simulate removal of index 2
    }

    @Test
    public void testCheckWithout_MixedEdgeCases() {
        int[] input1 = {1, 2, 10, 4, 5}; // Two elements break the sequence
        assertEquals(2, D1question2.checkWithout(input1, -1)); // Index 2 is breaking

        int[] input2 = {10, 7, 4, 3, 8}; // Element 8 at the end breaks the sequence
        assertEquals(4, D1question2.checkWithout(input2, -1)); // Index 4 is breaking
    }
}
