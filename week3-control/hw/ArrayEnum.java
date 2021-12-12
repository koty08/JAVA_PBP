import java.util.*;

enum Command{ADD, LIST, SRTA, SRTD, SUM, QUIT, INVALID};
enum Order{ASC, DES};

public class ArrayEnum {
    public static void main(String [] args){
        int index = 0;
        ArrayList<Integer> values = new ArrayList<>();
        final Scanner sc = new Scanner(System.in);

        while(true){
            final Command command = getCommand(sc);
            if(command == Command.QUIT){
                System.out.println("Bye!");
                break;
            }
            switch ( command ){
                case ADD:
                    final int newValue = getValue(sc);
                    values.add(newValue);
                    index++;
                    break;
                case LIST:
                    printList(sort(values, index, Order.ASC), index);
                    break;
                case SRTA:
                    printList(sort(values, index, Order.ASC), index);
                    break;
                case SRTD:
                    printList(sort(values, index, Order.DES), index);
                    break;
                case SUM:
                    int sum = 0;
                    for(int a : values){
                        sum += a;
                    }
                    System.out.println(sum);
                    break;
                case INVALID:
                    System.out.println("Invalid Command");
            }
        }
        sc.close();
    }
    public static Command getCommand(Scanner sc){
        String str = sc.next();
        Command com;
        try{
            com = Command.valueOf(str.toUpperCase(Locale.ROOT));
        } catch (Exception e) {
            com = Command.INVALID;
        }
        return com;
    }
    public static int getValue(Scanner sc){
        int n = sc.nextInt();
        return n;
    }
    public static void printList(ArrayList<Integer> list, int idx){
        for(int i = 0; i < idx; i++){
            if(i != idx-1){
                System.out.printf("%d ", list.get(i));
            }
            else{
                System.out.println(list.get(i));
            }
        }
    }
    public static ArrayList<Integer> sort(ArrayList<Integer> list, int idx, Order o){
        if(o.name() == "ASC"){
            Collections.sort(list);
        }
        else{
            Collections.sort(list, Collections.reverseOrder());
        }
        return list;
    }
}
