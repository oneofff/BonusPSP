import java.util.ArrayDeque;

public class SizedArrayDequeOfString {

    private final ArrayDeque<String> arrayDeque;
    private final int size;

    public SizedArrayDequeOfString(int size) {
        arrayDeque = new ArrayDeque<>();
        this.size = size;
    }

    void add(String str) {
        try {
            if (arrayDeque.size() >= size) {
                arrayDeque.pollFirst();
            }
            arrayDeque.add(str);
        } catch (NullPointerException ex) {
            System.out.println("Error, string is null");
        }
    }

    @Override
    public String toString() {
        return "["
                + arrayDeque +
                ']';
    }
}
