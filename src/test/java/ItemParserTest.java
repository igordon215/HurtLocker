import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Map;

public class ItemParserTest {
    @Test
    public void testParseItem() {
        ExceptionCounter counter = new ExceptionCounter();
        ItemParser parser = new ItemParser(counter);
        String item = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016";
        Map<String, String> result = parser.parseItem(item);

        assertEquals("Milk", result.get("name"));
        assertEquals("3.23", result.get("price"));
        assertEquals("Food", result.get("type"));
        assertEquals("1/25/2016", result.get("expiration"));
        assertEquals(0, counter.getExceptionCount());
    }

    @Test
    public void parseItemWithEmptyString() {
        ExceptionCounter counter = new ExceptionCounter();
        ItemParser parser = new ItemParser(counter);
        String item = "";
        Map<String, String> result = parser.parseItem(item);

        assertTrue(result.isEmpty());
        assertEquals(0, counter.getExceptionCount());
    }


    @Test
    public void parseItemWithSpecialCharactersInValue() {
        ExceptionCounter counter = new ExceptionCounter();
        ItemParser parser = new ItemParser(counter);
        String item = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016;description:Fresh@Milk!";
        Map<String, String> result = parser.parseItem(item);

        assertEquals("Milk", result.get("name"));
        assertEquals("3.23", result.get("price"));
        assertEquals("Food", result.get("type"));
        assertEquals("1/25/2016", result.get("expiration"));
        assertEquals("Fresh@Milk!", result.get("description"));
        assertEquals(0, counter.getExceptionCount());
    }

}