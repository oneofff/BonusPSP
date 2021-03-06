import java.util.*;

public class Main {

    private static final ArrayListOfString strings = new ArrayListOfString();
    private static SizedArrayDequeOfString deque;

    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println();
            showMenu();
            String choice = in.next();
            switch (choice) {
                case "1" -> add();
                case "2" -> delete();
                case "3" -> searchRepeating();
                case "4" -> XMLPush();
                case "5" -> reverseStrings();
                case "6" -> printSymbolsStatistics();
                case "7" -> searchSubStings();
                case "8" -> addFromFileAndPrint();
                case "9" -> compareStrings();
                case "10" -> stringByLength();
                case "11" -> newSizedDeque();
                case "12" -> addSizedDeque();
                case "0" -> System.exit(0);
                default -> System.out.println("Вы ввели неверное  значение");
            }
        }
    }

    private static void stringByLength() {
        System.out.println(strings);
        System.out.println(strings.getStringsComparedByLength());
    }

    private static void compareStrings() {
        try {
            System.out.println(strings);
            System.out.println("Введите индекс от 1 до " + (strings.getLength()));
            System.out.println("Введите индекс 1 строки: ");
            int firstIndex = in.nextInt() - 1;
            System.out.println("Введите индекс 2 строки: ");
            int secondIndex = in.nextInt() - 1;
            int result = strings.compareInnerObjects(firstIndex, secondIndex);
            if (result == 0) {
                System.out.println("Строки " + strings.getStringByIndex(firstIndex) + " и " + strings.getStringByIndex(secondIndex) + " одинаковые");
            } else if (result > 0) {
                System.out.println("Строка " + strings.getStringByIndex(firstIndex) + " больше строки " + strings.getStringByIndex(secondIndex));
            } else {
                System.out.println("Строка " + strings.getStringByIndex(firstIndex) + " меньше строки " + strings.getStringByIndex(secondIndex));
            }
        } catch (InputMismatchException ex) {
            System.out.println("Неверный формат числа");
        }

    }

    private static void searchSubStings() {
        System.out.println("Введите подстроку: ");
        String subString = in.next();
        System.out.println(strings);
        ArrayListOfString stringList = new ArrayListOfString(strings.getSubStrings(subString));
        if (stringList.getLength() == 0) {
            System.out.println("Строк с данной подстрокой не найдено");
            return;
        }
        System.out.println("Строки с подсрокой: " + stringList);
        System.out.println("Количество вхождений: " + stringList.getLength());
    }

    private static void searchRepeating() {
        System.out.println(strings);
        System.out.println(strings.getRepeatingElementsWithCount());
    }

    private static void showMenu() {
        System.out.println("1. Добавление нового объекта");
        System.out.println("2. Удаление объекта");
        System.out.println("3. Поиск одинаковых элементов с подсчетом совпадений");
        System.out.println("4. Выгрузка в xml-файл");
        System.out.println("5. Реверс всех строк, входящих в коллекцию");
        System.out.println("6. Статистика по всем символам, содержащимся в строках коллекции");
        System.out.println("7. Поиск подстроки в строках коллекции");
        System.out.println("8. Инициализация листа по текстовому файлу и вывод содержимого коллекции на экран");
        System.out.println("9. Сравнение строк");
        System.out.println("10. Длины строк входящих в коллекцию");
        System.out.println("11. Создать статическую коллекцию");
        System.out.println("12. Добавить элемент в статическую коллекцию");
        System.out.println("0. Выход");
    }

    private static void newSizedDeque() {
        try {
            System.out.println("Укажите размер коллекции: ");
            int size = in.nextInt();
            if (size < 1) throw new InputMismatchException();
            deque = new SizedArrayDequeOfString(size);
        } catch (InputMismatchException ex) {
            System.out.println("Неверный формат числа");
        }
    }

    private static void addSizedDeque() {
        try {
            System.out.println("Введите строку");
            String newString = in.next();
            deque.add(newString);
            System.out.println("Строка добавлена");
            System.out.println("Вся коллекция: " + deque);
        } catch (NullPointerException e) {
            System.out.println("Коллекция не создана");
        }
    }


    private static void XMLPush() {
        String filename = "file.xml";
        if (strings.XMLPush(filename)) {
            System.out.println("Данные успешно загружены в файл " + filename);
        } else {
            System.out.println("Неверный формат файла");
        }
    }

    private static void printSymbolsStatistics() {
        Map<Character, Integer> map = strings.getSymbolsStatistics();
        System.out.println("Статистика по всем символам: " + map);
    }

    private static void reverseStrings() {
        System.out.println("Изначальная коллекция: " + strings);
        if (strings.reverseStrings()) {
            System.out.println("Реверс строк проведен успешно!");
            System.out.println("Перевернутая коллекция: " + strings);
        }
    }

    private static void addFromFileAndPrint() {
        System.out.println("Введите имя файла(не используя расширение): ");
        String filename = in.next();
        filename += ".txt";
        if (strings.addFromFile(filename)) {
            System.out.println("Добавление из файла проведено успешно!");
            System.out.println("Итоговая коллекция: " + strings);
        }
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
            System.out.println("Введите индекс от 1 до " + (strings.getLength()));
            try {
                int index = in.nextInt() - 1;
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
