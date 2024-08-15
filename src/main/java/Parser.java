// 1. PatternMatcher Class - pattern matching for food items to correct misspellings and variations.
//
// 1a. Main Class - read raw data from a file, parse the data, and print the parsed output.
//
// 2. JerkSONParser Class
// Parsing the Raw Data -Split the raw input string into individual items.
// Parsing Individual Items - extract key-value pairs from each item, handling various separators.
//
// 3. Handling Special Cases
// Some items have the 'Type' and 'Expiration' fields combined with various separators.
//
// 4. Handling Missing Values
// Some key-value pairs might have missing values.
//
// 5. Formatting Output
// Format the parsed items into a readable string output.
//
// 6. Name Formatting and Pattern Matching
// Correct misspellings or variations of food names.

import java.util.Map;

public class Parser {
    private static final String ITEM_SEPARATOR = "##";
    private ItemParser itemParser;
    private ItemFormatter itemFormatter;
    private ExceptionCounter exceptionCounter;

    public Parser() {
        this.exceptionCounter = new ExceptionCounter();
        this.itemParser = new ItemParser(exceptionCounter);
        this.itemFormatter = new ItemFormatter();
    }

    public String parse(String rawData) {
        StringBuilder output = new StringBuilder();
        String[] items = rawData.split(ITEM_SEPARATOR);
        for (String item : items) {
            Map<String, String> parsedItem = itemParser.parseItem(item);
            output.append(itemFormatter.formatItem(parsedItem)).append("\n");
        }
        return output.toString();
    }

    public int getExceptionCount() {
        return exceptionCounter.getExceptionCount();
    }
}
