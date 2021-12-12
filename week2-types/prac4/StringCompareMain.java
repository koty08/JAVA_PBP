import java.util.Locale;
import java.util.Scanner;

public class StringCompareMain {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        sc.close();
        System.out.println(str1.equals(str2));
        System.out.println(str1.equalsIgnoreCase(str2));
        System.out.println(str1.equalsIgnoreCase(str2.toLowerCase(Locale.ROOT)));
        System.out.println(str1.replace("easy", "fun").equalsIgnoreCase(str2));
    }
}
