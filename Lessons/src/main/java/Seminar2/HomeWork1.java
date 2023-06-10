package Seminar2;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//1) Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder. Данные для фильтрации приведены ниже в виде json-строки.
//Если значение null, то параметр не должен попадать в запрос.
//Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
public class HomeWork1 {
    public static void main(String[] args) {
        StringBuilder sqlString = new StringBuilder("SELECT * FROM students WHERE ");
        JSONParser parser = new JSONParser();
        String name = null;
        String country = null;
        String city = null;
        long age = 0;
        boolean firstParam = true;

        try (FileReader reader = new FileReader("where.json")) {
            JSONObject rootJsonObject = (JSONObject) parser.parse(reader);
//            name = (String) rootJsonObject.get("name");
//            country = (String) rootJsonObject.get("country");
//            city = (String) rootJsonObject.get("city");
//            age = (long) rootJsonObject.get("age");
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

//        sqlString.append("name = ");
//        sqlString.append(name);
//        sqlString.append(" AND ");
//        sqlString.append("country = ");
//        sqlString.append(country);
//        sqlString.append(" AND ");
//        sqlString.append("city = ");
//        sqlString.append(city);



        System.out.println(sqlString);

        }
    }

