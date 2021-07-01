package org.levelup.bank.thread.queue;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@RequiredArgsConstructor
public class DuplicateConsumer implements Runnable{

    private final Queue queue;

    @Override
    @SneakyThrows
    public void run() {
        boolean isInterrupted = false;
        while (!isInterrupted) {
            try {
                Duplicate duplicate = queue.takeDuplicate();
                System.out.println(Thread.currentThread().getName() + " обрабатывает дубликат " + duplicate.toString());

                Thread.sleep(200);
                isInterrupted = Thread.currentThread().isInterrupted();
            } catch (InterruptedException exc) {
                System.out.println("Поток был прерван во время сна или ожидания:)");
                isInterrupted = true;
            }
        }
        System.out.println("Поток " + Thread.currentThread().getName() + " завершен");
    }
}
