public class MyArrayList<T>{
    private Object[] arraydata;
    private int count;

    public MyArrayList(int capacity){
        if(capacity > 0){
            this.arraydata = new Object[capacity];
            this.count = 0;
        }
    }

    public void add(T data){
        arraydata[count++] = data;
    }

    public T get(int index){
        T ret = (T) arraydata[index];
        return ret;
    }
}
