package Seminar3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomeWork1 {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        List<Integer> oddList = new ArrayList<>();
        Collections.addAll(integerList, 1, 3, 5, 6, 9, 0, 34, 12, 77);
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < integerList.size(); i++) {
            sum += integerList.get(i);
            if(integerList.get(i) > maxValue) maxValue = integerList.get(i);
            if(integerList.get(i) < minValue) minValue = integerList.get(i);
            if(integerList.get(i) % 2 != 0) oddList.add(integerList.get(i));
        }
        int averageValue = (sum / integerList.size());
        System.out.println("Дан список: " + integerList);
        System.out.println("Максимальное значение: " + maxValue);
        System.out.println("Минимальное значение: " + minValue);
        System.out.println("Среднее значение: " + averageValue);
        System.out.println("Нечетный список: " + oddList);
    }
}
