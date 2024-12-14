package day2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class D2question2Test {

    // Test for mulMatcher method
    @Test
    public void testMulMatcherValid() {
        assertTrue(D2question2.mulMatcher("ul(123,456)"));
        assertTrue(D2question2.mulMatcher("ul(0,0)"));
        assertTrue(D2question2.mulMatcher("ul(999,999)"));
    }

    @Test
    public void testMulMatcherInvalid() {
        assertFalse(D2question2.mulMatcher("mul(123)"));
        assertFalse(D2question2.mulMatcher("mul(123, 456)"));
        assertFalse(D2question2.mulMatcher("ul(123, abc)"));
        assertFalse(D2question2.mulMatcher("mul()"));
        assertFalse(D2question2.mulMatcher("ul(, )"));
    }

    // Test for doMatcher method
    @Test
    public void testDoMatcherValid() {
        assertTrue(D2question2.doMatcher("o()"));
        assertTrue(D2question2.doMatcher("o()somethingAfter"));
    }

    @Test
    public void testDoMatcherInvalid() {
        assertFalse(D2question2.doMatcher("oo()"));
        assertFalse(D2question2.doMatcher("o(12) things"));
        assertFalse(D2question2.doMatcher("some string"));
    }

    // Test for dontMatcher method
    @Test
    public void testDontMatcherValid() {
        assertTrue(D2question2.dontMatcher("on't()"));
        assertTrue(D2question2.dontMatcher("on't()afterStuff"));
    }

    @Test
    public void testDontMatcherInvalid() {
        assertFalse(D2question2.dontMatcher("on't123()"));
        assertFalse(D2question2.dontMatcher("dont()"));
        assertFalse(D2question2.dontMatcher("on't abc"));
    }

    // Test for doMul method
    @Test
    public void testDoMulValid() {
        assertEquals(6, D2question2.doMul("ul(2,3)"));
        assertEquals(500, D2question2.doMul("ul(5,100)"));
        assertEquals(100, D2question2.doMul("ul(10,10)"));
        assertEquals(124, D2question2.doMul("ul(1,124)"));
    }

    @Test
    public void testDoMulInvalid() {
        // Testing cases where an invalid format should throw IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> D2question2.doMul("ul(12,)"));
        assertThrows(IllegalArgumentException.class, () -> D2question2.doMul("ul(,12)"));
        assertThrows(IllegalArgumentException.class, () -> D2question2.doMul("ul(abc,123)"));
    }
}
