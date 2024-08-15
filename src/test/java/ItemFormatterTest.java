import org.junit.Test;
import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.Map;

public class ItemFormatterTest {
    @Test
    public void testFormatItem() {
        ItemFormatter formatter = new ItemFormatter();
        Map<String, String> item = new HashMap<>();
        item.put("name", "MiLk");
        item.put("price", "3.23");
        item.put("type", "Food");

        String result = formatter.formatItem(item);
        assertTrue(result.contains("Name: Milk"));
        assertTrue(result.contains("Price: 3.23"));
        assertTrue(result.contains("Type: Food"));
    }

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

}
