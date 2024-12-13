package day0;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListFromFileTest {

    private final String validFileName = "testFile.txt";
    private final String invalidFileName = "nonExistentFile.txt";

    @BeforeEach
    void setUp() throws IOException {
        // Create a temporary test file
        File file = new File(validFileName);
        try (FileWriter writer = new FileWriter(file)) {
            writer.write("1\n2\n3\n4\n5\n");
        }
    }

    @Test
    void testReadAllLines() {
        ArrayListFromFile<Integer> arrayListFromFile = new ArrayListFromFile<>(
                validFileName,
                Integer::parseInt
        );

        Iterator<Integer> iterator = arrayListFromFile.iterator();
        ArrayList<Integer> result = new ArrayList<>();
        iterator.forEachRemaining(result::add);

        // Verify the contents
        assertEquals(5, result.size());
        assertEquals(1, result.get(0));
        assertEquals(5, result.get(4));
    }

    @Test
    void testEmptyFile() throws IOException {
        // Create an empty test file
        String emptyFileName = "emptyFile.txt";
        File emptyFile = new File(emptyFileName);
        emptyFile.createNewFile();

        ArrayListFromFile<Integer> arrayListFromFile = new ArrayListFromFile<>(
                emptyFileName,
                Integer::parseInt
        );

        Iterator<Integer> iterator = arrayListFromFile.iterator();
        assertFalse(iterator.hasNext(), "Iterator should be empty for an empty file");

        // Clean up
        emptyFile.delete();
    }


    @Test
    void testCustomGenerator() {
        ArrayListFromFile<String> arrayListFromFile = new ArrayListFromFile<>(
                validFileName,
                line -> "Line: " + line
        );

        Iterator<String> iterator = arrayListFromFile.iterator();
        ArrayList<String> result = new ArrayList<>();
        iterator.forEachRemaining(result::add);

        // Verify the contents
        assertEquals(5, result.size());
        assertEquals("Line: 1", result.get(0));
        assertEquals("Line: 5", result.get(4));
    }

    @Test
    void testAllRead() {
        ArrayListFromFile<Integer> arrayListFromFile = new ArrayListFromFile<>(
                validFileName,
                Integer::parseInt
        );

        assertTrue(arrayListFromFile.notDone(), "should not be done before starting");
    }
}
