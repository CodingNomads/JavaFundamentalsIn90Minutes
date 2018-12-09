package main.java.fundamentals_section_3.J_multithreading;

/**
 * Created by ryandesmond - https://codingnomads.co
 */
public class MultithreadingController {

    public static void main(String[] args) {

        // these threads will run in parallel (more or less)

        ImplementingRunnable runnable1 = new ImplementingRunnable("runnable1");
        ImplementingRunnable runnable2 = new ImplementingRunnable("runnable2");
        ImplementingRunnable runnable3 = new ImplementingRunnable("runnable3");

        ExtendingThread thread1 = new ExtendingThread("thread1");
        ExtendingThread thread2 = new ExtendingThread("thread2");
        ExtendingThread thread3 = new ExtendingThread("thread3");
    }

}
