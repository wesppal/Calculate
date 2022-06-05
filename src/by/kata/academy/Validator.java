package by.kata.academy;


public class Validator {


    public static void checkRequestDigits(String str) throws Exception {
        str = str.replaceAll("\\s", "");
        String regOperationArab = "\\d+[\\/\\+\\-*]\\d+";
        String regOperationRoman = "\\D{1,4}[\\/\\+\\-*]\\D{1,4}";
        String regOperationDifferentNumber = "\\D+[\\/\\+\\-*]\\d+";
        String regReverseOperationDifferentNumber = "\\d+[\\/\\+\\-*]\\D+";
        String regOperationLimitedOperand = ".{1,4}([\\/\\+\\-*].{1,4}){2,}";

        if (str.matches(".+") && !str.matches(regOperationArab)
                && !str.matches(regOperationRoman) && !str.matches(".{1,4}([\\/\\+\\-*].{1,4}){2,}")
                && !str.matches(regOperationDifferentNumber) && !str.matches(regReverseOperationDifferentNumber)) {
            throw new Exception("A string is not a mathematical operation.");
        }

        if (str.matches(regOperationLimitedOperand)) {
            throw new Exception("There should be only 2 operands.");
        }

        if (str.matches(regOperationDifferentNumber)
                || str.matches(regReverseOperationDifferentNumber)) {
            throw new Exception("Different number systems are used simultaneously.");
        }
    }
}
