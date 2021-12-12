public class Actor2 implements Runnable {
    private String name;
    private Counter counter;
    private Object lock = new Object();

    public Actor2(String name, Counter counter){
        this.name = name;
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized (lock) {
                counter.decrement();
            }
        }
    }
}