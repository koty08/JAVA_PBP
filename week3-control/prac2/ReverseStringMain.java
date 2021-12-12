import java.util.Scanner;

public class ReverseStringMain {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String revstr = "";

        for(int i = str.length()-1; i >= 0; i--){
            revstr += str.charAt(i);
        }

        System.out.println(revstr);
    }
}
