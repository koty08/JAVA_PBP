import java.util.Arrays;
import java.util.Scanner;

public class MathMain {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N: ");
        int n = sc.nextInt();
        int [] inputs = new int[n];
        for(int i = 0; i<n; i++){
            inputs[i] = sc.nextInt();
        }
        sc.close();

        int max = getMax(inputs);
        System.out.printf("Max element : %d in %s\n", max, Arrays.toString(inputs));

        int min = getMin(inputs);
        System.out.printf("Min element : %d in %s\n", min, Arrays.toString(inputs));
    }
    private static int getMax(int [] arr){
        int max = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
    private static int getMin(int [] arr){
        int min = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }
}
