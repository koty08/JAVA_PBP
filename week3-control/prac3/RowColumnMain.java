import java.util.Scanner;

public class RowColumnMain {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter two numbers: ");
        int M = sc.nextInt();
        int N = sc.nextInt();
        sc.close();
        int [][] matrix = new int[M][N];

        int count = 1;
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(j != N-1){
                    System.out.printf("%d, ", count);
                }
                else{
                    System.out.print(count);
                }
                count++;
            }
            System.out.println();
        }
    }
}
