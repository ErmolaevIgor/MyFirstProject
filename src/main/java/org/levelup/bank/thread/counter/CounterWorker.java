package org.levelup.bank.thread.counter;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@RequiredArgsConstructor
public class CounterWorker implements Runnable{

    private final ValueCounter valueCounter;

    @Override
    @SneakyThrows
    public void run() {
        for (int i = 0; i < 30; i++) {
            Thread.sleep(100);
            valueCounter.increment();
        }

    }
}
