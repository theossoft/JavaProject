package Seminar1;

import java.time.LocalTime;
import java.util.Scanner;

//3. В консоли запросить имя пользователя. В зависимости от текущего времени, вывести приветствие вида:
//        "Доброе утро, <Имя>!", если время от 05:00 до 11:59
//        "Добрый день, <Имя>!", если время от 12:00 до 17:59;
//        "Добрый вечер, <Имя>!", если время от 18:00 до 22:59;
//        "Доброй ночи, <Имя>!", если время от 23:00 до 4:59
public class HomeWork3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ваше имя: ");
        String name = scanner.nextLine();

        LocalTime time = LocalTime.now();
        int hour = time.getHour();

        String greeting;
        if (hour >= 5 && hour <= 11) {
            greeting = "Доброе утро";
        } else if (hour >= 12 && hour <= 17) {
            greeting = "Добрый день";
        } else if (hour >= 18 && hour <= 22) {
            greeting = "Добрый вечер";
        } else {
            greeting = "Доброй ночи";
        }

        System.out.printf("%s, %s!", greeting, name);
    }
}
