package Seminar6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HomeWork1 {
    public static void main(String[] args) {
        ArrayList<Notebook> notebooks = new ArrayList<>();

        // Добавление ноутбуков в список
        notebooks.add(new Notebook("Модель 1", 8, "Черный"));
        notebooks.add(new Notebook("Модель 2", 16, "Серебристый"));
        notebooks.add(new Notebook("Модель 3", 4, "Красный"));
        notebooks.add(new Notebook("Модель 4", 8, "Черный"));
        notebooks.add(new Notebook("Модель 5", 16, "Серебристый"));
        notebooks.add(new Notebook("Модель 6", 2, "Синий"));

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите минимальный размер оперативной памяти: ");
        int minSizeMemory = scanner.nextInt();

        System.out.print("Введите цвет ноутбука: ");
        String цветНоутбука = scanner.next();

        // Фильтрация и вывод ноутбуков, соответствующих условиям
        for (Notebook notebook : notebooks) {
            if (notebook.getMemory() >= minSizeMemory &&
                    notebook.getColor().equalsIgnoreCase(цветНоутбука)) {
                System.out.println("Модель: " + notebook.getModel() +
                        ", Размер оперативной памяти: " + notebook.getMemory() +
                        ", Цвет: " + notebook.getColor());
            }
        }
    }
}
