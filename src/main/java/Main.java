import org.apache.commons.io.IOUtils;
import java.io.IOException;

public class Main {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        String rawData = main.readRawDataToString();
        JerkSONParser parser = new JerkSONParser();
        String parsedOutput = parser.parse(rawData);
        System.out.println(parsedOutput);
        System.out.println("Total exceptions encountered: " + parser.getExceptionCount());
    }
}
