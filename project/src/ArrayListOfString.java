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

    public Map<Integer, List<String>> getStringsComparedByLength() {
        Map<Integer, List<String>> stringMap = new HashMap<>();
        for (var item :
                arrayList) {
            if (stringMap.containsKey(item.length())) {
                stringMap.get(item.length()).add(item);
            } else {
                stringMap.put(item.length(), new ArrayList<>());
                stringMap.get(item.length()).add(item);
            }
        }
        return stringMap;
    }

}
