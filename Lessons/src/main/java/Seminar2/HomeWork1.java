package Seminar2;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
//1) Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder. Данные для фильтрации приведены ниже в виде json-строки.
//Если значение null, то параметр не должен попадать в запрос.
//Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
public class HomeWork1 {
    public static void main(String[] args) {
        StringBuilder sqlString = new StringBuilder("SELECT * FROM students WHERE ");
        JSONParser parser = new JSONParser();
        boolean firstParam = true;

        try (FileReader reader = new FileReader("where.json")) {
            JSONObject rootJsonObject = (JSONObject) parser.parse(reader);
            for (Object key : rootJsonObject.keySet()) {
                Object value = rootJsonObject.get((String) key);
                if (value != null && !value.toString().equals("null")) {
                    if (firstParam) {
                        sqlString.append(key).append("='").append(value).append("'");
                        firstParam = false;
                    } else {
                        sqlString.append(" AND ").append(key).append("='").append(value).append("'");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Ошибка парсинга: " + e.toString());
        }
        System.out.println(sqlString);
        }
    }

