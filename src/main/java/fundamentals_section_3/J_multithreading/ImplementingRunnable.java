package main.java.fundamentals_section_3.J_multithreading;

/**
 * Created by ryandesmond - https://codingnomads.co
 */
public class ImplementingRunnable implements Runnable {

    // we still need a Thread object to use
    Thread thread;

    // constructor that takes in the name of the new thread
    public ImplementingRunnable(String name){
        // instantiate the thread and pass "this" which is a reference to "this" class to the Thread constructor
        thread = new Thread(this, name);

        // start the thread automatically when this object is created (which is when this constructor is invoked)
        thread.start();
    }

    @Override
    public void run() {

        // just demonstrate a thread doing something
        for(int i = 0; i < 10; i++){
            try {
                // sleep on each loop just to give it a delay so we can see the threads executing in parallel
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(thread.getName() + " on loop #" + i);
        }
    }

}
