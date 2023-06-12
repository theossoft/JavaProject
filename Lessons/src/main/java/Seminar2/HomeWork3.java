package Seminar2;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//3) Дана json-строка (можно сохранить в файл и читать из файла)
//        [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
//        Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
//        Пример вывода:
//        Студент Иванов получил 5 по предмету Математика.
//        Студент Петрова получил 4 по предмету Информатика.
//        Студент Краснов получил 5 по предмету Физика.
public class HomeWork3 {
    public static void main(String[] args) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("Student.json"));
        JSONArray jsonArray = (JSONArray) obj;

//        String jsonStr = new String(Files.readAllBytes(Paths.get("Student.json")));
//        JSONArray jsonArray = new JSONArray(jsonStr);

        List<String> output = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObj = (JSONObject)jsonArray.get(i);
            String surname = (String) jsonObj.get("фамилия");
            String mark = (String) jsonObj.get("оценка");
            String subject = (String) jsonObj.get("предмет");
            sb.append("Студент ")
                    .append(surname)
                    .append(" получил ")
                    .append(mark)
                    .append(" по предмету ")
                    .append(subject)
                    .append(".");
            output.add(sb.toString());
            sb.setLength(0);
        }

        for (String str : output) {
            System.out.println(str);
        }
//        JSONParser parser = new JSONParser();
//
//        try {
//            Object obj = parser.parse(new FileReader("Student.json"));
//
//            JSONArray jsonArray = (JSONArray) obj;
//
//            Iterator<JSONObject> iterator = jsonArray.iterator();
//            while (iterator.hasNext()) {
//                JSONObject jsonObject = iterator.next();
//                for (Object key : jsonObject.keySet()) {
//                    System.out.println(key + " : " + jsonObject.get(key));
//                }
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
