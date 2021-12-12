public class SynchronizedTest {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Actor actor1 = new Actor("Actor1", counter);
        Actor2 actor2 = new Actor2("Actor2", counter);
        Thread t1 = new Thread(actor1);
        Thread t2 = new Thread(actor2);
        t1.start(); t2.start();
        t1.join(); t2.join();
        System.out.println(counter.value());
    }
}