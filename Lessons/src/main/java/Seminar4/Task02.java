package Seminar4;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task02 {
    public static void main(String[] args) {
        Path file = Path.of("file.txt");
        if (Files.notExists(file)) {
            try {
                Files.createFile(file);
            } catch (IOException e) {
                System.err.println("Не удалось создать файл: " + e.getMessage());
                return;
            }
        }

        String output = "Hello, Igor! It's " + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        try (OutputStream outputStream = Files.newOutputStream(file)) {
            outputStream.write(output.getBytes(StandardCharsets.UTF_8));
            outputStream.flush();
        } catch (IOException e) {
            System.err.println("Не удалось записать данные в файл: " + e.getMessage());
            return;
        }
        System.out.println("Данные успешно записаны в файл");

        String input;
        try (InputStream inputStream = Files.newInputStream(file)) {
            input = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.err.println("Не удалось прочитать данные из файла: " + e.getMessage());
            return;
        }
        System.out.println("Данные успешно прочитаны из файла: " + input);

        // InputStream, OutputStream - bytes
        // Reader, Writer - symbols

    }
}
