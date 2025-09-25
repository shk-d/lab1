package LabOne;
import java.util.Scanner;

public class ShelterTest {
    
    public static void main(String[] args) {
        System.out.println("\nТест 1: Создание приюта");
        Shelter shelter1 = new Shelter(5);
        
        if (shelter1.getCapacity() == 5) {
            System.out.println("Вместимость установлена правильно");
        } else {
            System.out.println("Ошибка: вместимость неверная");
        }
        
        if (shelter1.getCount() == 0) {
            System.out.println("Начальное количество котов: 0");
        } else {
            System.out.println("Ошибка: начальное количество не 0");
        }
        
        if (shelter1.getCats() != null) {
            System.out.println("Массив котов инициализирован");
        } else {
            System.out.println("Ошибка: массив не инициализирован");
        }
    
    // Тест 2: Проверка вместимости
        System.out.println("\nТест 2: Проверка вместимости");
        
        Shelter shelter2 = new Shelter(2);
        shelter2.setCapacity(10);
        
        if (shelter2.getCapacity() == 10) {
            System.out.println("Вместимость изменена правильно");
        } else {
            System.out.println("Ошибка изменения вместимости");
        }
    
    // Тест 3: Добавление и просмотр котов
        System.out.println("\nТест 3: Добавление и просмотр котов");
        
        // Создаем приют
        Shelter shelter3 = new Shelter(2);
        
        // Тестируем сеттеры и геттеры Cat
        Cat cat = new Cat();
        cat.setName("Тестовый кот");
        cat.setBreed("Тестовая порода");
        cat.setSize(5);
        
        if ("Тестовый кот".equals(cat.getName()) && "Тестовая порода".equals(cat.getBreed()) && cat.getSize() == 5) {
            System.out.println("Геттеры/сеттеры Cat работают правильно");
        } 
        else {
            System.out.println("Ошибка в геттерах/сеттерах Cat");
        }
    }
}