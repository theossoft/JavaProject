package Seminar1;
//Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
//и с помощью цикла(-ов) заполнить его диагональные элементы единицами
//(можно только одну из диагоналей, если обе сложно).
//Определить элементы одной из диагоналей можно по следующему принципу:
//индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n];

import java.util.Arrays;

public class HomeWork2 {
    public static void main(String[] args) {
        int[][] doubleArray = new int[5][5];
        for (int i = 0; i < doubleArray.length; i++) {
            for (int j = 0; j < doubleArray[i].length; j++) {
                if (i == j) doubleArray[i][j] = 1;
                doubleArray[i][doubleArray.length - i - 1] = 1;
                System.out.print(" " + doubleArray[i][j] + " ");

            }
            System.out.println();
        }

        for (int[] row: doubleArray) {

        }


    }

}
