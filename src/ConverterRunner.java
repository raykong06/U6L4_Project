import java.util.Scanner;
import java.util.Arrays;

class ConverterRunner {
    public static void main(String[] args) {
        // Instance Variables
        boolean binary = false;
        boolean octal = false;
        boolean decimal = false;
        boolean checkChoice = true;
        boolean invalidInput = false;
        boolean checkInput = true;

        final String binaryValidInput = "01";
        final String octalValidInput = "01234567";
        final String decimalValidInput = "0123456789";

        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");
        System.out.print("Enter the base of your number (2, 8 or 10): ");

        Scanner s = new Scanner(System.in);
        String choice = s.nextLine();
        while (checkChoice)
        {
            if (choice.equals("2") || choice.equals("8") || choice.equals("10"))
            {
                checkChoice = false;
            }
            else
            {
                System.out.print("That is an invalid input. Please enter the base of your number (2, 8 or 10): ");
                choice = s.nextLine();
            }
        }
        int base = Integer.parseInt(choice);

        if (base == 2)
        {
            binary = true;
            octal = false;
            decimal = false;
        }
        else if (base == 8)
        {
            binary = false;
            octal = true;
            decimal = false;
        }
        else if (base == 10)
        {
            binary = false;
            octal = false;
            decimal = true;
        }

        System.out.print("Enter your number: ");
        String number = s.nextLine();

        while (checkInput)
        {
            invalidInput = false;
            if (binary)
            {
                String substring;
                for (int i = 0; i < number.length(); i++)
                {
                    substring = number.substring(i, i + 1);
                    if (binaryValidInput.indexOf(substring) == -1)
                    {
                        invalidInput = true;
                    }
                }
            }
            else if (octal)
            {
                String substring;
                for (int i = 0; i < number.length(); i++)
                {
                    substring = number.substring(i, i + 1);
                    if (octalValidInput.indexOf(substring) == -1)
                    {
                        invalidInput = true;
                    }
                }
            }
            else if (decimal)
            {
                String substring;
                for (int i = 0; i < number.length(); i++)
                {
                    substring = number.substring(i, i + 1);
                    if (decimalValidInput.indexOf(substring) == -1)
                    {
                        invalidInput = true;
                    }
                }
            }

            if (!invalidInput)
            {
                checkInput = false;
            }
            else
            {
                System.out.print("The number you inputted is invalid. Please enter another number: ");
                number = s.nextLine();
            }
        }
        int n = Integer.parseInt(number);

        s.close();


        NumberConverter nc = new NumberConverter(n, base);
        int[] digits = nc.getDigits();
        System.out.println("\n\nDigit array: " + Arrays.toString(digits));
        System.out.println("Number: " + nc.displayOriginalNumber());
        System.out.println("Number: " + Arrays.toString(nc.convertToBinary()));
    }
}

