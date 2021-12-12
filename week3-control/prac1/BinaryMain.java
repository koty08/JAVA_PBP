import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BinaryMain {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Integer n = sc.nextInt();
        sc.close();

        Integer tmp = n;
        ArrayList<Integer> result = new ArrayList<>();
        while(tmp > 1){
            result.add(tmp % 2);
            tmp /= 2;
        }
        result.add(tmp);
        Collections.reverse(result);
        String str = "";
        for(int i = 0; i < result.size(); i++){
            str += (result.get(i).toString());
        }

        System.out.printf("Number %d in Binary Number: %s", n, str);
    }
}
