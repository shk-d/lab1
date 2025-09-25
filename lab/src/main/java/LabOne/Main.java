package LabOne;
import java.util.Scanner;

// Класс, задающий кота с основными его характеристиками
class Cat {
    private int size;  // Вес
    private String breed; // Порода
    private String name; // Кличка
    
    // Геттеры и сеттеры
    public int getSize() {
        return size;
    }
    
    public void setSize(int size) {
        this.size = size;
    }
    
    public String getBreed() {
        return breed;
    }
    
    public void setBreed(String breed) {
        this.breed = breed;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}

// Класс "Питомник" для хранения котов в массиве + основные функции
class Shelter {
    private int capacity;
    private int count;
    private Cat[] cats;
    
    // Геттеры и сеттеры для Shelter
    public int getCapacity() {
        return capacity;
    }
    
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    public int getCount() {
        return count;
    }
    
    public void setCount(int count) {
        this.count = count;
    }
    
    public Cat[] getCats() {
        return cats;
    }
    
    public void setCats(Cat[] cats) {
        this.cats = cats;
    }
    
    // Конструктор по умолчанию
    public Shelter() {
        this.setCapacity(0);
        this.setCount(0);
        this.setCats(new Cat[0]);
    }
    
    // Конструктор с параметрами
    public Shelter(int n) {
        this.setCapacity(n);
        this.setCount(0);
        this.setCats(new Cat[this.getCapacity()]);
    }
    
    // Метод для создания кота с помощью ввода
    private Cat createCat() {
        Scanner scanner = new Scanner(System.in);
        
        Cat cat = new Cat();
        
        System.out.print("Кличка: ");
        cat.setName(scanner.next());
        System.out.print("Вес: ");
        cat.setSize(scanner.nextInt());
        System.out.print("Порода: ");
        cat.setBreed(scanner.next());
        
        return cat;    
    }
    
    // Метод добавления кота в массив
    void add() {
        if(count >= capacity) {
            System.out.println("\nПриют переполнен :(\n");
            return;
        }
        System.out.println("\nВведите данные котика, которого хотите добавить: ");
        cats[count] = createCat();
        count++;
    }
    
    // Метод вывода информации о котах из приюта
     void view() {
            if(this.getCount() == 0) {
              System.out.println("\nВ приюте нет котиков :(\n");
              return;
            }
            System.out.println("\nКотики в приюте:");
            for(int i = 0; i < this.getCount(); i++) {
                System.out.println((i + 1) + "." + " " + "Кличка: " + this.getCats()[i].getName() + ";" + " "+ "Порода: " + this.getCats()[i].getBreed() + ";" + " " + "Вес: "+ this.getCats()[i].getSize() + "\n");
            }
          }
     
     // Метод вывода информации о конкретном коте
     void viewOne(Scanner scanner) {
            if(this.getCount() == 0) {
              System.out.println("\nВ приюте нет котиков :(\n");
                 return;
            }
            System.out.println("\nВыберите котика, которого хотите посмотреть: \n");
            for(int i = 0; i < this.getCount(); i++) {
              System.out.println((i + 1) + "." + " " + this.getCats()[i].getName());
            }
            System.out.println("\n0. Отмена действия\n");
            
            System.out.print("\nКого выбрать: ");
            
            int choice = scanner.nextInt() - 1;
            
            if(choice == -1) {
              System.out.println("\nДействие отменено\n");
              return;
            }
            
            if(choice < 0 || choice >= this.getCount()) {
              System.out.println("\nНет такого котика\n");
              return;
            }
            
            Cat selectedCat = this.getCats()[choice];
            
            System.out.println("\n" + "=".repeat(30));
            System.out.println("Характеристики котика:");
            System.out.println("Имя: " + selectedCat.getName());
            System.out.println("Попрода: " + selectedCat.getBreed());
            System.out.println("Вес: " + selectedCat.getSize());
            System.out.println("=".repeat(30) + "\n");
          }

     // Метод для удаления кота
     void remove(Scanner scanner) {
            if(this.getCount() == 0) {
              System.out.println("\nВ приюте нет котиков :(\n");
                 return;
            }
            System.out.println("\nВыберите котика, которого хотите забрать из приюта: \n");
            for(int i = 0; i < this.getCount(); i++) {
              System.out.println((i + 1) + "." + " " + this.getCats()[i].getName());
            }
            System.out.println("\n0. Отмена действия\n");
            
            System.out.println("\nКого забрать: \n");
            
            int choice = scanner.nextInt() - 1;
            
            if(choice == -1) {
              System.out.println("\nДействие отменено\n");
              return;
            }
            if(choice < 0 || choice >= this.getCount()) {
              System.out.println("\nНет такого котика\n");
              return;
            }
            
            for (int i = choice; i < this.getCount() - 1; i++) {
                this.getCats()[i] = this.getCats()[i + 1]; 
            }
            this.getCats()[this.getCount() - 1] = null;
            
            this.setCount(this.getCount() - 1);
            
            System.out.println("\nВы забрали котика\n");
          }

     // Метод для очистки массива (устанавливаем массив с той же вместимостью, а количество указываем равным нулю)
     void delete() {
            this.setCats(new Cat[this.getCapacity()]);
            this.setCount(0);
            System.out.println("\nПриют пуст\n");
        }    
}

// Основной класс с меню для взаимодействия
class Main {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Инициализация приюта с вместимостью n, вводящейся с клавиатуры
        int n;
        System.out.print("Укажите вместимость приюта: ");
        n = scanner.nextInt();
        Shelter shelter = new Shelter(n);        
        boolean running = true;
        
        while(running) {
        	// Вывод меню
             System.out.println("Вы в главном меню. Какой действие хотите выполнить?");
             System.out.println("1. Добавить котика");
             System.out.println("2. Забрать котика");
             System.out.println("3. Посмотреть котика");
             System.out.println("4. Посмотреть котиков");
             System.out.println("5. Очистить приют");
             System.out.println("0. Выйти из программы");
             System.out.print("\nВыберите действие: ");
             
             int menu = scanner.nextInt();    
             
             // Обработка выбора
             switch(menu) {
             case 0: // Выход из программы
               System.out.print("\nВыход из программы...\n");
               running = false;
               break;      
             case 1: // Добавление кота
                 shelter.add();
                 break;
             case 2: // Удаление кота
                 shelter.remove(scanner);
                 break;
             case 3: // Просмотр одного кота
                 shelter.viewOne(scanner);
                 break;
             case 4: // Просмотр всех котов
                 shelter.view();
                 break;
             case 5: // Очистка всего приюта
                 shelter.delete();
                 break;
             
             default: // Неверный ввод
                 System.out.println("\nНеверный выбор!\n");
             }   
        } 
        scanner.close(); // Закрытие сканера
    }
}