package by.kata.academy;


import java.util.Locale;

class Operation {
    public static String math(String str) throws Exception {
        String regex = "[\\/\\+\\-*]";
        str = str.replaceAll("\\s", "");
        String[] digits = str.split(regex);
        String operator = str.replaceAll(digits[0], "");
        operator = operator.replaceAll(digits[1], "");
        int a = Integer.parseInt(digits[0]);
        int b = Integer.parseInt(digits[1]);
        if ((a > 10) || (a < 1) || (b > 10) || (b < 1)) {
            throw new Exception("The number must be from 1 to 10");
        }
        String res = "";
        switch (operator) {
            case "/":
                double res1 = a / b;
                res = String.valueOf(res1);
                break;
            case "*":
                res = String.valueOf(a * b);
                break;
            case "+":
                res = String.valueOf(a + b);
                break;
            case "-":
                res = String.valueOf(a - b);
                break;
        }
        System.out.println("Output:" + "\n" + res);
        return res;
    }

    public static String mathRom(String str) throws Exception {
        str = str.toUpperCase(Locale.ROOT);
        String regOperator = "[\\/\\+\\-*]";
        if (str.matches(regOperator)) {
            throw new Exception("A string is not a mathematical operation.");
        }

        str = str.replaceAll("\\s", "");
        String[] digits = str.split(regOperator);

        String operator = str.replaceAll(digits[0], "");
        operator = operator.replaceAll(digits[1], "");

        try {
            if ((RomDigits.valueOf(digits[0]).getValue() > 10) || (RomDigits.valueOf(digits[0]).getValue() < 1)
                    || (RomDigits.valueOf(digits[1]).getValue() > 10) || (RomDigits.valueOf(digits[1]).getValue() < 1)) {
                throw new Exception("The number must be from 1 to 10");
            }
        } catch (IllegalArgumentException e) {
            throw new Exception("The symbol is not a number of the Roman numeral system");
        }

        String result = "";
        switch (operator) {
            case "/":
                result = String.valueOf(RomDigits.valueOf(digits[0]).getValue() / RomDigits.valueOf(digits[1]).getValue());
                break;
            case "*":
                result = String.valueOf(RomDigits.valueOf(digits[0]).getValue() * RomDigits.valueOf(digits[1]).getValue());
                break;
            case "+":
                result = String.valueOf(RomDigits.valueOf(digits[0]).getValue() + RomDigits.valueOf(digits[1]).getValue());
                break;
            case "-":
                result = String.valueOf(RomDigits.valueOf(digits[0]).getValue() - RomDigits.valueOf(digits[1]).getValue());
                break;
        }

        if (Integer.parseInt(result) < 0) {
            throw new Exception("There are no negative numbers in the Roman system.");
        }
        System.out.println("Output:" + "\n" + RomDigits.getByIndex(Integer.parseInt(result)));

        return result;
    }
}
