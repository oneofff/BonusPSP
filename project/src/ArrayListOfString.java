import java.beans.XMLEncoder;
import java.io.*;
import java.util.*;

public class ArrayListOfString {
    private final List<String> arrayList;

    void add(String str) {
        try {
            arrayList.add(str);
        } catch (NullPointerException ex) {
            System.out.println("Error, string is null");
        }
    }

    public String getStringByIndex(int index) {
        return arrayList.get(index);
    }

    public ArrayListOfString(List<String> arrayList) {
        this.arrayList = arrayList;
    }

    public ArrayListOfString() {
        arrayList = new ArrayList<>();
    }

    boolean delete(String str) {
        try {
            return arrayList.remove(str);
        } catch (NullPointerException ex) {
            System.out.println("Error, string is null");
        }
        return false;
    }

    String delete(int index) {
        try {
            return arrayList.remove(index);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Error, index is incorrect");
        }
        return null;
    }


    @Override
    public String toString() {
        return "["
                + arrayList +
                ']';
    }

    public int getLength() {
        return arrayList.size();
    }

    public Map<String, Integer> getRepeatingElementsWithCount() {
        Map<String, Integer> map = new HashMap<>();
        Set<String> stringSet = new HashSet<>(arrayList);
        if (stringSet.size() == arrayList.size()) {
            return map;
        }
        for (var setItem :
                stringSet) {
            int count = 0;
            for (var arrayItem :
                    arrayList) {
                if (Objects.equals(arrayItem, setItem)) {
                    count++;
                }
            }
            if (count > 1) {
                map.put(setItem, count);
            }
        }
        return map;
    }


    public Map<Character, Integer> getSymbolsStatistics() {
        Map<Character, Integer> map = new HashMap<>();
        for (String string : arrayList) {
            for (char ch : string.toCharArray()) {
                map.put(ch, map.get(ch) != null ? map.get(ch) + 1 : 1);
            }
        }
        return map;
    }

    public List<String> getSubStrings(String subString) {
        List<String> stringsContainsSub = new ArrayList<>();
        for (var string :
                arrayList) {
            if (string.contains(subString)) {
                stringsContainsSub.add(string);
            }
        }
        return stringsContainsSub;
    }

    public int compareInnerObjects(int firstIndex, int secondIndex) {
        return arrayList.get(firstIndex).compareTo(arrayList.get(secondIndex));

    }

    public boolean XMLPush(String filename) {
        try {
            XMLEncoder x = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(filename)));
            x.writeObject(arrayList);
            x.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error, filename is incorrect");
        }
        return false;
    }


    public boolean reverseStringByIndex(int index) {
        try {
            char[] string = arrayList.get(index).toCharArray();
            int n = string.length;
            for (int i = 0; i < n / 2; i++) {
                char temp = string[i];
                string[i] = string[n - 1 - i];
                string[n - 1 - i] = temp;
            }
            arrayList.set(index, String.valueOf(string));
            return true;
        } catch (Exception e) {
            System.out.println("Error, index is incorrect");
        }
        return false;
    }

    public boolean reverseStrings() {
        try {
            for (int i = 0; i < arrayList.size(); i++)
                if (!reverseStringByIndex(i)) {
                    throw new Exception("Error, reverse failed");
                }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addFromFile(String filename) {
        try (FileReader reader = new FileReader(filename)) {
            Scanner scanner = new Scanner(reader);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] strings = line.split(" ");
                arrayList.addAll(List.of(strings));
            }

            reader.close();
            return true;
        } catch (IOException e) {
            System.out.println("Error, filename is incorrect");
        }
        return false;
    }

    public Map<Integer, List<String>> getStringsComparedByLength() {
        Map<Integer, List<String>> stringMap = new HashMap<>();
        for (var item :
                arrayList) {
            if (!stringMap.containsKey(item.length())) {
                stringMap.put(item.length(), new ArrayList<>());
            }
            stringMap.get(item.length()).add(item);
        }
        return stringMap;
    }

}
