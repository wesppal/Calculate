package by.kata.academy;


import java.util.*;
import java.util.stream.Collectors;

enum RomDigits {
    I(1), II(2), III(3), IV(4), V(5), VI(6), VII(7), VIII(8), IX(9), X(10),
    XI(11), XII(12), XIII(13), XIV(14), XV(15), XVI(16), XVII(17), XVIII(18), XIX(19),
    XX(20), XXX(30), XL(40), L(50), LX(60), LXX(70), LXXX(80), XC(90), C(100);

    private int value;


    RomDigits(int i) {
        this.value = i;
    }

    public int getValue() {
        return value;
    }

    public static List getReverseSortedValues() {
        return Arrays.stream(values())
                .sorted(Comparator.comparing((RomDigits e) -> e.value).reversed())
                .collect(Collectors.toList());
    }

    public static String getByIndex(int ind) {
        String str = "";
        List<RomDigits> romDigits = getReverseSortedValues();
        int i = 0;

        while (i < romDigits.size()) {
            if (romDigits.get(i).getValue() == ind) {
                str = romDigits.get(i).toString();
                break;
            }
            i++;
        }

        return str;
    }

}
