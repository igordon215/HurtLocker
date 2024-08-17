import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ItemParser {
    private static final Pattern KEY_VALUE_PATTERN = Pattern.compile("(\\w+)[:@^*%!]([^;##]+)");
    private static final Pattern TYPE_EXPIRATION_PATTERN = Pattern.compile("(\\w+)([:@^*%!])expiration[:@^*%!](\\d+/\\d+/\\d+)");
    private ExceptionCounter exceptionCounter;

    public ItemParser(ExceptionCounter exceptionCounter) {
        this.exceptionCounter = exceptionCounter;
    }

    public Map<String, String> parseItem(String item) {
        Map<String, String> parsedItem = new HashMap<>();
        Matcher matcher = KEY_VALUE_PATTERN.matcher(item);
        while (matcher.find()) {
            String key = matcher.group(1).trim().toLowerCase();
            String value = matcher.group(2).trim();

            if (key.equals("type") && value.toLowerCase().contains("expiration")) {
                Matcher typeExpMatcher = TYPE_EXPIRATION_PATTERN.matcher(key + ":" + value);
                if (typeExpMatcher.find()) {
                    parsedItem.put("type", typeExpMatcher.group(1).trim());
                    parsedItem.put("expiration", typeExpMatcher.group(3).trim());
                } else {
                    exceptionCounter.incrementExceptionCount();
                    parsedItem.put("type", "[No Value]");
                    parsedItem.put("expiration", "[No Value]");
                }
            } else {
                if (value.isEmpty()) {
                    exceptionCounter.incrementExceptionCount();
                    value = "[No Value]";
                }
                parsedItem.put(key, value);
            }
        }
        return parsedItem;
    }

}