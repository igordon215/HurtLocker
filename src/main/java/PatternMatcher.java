import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class PatternMatcher {
    private static final Map<String, Pattern> foodPatterns;

    static {
        foodPatterns = new HashMap<>();
        foodPatterns.put("Milk", Pattern.compile("(?i)milk"));
        foodPatterns.put("Bread", Pattern.compile("(?i)bread"));
        foodPatterns.put("Apples", Pattern.compile("(?i)apples"));
        foodPatterns.put("Cookies", Pattern.compile("(?i)c[o0]{2}kies"));
    }

    public static String findMatchingPattern(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        for (Map.Entry<String, Pattern> entry : foodPatterns.entrySet()) {
            if (entry.getValue().matcher(input).matches()) {
                return entry.getKey();
            }
        }
        return input;
    }

//    public static void main(String[] args) {
//        String[] testInputs = {
//                "MilK", "MiLK",
//                "BreaD", "BrEAD",
//                "apPles",
//                "CoOkieS", "COokIes", "COOkieS", "Co0kieS",
//
//        };
//
//        for (String input : testInputs) {
//            String result = findMatchingPattern(input);
//            System.out.println("Input: " + input + " -> Matched: " + result);
//        }
//    }
}