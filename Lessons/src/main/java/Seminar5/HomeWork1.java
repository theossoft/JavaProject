package Seminar5;

import java.util.*;

/*Реализовать консольное приложение - телефонный справочник.
        У одной фамилии может быть несколько номеров.
        Пользователь может вводить команды:
        1: ADD Ivanov 88005553535 - добавить в справочник новое значение. Первый аргумент - фамилия, второй - номер телефона
        2: GET Ivanov - получить список всех номеров по фамилии
        3: REMOVE Ivanov - удалить все номера по фамилии
        4: LIST - Посмотреть все записи
        5: EXIT - Завершить программу

        Если при GET или REMOVE нужной фамилии нет, вывести информацию об этом
        .

        Пример взаимодействия (=> - это вывод на консоль):
        ADD Ivanov 8 800 555 35 35
        ADD Ivanov 8 800 100 10 10
        GET Ivanov => [8 800 555 35 35, 8 800 100 10 10]
        ADD Petrov 8 555 12 34
        LIST => Ivanov = [8 800 5553535, 8 800 100 10 10], Petrov = [8 555 12 34]
        REMOVE Ivanov
        LIST => Petrov = [8 555 12 34]
        GET NoName => Не найдена запись с фамилией "NoName"
        REMOVE NoName => Не найдена запись с фамилией "NoName"3*/
public class HomeWork1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhoneBook phoneBook = new PhoneBook();

        while (true) {
            System.out.println("Введите команду:");
            String command = scanner.nextLine();

            if (command.startsWith("ADD")) {
                String[] parts = command.split(" ");
                if (parts.length == 3) {
                    String lastName = parts[1];
                    String phoneNumber = parts[2];
                    phoneBook.addContact(lastName, phoneNumber);
                } else {
                    System.out.println("Некорректная команда ADD");
                }
            } else if (command.startsWith("GET")) {
                String[] parts = command.split(" ");
                if (parts.length == 2) {
                    String lastName = parts[1];
                    phoneBook.getNumbers(lastName);
                } else {
                    System.out.println("Некорректная команда GET");
                }
            } else if (command.startsWith("REMOVE")) {
                String[] parts = command.split(" ");
                if (parts.length == 2) {
                    String lastName = parts[1];
                    phoneBook.removeContact(lastName);
                } else {
                    System.out.println("Некорректная команда REMOVE");
                }
            } else if (command.equals("LIST")) {
                phoneBook.listContacts();
            } else if (command.equals("EXIT")) {
                break;
            } else {
                System.out.println("Неизвестная команда");
            }
        }
    }
}


class PhoneBook {
    private Map<String, List<String>> contacts;

    public PhoneBook() {
        contacts = new HashMap<>();
    }

    public void addContact(String lastName, String phoneNumber) {
        List<String> numbers = contacts.getOrDefault(lastName, new ArrayList<>());
        numbers.add(phoneNumber);
        contacts.put(lastName, numbers);
    }

    public void getNumbers(String lastName) {
        List<String> numbers = contacts.get(lastName);
        if (numbers != null) {
            System.out.println(numbers);
        } else {
            System.out.println("Не найдена запись с фамилией \"" + lastName + "\"");
        }
    }

    public void removeContact(String lastName) {
        List<String> numbers = contacts.remove(lastName);
        if (numbers != null) {
            System.out.println("Удалены все номера по фамилии \"" + lastName + "\"");
        } else {
            System.out.println("Не найдена запись с фамилией \"" + lastName + "\"");
        }
    }

    public void listContacts() {
        for (Map.Entry<String, List<String>> entry : contacts.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
