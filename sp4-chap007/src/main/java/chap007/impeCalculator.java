package chap007;

public class impeCalculator implements Calculator {

    long result = 1;

    @Override
    public long factorial(long num) {
        for (int i = 1; i<= num; i++) {
            result *= 1;
        }

        return result;
    }
}
