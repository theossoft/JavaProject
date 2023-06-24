package Seminar3;
//Заполнить список названиями планет Солнечной системы в произвольном пордяке с повторениями.
//Вывести названия каждой планеты и количество его повторений в списке.
//Пройти по списку и удалить повторяющиеся элементы.
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task002 {
    public static void main(String[] args) {
        List<String> names = List.of("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptun", "Pluto");
        List<String> planetList = createRandomPlanet(names, 10);
        System.out.println(planetList);
    }

    public static List<String> createRandomPlanet(List<String> planets, int len) {
        List<String> newList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            newList.add(planets.get(random.nextInt(0, 8)));
        }
        return newList;
    }
}
