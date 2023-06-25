package Seminar4;

import java.util.LinkedList;
import java.util.Scanner;

/*
           Реализовать консольное приложение, которое:
           1. Принимает от пользователя строку вида text~num
           2. Нужно рассплитить строку по ~, сохранить text в связный список на позицию num.
           3. Если введено print~num, выводит строку из позиции num в связном списке и удаляет её из списка.
           4. Если введено exit, то завершаем программу
           java~2
           python~5
           print~2 -> java
           print~5 -> python
           print~5 -> Некорректный индекс!
         */
public class Task01 {
    public static void main(String[] args) {


        LinkedList<String> storage = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            if ("exit".equals(command)) {
                break;
            }

            String[] arguments = command.split("~");
            if (arguments.length != 2) {
                System.err.println("Некорректный ввод");
                continue;
            }

            String text = arguments[0];
            int num = -1;
            try {
                num = Integer.parseInt(arguments[1]);
            } catch (NumberFormatException e) {
                System.err.println("Некорркетный ввод");
                continue;
            }

            if ("print".equals(text)) {
                if (num < 0 || num >= storage.size()) {
                    System.err.println("Некорректный индекс");
                    continue;
                }

                String element = storage.remove(num);
                if (element != null) {
                    System.out.println(element);
                } else {
                    System.err.println("Некорректный индекс");
                    continue;
                }
            } else {
                while (storage.size() < num) {
                    storage.add(null);
                }
                storage.add(num, text);
            }
        }

        System.out.println("Программа завершена");
    }
}
