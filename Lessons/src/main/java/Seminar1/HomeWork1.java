package Seminar1;
import java.util.Arrays;

//1. Задать одномерный массив и найти в нем минимальный и максимальный элементы ;
public class HomeWork1 {
    public static void main(String[] args) {
        int[] array = {1, 4, 30, 22, 0, -99, 99};
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) min = array[i];
            if (array[i] > max) max = array[i];
        }
        System.out.println("Минимальное значение = " + min);
        System.out.println("Максимальное значение = " + max);

    }
}
