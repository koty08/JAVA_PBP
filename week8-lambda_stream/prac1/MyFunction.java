@FunctionalInterface
public interface MyFunction {
    public abstract void run();
    public static MyFunction getMyFunction(String str){
        MyFunction f3 = () -> System.out.println("f3.run()");
        return f3;
    }

    default void sayHello(){
        System.out.println("Hello");
    }
}
