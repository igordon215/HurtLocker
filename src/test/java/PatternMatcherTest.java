import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class PatternMatcherTest {


    @Test
    void testMilkPatterns() {
        assertEquals("Milk", PatternMatcher.findMatchingPattern("Milk"));
        assertEquals("Milk", PatternMatcher.findMatchingPattern("MilK"));
        assertEquals("Milk", PatternMatcher.findMatchingPattern("MiLK"));
    }

    @Test
    void testBreadPatterns() {
        assertEquals("Bread", PatternMatcher.findMatchingPattern("BreaD"));
        assertEquals("Bread", PatternMatcher.findMatchingPattern("BrEAD"));
    }

    @Test
    void testApplesPatterns() {
        assertEquals("Apples", PatternMatcher.findMatchingPattern("Apples"));
        assertEquals("Apples", PatternMatcher.findMatchingPattern("apPles"));
    }

    @Test
    void testCookiesPatterns() {
        assertEquals("Cookies", PatternMatcher.findMatchingPattern("Cookies"));
        assertEquals("Cookies", PatternMatcher.findMatchingPattern("CoOkieS"));
        assertEquals("Cookies", PatternMatcher.findMatchingPattern("COokIes"));
        assertEquals("Cookies", PatternMatcher.findMatchingPattern("COOkieS"));
        assertEquals("Cookies", PatternMatcher.findMatchingPattern("Co0kieS"));
    }


}