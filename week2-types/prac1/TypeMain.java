import java.util.Scanner;

public class TypeMain {
    public static void main(String[]  args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        printType(s);
        int stoi = Integer.valueOf(s);
        printType(stoi);
        float stof = Float.parseFloat(s);
        printType(stof);
    }

    private static void printType(String x){
        System.out.println(x + " is a string");
    }
    private static void printType(int x){
        System.out.println(x + " is an int");
    }
    private static void printType(float x){
        System.out.println(x + " is a float");
    }
}
