package LabOne;
import java.util.Scanner;

class Cat {
    private int size;
    private String breed;
    private String name;
    
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
    
    public Shelter() {
        this.setCapacity(0);
        this.setCount(0);
        this.setCats(new Cat[0]);
    }
    
    public Shelter(int n) {
        this.setCapacity(n);
        this.setCount(0);
        this.setCats(new Cat[this.getCapacity()]);
    }
    
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
    
    void add() {
        if(count >= capacity) {
            System.out.println("\nПриют переполнен :(\n");
            return;
        }
        System.out.println("Введите данные котика, которого хотите добавить: ");
        cats[count] = createCat();
        count++;
    }
    
     void view() {
            if(this.getCount() == 0) {
              System.out.println("В приюте нет котиков :(");
              return;
            }
            System.out.println("Котики в приюте:");
            for(int i = 0; i < this.getCount(); i++) {
                System.out.println((i + 1) + "." + " " + "Кличка: " + this.getCats()[i].getName() + ";" + " "+ "Порода: " + this.getCats()[i].getBreed() + ";" + " " + "Вес: "+ this.getCats()[i].getSize() + "\n");
            }
          }
     
     void viewOne(Scanner scanner) {
            if(this.getCount() == 0) {
              System.out.println("\nВ приюте нет котиков\n");
                 return;
            }
            System.out.println("\nВыберите котика, которого хотите посмотреть: \n");
            for(int i = 0; i < this.getCount(); i++) {
              System.out.println((i + 1) + "." + " " + this.getCats()[i].getName());
            }
            System.out.println("\n0. Отмена действия\n");
            
            System.out.print("Кого выбрать: \n");
            
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

     void remove(Scanner scanner) {
            if(this.getCount() == 0) {
              System.out.println("\nВ приюте нет котиков\n");
                 return;
            }
            System.out.println("\nВыберите котика, которого хотите забрать из приюта: \n");
            for(int i = 0; i < this.getCount(); i++) {
              System.out.println((i + 1) + "." + " " + this.getCats()[i].getName());
            }
            System.out.println("\n0. Отмена действия\n");
            
            System.out.println("Кого забрать: \n");
            
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
            
            System.out.println("\nКотик удален\n");
          }

     void delete() {
            this.setCats(new Cat[this.getCapacity()]);
            this.setCount(0);
            System.out.println("\nПриют пуст\n");
        }    
}

class CatTestDrive {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n;
        System.out.print("Укажите вместимость приюта: ");
        n = scanner.nextInt();
        Shelter shelter = new Shelter(n);        
        boolean running = true;
        
        while(running) {
           System.out.println("Вы в главном меню. Какой действие хотите выполнить?");
             System.out.println("1. Добавить котика");
             System.out.println("2. Удалить котика");
             System.out.println("3. Посмотреть котиков");
             System.out.println("4. Очистить массив");
             System.out.println("5. Посмотреть котика");
             System.out.println("0. Выйти из программы");
             System.out.print("Выберите действие: ");
             
             int menu = scanner.nextInt();    
             
             switch(menu) {
             case 0: 
               System.out.print("Выход из программы...");
               running = false;
               break;      
             case 1:
                 shelter.add();
                 break;
             case 2:
                 shelter.remove(scanner);
                 break;
             case 3:
                 shelter.view();
                 break;
             case 4:
                 shelter.delete();
                 break;
             case 5:
                 shelter.viewOne(scanner);
                 break;
             default:
                 System.out.println("Неверный выбор!");
             }   
        } 
        scanner.close();
    }
}