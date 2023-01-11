public class NumberConverter {
    int[] digits;
    int base;
    String[] baseReference;

    public NumberConverter(int number, int base) {
        String numberAsString = Integer.toString(number);
        digits = new int[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++) {
            String single = numberAsString.substring(i,i+1);
            int d = Integer.parseInt(single);
            digits[i] = d;
        }
        this.base = base;

        baseReference = new String[64];
        String digitMap = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz+/";
        for (int i = 0; i < 64; i++)
        {
            String single = digitMap.substring(i, i + 1);
            baseReference[i] = single;
        }
    }

    public String displayOriginalNumber() {
        String o = "";
        for (int i = 0; i < digits.length; i++) {
            o = o + digits[i];
        }
        //o = o + "\n";
        return o;
    }

    public int[] getDigits() {
        return digits;
    }

    public String[] getBaseReference(){
        return baseReference;
    }

    public int[] convertToDecimal() {

        return null;
    }

    public int[] convertToBinary() {
        String converted = "";
        int number = Integer.parseInt(displayOriginalNumber());
        int quotient = number;
        int subtractNumber;

        while (quotient >= 2)
        {
            subtractNumber = quotient;
            quotient = quotient / 2;
            converted = (subtractNumber - (quotient * 2)) + converted;
        }
        converted = quotient + converted;
        int[] binary = new int[converted.length()];

        for (int i = 0; i < converted.length(); i++)
        {
            binary[i] = Integer.parseInt(converted.substring(i, i + 1));
        }

        return binary;
    }

    public int[] convertToOctal()
    {
        String converted = "";
        int number = Integer.parseInt(displayOriginalNumber());
        int quotient = number;
        int subtractNumber;

        while (quotient >= 8)
        {
            subtractNumber = quotient;
            quotient = quotient / 8;
            converted = (subtractNumber - (quotient * 8)) + converted;
        }
        converted = quotient + converted;
        int[] octal = new int[converted.length()];

        for (int i = 0; i < converted.length(); i++)
        {
            octal[i] = Integer.parseInt(converted.substring(i, i + 1));
        }

        return octal;
    }
}