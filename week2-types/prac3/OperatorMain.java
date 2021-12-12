import java.util.Scanner;

public class OperatorMain {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        sc.close();

        System.out.printf("%d / %d = %.3f\n", n1, n2, (double)n1/ n2);
        System.out.printf("%d = %d x %d + %d\n", n1, n1/n2, n2, n1%n2);
    }
}
