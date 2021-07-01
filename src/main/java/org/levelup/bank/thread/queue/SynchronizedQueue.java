package org.levelup.bank.thread.queue;

import lombok.SneakyThrows;

import java.util.LinkedList;

public class SynchronizedQueue implements Queue{

    private final Object empty = new Object(); // mutex for empty queue
    private final Object full = new Object();  // mutex for full queue

    private final LinkedList<Duplicate> duplicates;
    private final int maxSize;

    public SynchronizedQueue() {
        this.duplicates = new LinkedList<>();
        this.maxSize = 10;
    }

    @Override
    @SneakyThrows
    public void putDuplicate(Duplicate duplicate) {
        synchronized (full) {
            while (duplicates.size() == maxSize) {
                // очередь заполнена (нет мест)
                // нужно поток перевести в состояние ожидания
                full.wait();
            }
        }

        synchronized (empty) {
            duplicates.offer(duplicate); // add last
            empty.notifyAll();
        }
    }

    @Override
    public Duplicate takeDuplicate() throws InterruptedException{
        synchronized (empty) {
            while (duplicates.isEmpty()) {
                empty.wait();
            }
        }

        synchronized (full) {
            // Thread.sleep(1000);
            Duplicate duplicate = duplicates.poll(); // get first
            full.notifyAll();
            return duplicate;
        }
    }
}
