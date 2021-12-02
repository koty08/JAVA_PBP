import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PrimeNumberMain {
    public static void main(String args []){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number:");
        int n = sc.nextInt();
        sc.close();
        for(int i = 2; i <= n; i++){
            System.out.println("Prime Numbers less than or equal to " + i + " = " + Arrays.toString(getPrimeNumber(i)));
        }
    }
    private static Integer[] getPrimeNumber (final int n){
        List<Integer> primes = new ArrayList<Integer>();
        boolean is_prime;
        for(int i = 2; i <= n; i++){
            is_prime = true;
            for(int j = 2; j < i; j++){
                if(i % j == 0){
                    is_prime = false;
                }
            }
            if(is_prime){
                primes.add(i);
            }
        }
        Integer [] retArray = new Integer[primes.size()];
        primes.toArray(retArray);
        return retArray;
    }
}
