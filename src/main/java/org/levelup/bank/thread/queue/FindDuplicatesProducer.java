package org.levelup.bank.thread.queue;


import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.util.Random;

@RequiredArgsConstructor
public class FindDuplicatesProducer implements Runnable{

    private final Queue queue;

    @Override
    @SneakyThrows
    public void run() {
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            int originalId = random.nextInt(1000); // 0...1000
            int duplicateId = random.nextInt(1000) + 1000; // 1000...2000

            Duplicate duplicate = new Duplicate(originalId, duplicateId);
            Thread.sleep(300);

            System.out.println(Thread.currentThread().getName() + " нашел дубликат " + duplicate.toString());

            queue.putDuplicate(duplicate);
        }
    }
}
