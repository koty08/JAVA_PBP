import java.util.Locale;
import java.util.Scanner;

enum Comm{TRIANGLE, RECTANGLE, CIRCLE, QUIT, OTHER}

public class AreaCalculator {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            String s = sc.next();
            Comm com;
            try{
                com = Comm.valueOf(s.toUpperCase(Locale.ROOT));
            } catch (Exception e) {
                com = Comm.OTHER;
            }
            if(com == Comm.QUIT){
                System.out.println("BYE");
                break;
            }
            switch (com){
                case TRIANGLE:
                    int n1 = sc.nextInt();
                    int n2 = sc.nextInt();
                    System.out.printf("Area of com.bdobe.Triangle: %.2f\n", n1*n2/2.0);
                    break;
                case RECTANGLE:
                    n1 = sc.nextInt();
                    n2 = sc.nextInt();
                    System.out.printf("Area of com.bdobe.Rectangle: %.2f\n", (float)n1*n2);
                    break;
                case CIRCLE:
                    float f1 = sc.nextFloat();
                    System.out.printf("Area of Cirlce: %.2f\n", f1*f1* Math.PI);
                    break;
                default:
                    System.out.println("INVALID");
                    break;
            }
        }
    }
}
