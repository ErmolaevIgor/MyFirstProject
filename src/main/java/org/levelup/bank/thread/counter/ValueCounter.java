package org.levelup.bank.thread.counter;

public class ValueCounter {

    private int counter;

    // t1, t2, t3
    // t1 -> block increment(), t2, t3 - ждут пока t1 не выполнит метод increment
    public synchronized void increment() {
        counter++;
    }

    // acquire lock
    // release lock
    public int getCounter() {
        synchronized (this) {
            return counter;
        }
    }
    // synchronized method
    // synchronized block - synchronized (this) {}
}
