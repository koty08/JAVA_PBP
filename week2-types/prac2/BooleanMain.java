import java.util.Scanner;

public class BooleanMain {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        sc.close();
        System.out.println(String.format("Number1 : %d, Number2 : %d", num1, num2));
        System.out.println(String.format("Number1 > Number2 ? %s", num1 > num2));
        System.out.println(String.format("Number1 < Number2 ? %s", num1 < num2));
        System.out.println(String.format("Number1 == Number2 ? %s", num1 == num2));
    }
}
