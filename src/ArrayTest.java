import java.util.Arrays;
public class ArrayTest {
    public static void main(String[] args) {
        NumberConverter nc = new NumberConverter(12, 64);
        String[] digits = nc.getBaseReference();
        System.out.println("\n\nDigit array: " + Arrays.toString(digits));
        System.out.println("Number: " + nc.getBaseReference());
    }
}
