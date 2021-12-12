package org.levelup.bank.thread.queue;

import lombok.SneakyThrows;

public class App {

    @SneakyThrows
    public static void main(String[] args) {
        Queue queue = new ReentrantLockQueue();

        FindDuplicatesProducer producer1 = new FindDuplicatesProducer(queue);
        FindDuplicatesProducer producer2 = new FindDuplicatesProducer(queue);
        new Thread(producer1, "producer1").start();
        new Thread(producer2, "producer2").start();

        DuplicateConsumer consumer1 = new DuplicateConsumer(queue);
        Thread ct1 = new Thread(consumer1, "consumer1");
        ct1.start();

        Thread.sleep(5000);
        ct1.interrupt();
        Thread.sleep(1000);
        System.out.println();

        DuplicateConsumer consumer2 = new DuplicateConsumer(queue);
        Thread ct2 = new Thread(consumer2, "consumer2");
        ct2.start();

        // t.interrupt()
        // boolean t.isInterrupted()
        // boolean Thread.Interrupted()

        // ct1.stop(); - kill -9 <pid> / task kill -9 <pid>
    }

}
