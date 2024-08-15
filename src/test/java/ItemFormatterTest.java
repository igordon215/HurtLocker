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
}
