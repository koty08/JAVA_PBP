import java.util.Arrays;
import java.util.Scanner;

public class ArrayCopyMain {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] original = new int[n];
        for(int i = 0; i < n; i++){
            original[i] = sc.nextInt();
        }
        sc.close();

        int [] shallow = original;
        modifyArray(shallow, 1);
        System.out.println("Shallow Copy: " + Arrays.toString(original));

        int [] deep = new int[n];
        System.arraycopy(original, 0, deep, 0, n);
        modifyArray(deep, 2);
        System.out.println("Deep Copy: " + Arrays.toString(original));
    }

    private static void modifyArray(int [] array, int index){
        array[index] = 15;
    }
}
