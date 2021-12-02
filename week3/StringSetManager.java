import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

enum StringCommand {ADD, REMOVE, CLEAN, QUIT, INVALID, SORT};
public class StringSetManager {
    public static void main(String[] args){
        final Scanner sc = new Scanner(System.in);
        ArrayList<String> stringSet = new ArrayList<>();
        while(true){
            final StringCommand command = getCommand(sc);
            if(command == StringCommand.QUIT){
                System.out.println("BYE!");
                break;
            }
            switch (command){
                case ADD: {
                    final String str = getString(sc);
                    add(stringSet, str);
                    break;
                }
                case SORT: {
                    final String order = getString(sc);
                    sort(stringSet, order);
                    break;
                }
                case REMOVE: {
                    final String str = getString(sc);
                    remove(stringSet, str);
                    break;
                }
                case CLEAN: {
                    stringSet.clear();
                    break;
                }
                default:
                    System.out.println("Invalid Command");
                    break;
            }
            print(stringSet);
        }
    }
    public static StringCommand getCommand(Scanner sc){
        String s = sc.next();
        StringCommand com;
        try{
            com = StringCommand.valueOf(s.toUpperCase(Locale.ROOT));
        }catch (Exception e){
            com = StringCommand.INVALID;
        }
        return com;
    }
    public static String getString(Scanner sc){
        String s = sc.nextLine();
        return s.substring(1);
    }
    public static void add(ArrayList<String> list, String str){
        if(list.contains(str)){
            return;
        }
        else{
            list.add(str);
        }
    }
    public static void sort(ArrayList<String> list, String order){
        if(order.compareTo("ASC") == 0){
            Collections.sort(list);
        }
        else{
            Collections.sort(list, Collections.reverseOrder());
        }
    }
    public static void remove(ArrayList<String> list, String str){
        if(list.contains(str)){
            list.remove(str);
        }
        else{
            return;
        }
    }
    public static void print(ArrayList<String> list){
        System.out.println("Element Size: " + list.size() + ", Values = " + list.toString());
    }
}
