public class ExceptionCounter {
    private int exceptionCount = 0;

    public void incrementExceptionCount() {
        exceptionCount++;
    }

    public int getExceptionCount() {
        return exceptionCount;
    }
}