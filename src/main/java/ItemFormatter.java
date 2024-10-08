import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemFormatter {

       public String formatItem(Map<String, String> item) {
       StringBuilder formattedItem = new StringBuilder();
       List<String> keys = new ArrayList<>(item.keySet());
       keys.sort(String::compareTo);
       for (String key : keys) {
           String value = item.get(key);
           if (key.equalsIgnoreCase("name")) {
               value = formatName(value);
           }
           formattedItem.append(capitalize(key)).append(": ").append(value).append("\n");
       }
       return formattedItem.toString();
   }
   // USE PATTERN MATCHER CLASS TO - FORMAT FOOD NAMES
   private String formatName(String name) {
       String matchedName = PatternMatcher.findMatchingPattern(name);
       return capitalize(matchedName != null ? matchedName : name);
   }
   // CAPITALIZE ALL FIRST LETTERS OF WORDS
   private String capitalize(String str) {
       if (str == null || str.isEmpty()) {
           return str;
       }
       return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
   }

}