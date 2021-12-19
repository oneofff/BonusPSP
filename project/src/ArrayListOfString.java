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
            if (count>1) {
                map.put(setItem, count);
            }
        }
        return map;
    }


}
