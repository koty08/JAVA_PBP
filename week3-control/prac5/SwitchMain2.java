import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

enum Com {ADD, PRINT, QUIT, OTHER};

public class SwitchMain2 {
    public static void main(String[] args){
        ArrayList<String> months = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while(true){
            String str = sc.next();
            Com com;
            try{
                com = Com.valueOf(str.toUpperCase(Locale.ROOT));
            } catch (Exception e) {
                com = Com.OTHER;
            }
            if(com == Com.QUIT){
                System.out.println("Bye");
                break;
            }
            switch (com){
                case ADD:
                    int n = sc.nextInt();
                    switch (n){
                        case 1:
                            months.add("January");
                            break;
                        case 2:
                            months.add("February");
                            break;
                        case 3:
                            months.add("March");
                            break;
                        case 4:
                            months.add("April");
                            break;
                        case 5:
                            months.add("May");
                            break;
                        case 6:
                            months.add("June");
                            break;
                        case 7:
                            months.add("July");
                            break;
                        case 8:
                            months.add("August");
                            break;
                        case 9:
                            months.add("September");
                            break;
                        case 10:
                            months.add("October");
                            break;
                        case 11:
                            months.add("November");
                            break;
                        case 12:
                            months.add("December");
                            break;
                    }
                    break;
                case PRINT:
                    System.out.println(months.toString());
                    break;
                case OTHER:
                    System.out.println("Invalid edu.pnu.admin.Command");
                    break;
            }
        }
    }
}
