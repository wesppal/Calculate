package by.kata.academy;

import java.util.Scanner;

public class main {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        String input;
        while (true) {
            System.out.println("Input:");
            input = sc.nextLine();
            if (input.matches("\\d+[\\/\\+\\-*]\\d+")) {
                Validator.checkRequestDigits(input);
                Operation.math(input);
            } else {
                Validator.checkRequestDigits(input);
                Operation.mathRom(input);
            }
        }
    }
}
