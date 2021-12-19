import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static final ArrayListOfString strings = new ArrayListOfString();

    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println();
            showMenu();
            String choice = in.next();
            switch (choice) {
                case "1" -> add();
                case "2" -> delete();
                case "0" -> System.exit(0);
            }
        }
    }

    private static void showMenu() {
        System.out.println("1. Добавление нового объекта");
        System.out.println("2. Удаление нового объекта");
        System.out.println("3. Поиск одинаковых элементов с подсчетом совпадений");
        System.out.println("4. Выгрузка в xml-файл");
        System.out.println("5. Реверс всех строк, входящих в коллекцию");
        System.out.println("6. Статистика по всем символам, содержащимся в строках коллекции");
        System.out.println("7. Поиск подстроки в строках коллекции");
        System.out.println("8. Инициализация листа по текстовому файлу и вывод содержимого коллекции на экран");
        System.out.println("9. Сравнение строк");
        System.out.println("10. Длины строк входящих в коллекцию");
        System.out.println("0. Выход");
    }

    private static void delete() {
        int length = strings.getLength();
        if (length <= 0) {
            System.out.println("Массива строк не существует");
            return;
        }
        System.out.println("1. Удаление по индексу");
        System.out.println("2. Удаление по содержимому строки");
        String choose = in.next();
        if (choose.equals("1")) {
            System.out.println("Введите индекс от 0 до " + (strings.getLength() - 1));
            try {
                int index = in.nextInt();
                String deletedString = strings.delete(index);
                if (deletedString == null) {
                    return;
                }
                System.out.println("Строка [" + deletedString + "] удалена");
                System.out.println("Вся коллекция: " + strings);
            } catch (InputMismatchException ex) {
                System.out.println("Неверный формат числа");
            }
        } else if (choose.equals("2")) {
            System.out.println("Введите строку");
            String deletedString = in.next();
            boolean isDeleted = strings.delete(deletedString);
            if (isDeleted) {
                System.out.println("Строка [" + deletedString + "] успешно удалена");
            }
            System.out.println("Вся коллекция: " + strings);
        }
    }

    private static void add() {
        System.out.println("Введите строку");
        String newString = in.next();
        strings.add(newString);
        System.out.println("Строка добавлена");
        System.out.println("Вся коллекция: " + strings);
    }

}
