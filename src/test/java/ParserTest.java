import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ParserTest {
    @Test
    public void formatItemWithEmptyMap() {
        ItemFormatter formatter = new ItemFormatter();
        Map<String, String> item = new HashMap<>();
        String result = formatter.formatItem(item);

        assertTrue(result.isEmpty());
    }

    @Test
    public void formatItemWithNullValues() {
        ItemFormatter formatter = new ItemFormatter();
        Map<String, String> item = new HashMap<>();
        item.put("name", null);
        item.put("price", null);
        String result = formatter.formatItem(item);

        assertTrue(result.contains("Name: null"));
        assertTrue(result.contains("Price: null"));
    }

    @Test
    public void formatItemWithMixedCaseKeys() {
        ItemFormatter formatter = new ItemFormatter();
        Map<String, String> item = new HashMap<>();
        item.put("NaMe", "MiLk");
        item.put("PrIcE", "3.23");
        String result = formatter.formatItem(item);

        assertTrue(result.contains("Name: Milk"));
        assertTrue(result.contains("Price: 3.23"));
    }

    @Test
    public void formatItemWithSpecialCharactersInValues() {
        ItemFormatter formatter = new ItemFormatter();
        Map<String, String> item = new HashMap<>();
        item.put("name", "MiLk@123");
        item.put("price", "3.23$");
        String result = formatter.formatItem(item);

        assertTrue(result.contains("Name: Milk@123"));
        assertTrue(result.contains("Price: 3.23$"));
    }

    @Test
    public void formatItemWithUnsortedKeys() {
        ItemFormatter formatter = new ItemFormatter();
        Map<String, String> item = new HashMap<>();
        item.put("type", "Food");
        item.put("name", "MiLk");
        item.put("price", "3.23");
        String result = formatter.formatItem(item);

        assertTrue(result.contains("Name: Milk"));
        assertTrue(result.contains("Price: 3.23"));
        assertTrue(result.contains("Type: Food"));
    }

    @Test
    public void parseWithValidData() {
        Parser parser = new Parser();
        String rawData = "naMe:Milk;price:3.23;type:Food##naMe:Bread;price:1.23;type:Food";
        String result = parser.parse(rawData);

        assertTrue(result.contains("Name: Milk"));
        assertTrue(result.contains("Price: 3.23"));
        assertTrue(result.contains("Type: Food"));
        assertTrue(result.contains("Name: Bread"));
        assertTrue(result.contains("Price: 1.23"));
        assertTrue(result.contains("Type: Food"));
        assertEquals(0, parser.getExceptionCount());
    }


    // @Test
    // public void parseWithSpecialCharacters() {
    //     JerkSONParser parser = new JerkSONParser();
    //     String rawData = "naMe:Milk@123;price:3.23$;type:Food##naMe:Bread#;price:1.23;type:Food";
    //     String result = parser.parse(rawData);

    //     assertTrue(result.contains("Name: Milk@123"));
    //     assertTrue(result.contains("Price: 3.23$"));
    //     assertTrue(result.contains("Type: Food"));
    //     assertTrue(result.contains("Name: Bread#"));
    //     assertTrue(result.contains("Price: 1.23"));
    //     assertTrue(result.contains("Type: Food"));
    //     assertEquals(0, parser.getExceptionCount());
    // }


}