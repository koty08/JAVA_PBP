public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new MyThread();
        Thread t2 = new Thread(new MyRunnable());
        t1.start();
        t1.join();
        System.out.println("t1 is terminated...");
        t2.start();
        t2.join();
        System.out.println("t2 is terminated...");
    }
}