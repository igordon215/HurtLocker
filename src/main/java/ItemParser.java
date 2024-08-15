import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ItemParser {
    private static final Pattern KEY_VALUE_PATTERN = Pattern.compile("(\\w+)[:@^*%!]([^;##]+)");
    private ExceptionCounter exceptionCounter;

    public ItemParser(ExceptionCounter exceptionCounter) {
        this.exceptionCounter = exceptionCounter;
    }

    public Map<String, String> parseItem(String item) {
        Map<String, String> parsedItem = new HashMap<>();
        Matcher matcher = KEY_VALUE_PATTERN.matcher(item);
        while (matcher.find()) {
            String key = matcher.group(1).trim();
            String value = matcher.group(2).trim();
            if (key.equalsIgnoreCase("type") && value.contains("expiration")) {
                String[] parts = value.split("[:@^*%!]");
                parsedItem.put("type", parts[0].trim());
                if (parts.length > 1) {
                    parsedItem.put("expiration", parts[1].trim());
                }
            } else {
                if (value.isEmpty()) {
                    exceptionCounter.incrementExceptionCount();
                    value = "[No Value]";
                }
                parsedItem.put(key.toLowerCase(), value);
            }
        }
        return parsedItem;
    }


//    public static void main(String[] args) {
//        ExceptionCounter counter = new ExceptionCounter();
//        ItemParser parser = new ItemParser(counter);
//
//        String testItem = "naMe:MiLk;price:3.23;type:Food;expiration:1/25/2016";
//        System.out.println("Testing ItemParser with: " + testItem);
//
//        Map<String, String> result = parser.parseItem(testItem);
//        System.out.println("Parsed result:");
//        for (Map.Entry<String, String> entry : result.entrySet()) {
//            System.out.println(entry.getKey() + ": " + entry.getValue());
//        }
//
//        System.out.println("Exception count: " + counter.getExceptionCount());
//    }


}
