package main.java.fundamentals_section_3.J_multithreading;

/**
 * Created by ryandesmond - https://codingnomads.co
 */
public class ExtendingThread extends Thread {

    // constructor that takes in the name of the new thread
    public ExtendingThread(String name) {
        // call the super constructor and pass the name
        super(name);
        // automatically start the thread when the object is created (which is when this constructor is invoked)
        start();
    }

    // this is the ONE method you must implement - this is the start point of the new Thread - the run() method
    @Override
    public void run(){

        // just demonstrate a thread doing something
        for(int i = 0; i < 10; i++){
            try {
                // sleep on each loop just to give it a delay so we can see the threads executing in parallel
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(getName() + " on loop #" + i);
        }
    }

}
