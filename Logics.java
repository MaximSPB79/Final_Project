package pet_registry;

import java.util.Scanner;

public class Logics {

    private final Scanner sc = new Scanner(System.in);

    public void startMenu() {
        menu();
    }

    private void menu() {
        System.out.println("Приветствуем вас в реестре животных, зоопарка \"ZOO\".\n");
        while (true) {
            System.out.println("Для начала работы выберите нужный пункт в меню:");
            System.out.println("""
                    1. Завести новое животное
                    2. Увидеть список команд, которое выполняет животное
                    3. Обучить животное новым командам
                    4. Список всех животных
                    5. Закончить и выйти из программы""");
            String inputCommand = sc.nextLine().trim();
            switch (inputCommand) {
                case "1" -> createNewAnimal();
                case "2" -> printCommands();
                case "3" -> addCommand();
                case "4" -> printAllAnimals();
                case "5" -> System.exit(1);
                default -> System.out.println("Такой команды в меню нет\n");
            }
        }
    }

    private static void printAllAnimals() {
        Animal.animals.forEach(System.out::println);
    }

    private void addCommand() {
        boolean flag = true;
        while (flag) {
            System.out.println("Что бы добавить команду , выберите животного,  введите его ID");
            int idAnimal = Integer.parseInt(sc.nextLine());
            for (Animal animal : Animal.animals) {
                if (animal.getId() == idAnimal) {
                    System.out.println("Введите команду:");
                    String command = sc.nextLine();
                    animal.addCommand(command);
                    System.out.println("Команда добавлена");
                    flag = false;
                } else {
                    System.out.println("Животного с таким ID нет, повторите ввод");
                }
            }
        }
    }

    private void printCommands() {
        boolean flag = true;
        while (flag) {
            System.out.println("Что бы увидеть список команд животного, введите ID животного");
            int idAnimal = Integer.parseInt(sc.nextLine());
            for (Animal animal : Animal.animals) {
                if (animal.getId() == idAnimal) {
                    animal.getCommands().forEach(System.out::println);
                    flag = false;
                } else {
                    System.out.println("Животного с таким ID нет, повторите ввод");
                }
            }
        }
    }

    private void createNewAnimal() {
        boolean flag = true;
        while (flag) {
            System.out.println("Выберите нужный вид животного из списка:\n");
            System.out.println("""
                    1. Верблюд
                    2. Кошка
                    3. Собака
                    4. Осел
                    5. Хомяк
                    6. Лошадь
                    0. Выйти в основное меню""");
            String inputCommand = sc.nextLine().trim();
            String name;
            switch (inputCommand) {
                case "1" -> {
                    System.out.println("Введите имя животного:");
                    name = inputName();
                    new Camel(name);
                    System.out.println("Верблюд ," + name + " записан в базу.");
                }
                case "2" -> {
                    System.out.println("Введите имя животного:");
                    name = inputName();
                    new Cat(name);
                    System.out.println("Кот ," + name + " записан в базу.");
                }
                case "3" -> {
                    addCommand();
                    System.out.println("Введите имя животного:");
                    name = inputName();
                    new Dog(name);
                    System.out.println("Собака ," + name + " записан в базу.");
                }
                case "4" -> {
                    System.out.println("Введите имя животного:");
                    name = inputName();
                    new Donkey(name);
                    System.out.println("Осел ," + name + " записан в базу.");
                }
                case "5" -> {
                    System.out.println("Введите имя животного:");
                    name = inputName();
                    new Hamster(name);
                    System.out.println("Хомяк ," + name + " записан в базу.");
                }
                case "6" -> {
                    System.out.println("Введите имя животного:");
                    name = inputName();
                    new Horse(name);
                    System.out.println("Лошадь ," + name + " записан в базу.");
                }
                case "0" -> flag = false;

                default -> System.out.println("Такого животного в нашем зоопарке нет\n");
            }

        }
    }

    private String inputName() {
        return sc.nextLine();
    }
}
