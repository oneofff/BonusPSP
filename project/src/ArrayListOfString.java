import java.util.*;

public class ArrayListOfString {
    private List<String> arrayList;
    void add(String str){
        try {
            arrayList.add(str);
        }catch (NullPointerException ex){
            System.out.println("Error, string is null");
            ex.printStackTrace();
        }

    }
    void delete(String str){
        try {
            arrayList.remove(str);
        }catch (NullPointerException ex){
            System.out.println("Error, string is null");
            ex.printStackTrace();
        }
    }
    void delete(int index)
    {
        try {
            arrayList.remove(index);

        }catch (IndexOutOfBoundsException ex){
            System.out.println("Error, index is incorrect");
            ex.printStackTrace();
        }
    }
}
