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

        while (quotient >= number)
        {
            quotient = number / 2;
            converted = (number - quotient * 2) + converted;
        }
        converted = (number - quotient * 2) + converted;
        int[] binary = new int[converted.length()];

        for (int i = 0; i < converted.length(); i++)
        {
            binary[i] = Integer.parseInt(converted.substring(i, i + 1));
        }

        return binary;
    }

    public int[] convertToOctal() {
        return null;
    }
}