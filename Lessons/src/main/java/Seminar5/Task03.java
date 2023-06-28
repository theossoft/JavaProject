package Seminar5;
/*Написать метод, который переведет число из римского формата записи в арабский.
Например, MMXXII = 2022*/

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите риское число: ");
        String inputString = scanner.nextLine();
        System.out.println(romanConverter(inputString));
        System.out.println(romanToDecimalConverter(inputString));
    }

//    Решение в группе (решение неверное)
    private static int romanConverter (String value) {

        Map<Character, Integer> romanNumber = new  HashMap<>();
        romanNumber.put('I', 1);
        romanNumber.put('V', 5);
        romanNumber.put('X', 10);
        romanNumber.put('L', 50);
        romanNumber.put('C', 100);
        romanNumber.put('D', 500);
        romanNumber.put('M', 1000);

        int sum = 0;

        for (int i = value.length() - 1; i > 0; i--) {
            if((romanNumber.get(value.charAt(i - 1)) < romanNumber.get(value.charAt(i)))) {
                sum += romanNumber.get(value.charAt(i)) - romanNumber.get(value.charAt(i - 1));
                i--;
            } else {
                sum += romanNumber.get(value.charAt(i));
            }
        }

        if(romanNumber.get(value.charAt(0)) < romanNumber.get(value.charAt(1))) {
            sum += romanNumber.get(value.charAt(1)) - romanNumber.get(value.charAt(0));
        } else {
            sum += romanNumber.get(value.charAt(0));
        }

        return sum;
    }

//    Решение преподавателя (решение неверное)
    private static Integer romanToDecimalConverter(String romanNum) {
        Map<Character, Integer> romanToDecimalMap = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000
        );

        StringBuilder romanNumSB = new StringBuilder(romanNum.trim()).reverse();
        int decimalNum = 0;
        int prevNum = -1;

        for (Character romanChar : romanNumSB.toString().toCharArray()) {
            int currentNum = romanToDecimalMap.get(romanChar);
            if(currentNum < prevNum) {
                currentNum *= -1;
            }
            decimalNum += currentNum;
            prevNum = currentNum;
        }
        return decimalNum;
    }
}
