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

}