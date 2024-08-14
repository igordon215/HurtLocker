import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class PatternMatcherTest {

    @Test
    void testMilkPatterns() {
        assertEquals("Milk", PatternMatcher.findMatchingPattern("Milk"));
        assertEquals("Milk", PatternMatcher.findMatchingPattern("MilK"));
        assertEquals("Milk", PatternMatcher.findMatchingPattern("MiLK"));
    }




  
}