//import java.util.Scanner;
//
//public class DeepCopyTest {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        Point p1 = new Point(sc.nextInt(), sc.nextInt());
//        Point p2 = new Point(sc.nextInt(), sc.nextInt());
//
//        com.bdobe.Rectangle rectangle1 = new com.bdobe.Rectangle(p1, p2);
//        com.bdobe.Rectangle rectangle2 = new com.bdobe.Rectangle(rectangle1);
//
//        rectangle1.moveBy(sc.nextInt(), sc.nextInt());
//        sc.close();
//
//        System.out.println(rectangle1);
//        System.out.println(rectangle2);
//    }
//}