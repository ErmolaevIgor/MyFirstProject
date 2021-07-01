package org.levelup.bank.thread.counter;

import lombok.SneakyThrows;

public class App {

    @SneakyThrows
    public static void main(String[] args) {

        ValueCounter valueCounter = new ValueCounter();

        Thread t1 = new Thread(new CounterWorker(valueCounter));
        Thread t2 = new Thread(new CounterWorker(valueCounter));
        Thread t3 = new Thread(new CounterWorker(valueCounter));

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("Total count: " + valueCounter.getCounter());
    }

}
