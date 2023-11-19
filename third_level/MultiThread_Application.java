package third_level;

//simple example of a multi-threaded Java application that demonstrates these concepts

/*
 * 1. Concurrency
 * 2. Synchronization
 * 3. Threads
 */

class Counter {

    private int count_variable = 0;

    public synchronized void increment() {
        count_variable++;
    }

    public int getCount() {
        return count_variable;
    }
}

class MyThread extends Thread {
    private Counter counter;

    public MyThread(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 10000; i++) {
            counter.increment();
        }
    }
}

public class MultiThread_Application {
    public static void main(String[] args) throws InterruptedException {
        Counter count_counter = new Counter();

        MyThread thread_One = new MyThread(count_counter);
        MyThread thread_Two = new MyThread(count_counter);

        thread_One.start();
        thread_Two.start();

        thread_One.join();
        thread_Two.join();

        System.out.println(count_counter.getCount());
    }
}
