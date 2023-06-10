package Seminar2;

import java.io.*;

//Напишите метод, который составит строку, состоящую из 100
//повторений слова TEST и метод, который запишет эту строку в
//простой текстовый файл, обработайте исключения.
public class Task04 {
    public static void main(String[] args) throws IOException {
        StringBuilder newString = new StringBuilder();
        File file = new File("SimpleTextFile.txt");
        for (int i = 0; i < 100; i++) {
            newString.append("TEST ");
        }

        System.out.println(newString);

        FileWriter writer = new FileWriter(file, false);
        writer.write(newString.toString());
        writer.flush();

    }
}
