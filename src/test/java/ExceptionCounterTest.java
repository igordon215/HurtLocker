import org.junit.Test;

import static org.junit.Assert.*;

public class ExceptionCounterTest {
    @Test
    public void testExceptionCounter() {
        ExceptionCounter counter = new ExceptionCounter();
        assertEquals(0, counter.getExceptionCount());
        counter.incrementExceptionCount();
        assertEquals(1, counter.getExceptionCount());
        counter.incrementExceptionCount();
        assertEquals(2, counter.getExceptionCount());
    }
}