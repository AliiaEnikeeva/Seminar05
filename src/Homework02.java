//Пусть дан список сотрудников:
//Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений.
//Отсортировать по убыванию популярности.
import java.util.*;
public class Homework02 {
    public static void main(String[] args) {

        List<String> employees = new ArrayList<>(); // создаем коллекцию для хранения имен сотрудников
        employees.add("Иван Иванов");
        employees.add("Светлана Петрова");
        employees.add("Кристина Белова");
        employees.add("Анна Мусина");
        employees.add("Анна Крутова");
        employees.add("Иван Юрин");
        employees.add("Петр Лыков");
        employees.add("Павел Чернов");
        employees.add("Иван Иванов");
        employees.add("Петр Чернышов");
        employees.add("Мария Федорова");
        employees.add("Марина Светлова");
        employees.add("Мария Савина");
        employees.add("Иван Иванов");
        employees.add("Мария Рыкова");
        employees.add("Анна Крутова");
        employees.add("Марина Лугова");
        employees.add("Анна Владимирова");
        employees.add("Петр Лыков");
        employees.add("Иван Иванов");// добавляем повторяющееся имя
        employees.add("Иван Мечников");
        employees.add("Петр Петин");
        employees.add("Петр Лыков");
        employees.add("Иван Ежов");

        Map<String, Integer> nameCount = new HashMap<>(); // создаем коллекцию для хранения количества вхождений каждого имени

        for (String name : employees) { // перебираем имена сотрудников
            if (nameCount.containsKey(name)) { // если имя уже встречалось, увеличиваем количество вхождений на 1
                nameCount.put(name, nameCount.get(name) + 1);
            } else {
                nameCount.put(name, 1); // иначе добавляем имя в коллекцию с количеством вхождений 1
            }
        }

        List<Map.Entry<String, Integer>> sortedNames = new ArrayList<>(nameCount.entrySet()); // создаем коллекцию для сортировки имен по убыванию вхождений
        sortedNames.sort(new Comparator<Map.Entry<String, Integer>>() { // сортируем по убыванию вхождений
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        for (Map.Entry<String, Integer> entry : sortedNames) { // выводим результаты на экран
            System.out.println(entry.getKey() + " - " + entry.getValue() + " раз(а)");
        }
    }
}
