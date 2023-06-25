package Seminar4;

import java.util.*;

/**
 * Реализовать консольное приложение, которое:
 * 1. Принимает от пользователя и “запоминает” строки.
 * 2. Если введено print, выводит строки так, чтобы последняя введенная была первой в списке, а первая - последней.
 * 3. Если введено revert, удаляет предыдущую введенную строку из памяти.
 * 4. Если введено exit, то программа завершается
 *
 * > - ввод в консоль (stdin), < - вывод на консоль (stdout)
 * > java
 * > python
 * > c#
 * > print
 * < [c#, python, java]
 * > revert
 * > print
 * < [python, java]
 * > revert
 * > revert
 * > print
 * < []
 * > revert -> throw new NoSuchElementException
 */
public class HomeWork1 {
    public static void main(String[] args) {
        List<String> storage = new ArrayList<>();
        List<String> storageReverse = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("В эту программу можно ввести все что угодно.");
        System.out.println("print - вывод на печать");
        System.out.println("revert - удаление последнего элемента");
        System.out.println("exit - выход из программы");

        while (true) {
            System.out.print("Введите строку: ");
            String command = scanner.nextLine();

            if ("exit".equals(command)) {
                System.out.println("Программа заверешена.");
                break;
            }

            if("revert".equals(command)) {
                if(storage.size() <= 0) {
                    System.out.println("Больше нечего удалять.");
                } else {
                    System.out.println("Вы удалили последний введенный элемент (" + storage.get(0) + ")");
                    storage.remove(storage.get(0));
                }
                continue;

            }

            if("print".equals(command)) {
                System.out.println(storage);
                continue;
            }

            storage.add(0, command);





        }
    }
}
