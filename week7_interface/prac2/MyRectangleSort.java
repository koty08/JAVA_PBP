public class MyRectangleSort {
    public static void sort(MyComparable[] list) {
       for(int i = 0; i < list.length - 1; i++){
           for(int j = i+1; j < list.length; j++){
               Rectangle r1 = (Rectangle) list[i];
               Rectangle r2 = (Rectangle) list[j];
               if(r1.compareTo(r2) < 0){
                   Rectangle tmp = (Rectangle) list[j];
                   list[j] = list[i];
                   list[i] = tmp;
               }
           }
       }
    }
}
