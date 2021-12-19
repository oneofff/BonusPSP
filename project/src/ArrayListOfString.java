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
}
