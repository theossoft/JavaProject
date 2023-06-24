package Seminar3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//Заполнить список десятью случайными числами. Отсортировать список методами sort() и вывести его на экран.
public class Task001 {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        Collections.addAll(integers, 3, 5, 6, 2, 3, 6, 0, 0, 0);
        integers.sort(Comparator.naturalOrder());
        System.out.println(integers);
    }
}
