package org.levelup.bank.thread.counter;

import java.util.concurrent.atomic.AtomicInteger;

public class NonBlockingValueCounter {

    // java.util.concurrent.atomic
    // CAS - compare and set (compare and swap)

    // 1. read value v1(100)
    // 2. increment value -> 101
    // 3. cas (100, 101)
    //    read value v2(100)
    //    if (v1 == v2) -> set(101)
    //    else goto 1.

    // 3. cas(100, 101)
    //    read value v2(101)
    //    v1 !=v2
    // 1. read value v1(100)
    // 2. increment value -> 101
    // 3. cas (100, 101)
    //    3.1 read value v2(100)
    //    3.2 if (v1 == v2) -> set(101)
    //    3.3 else goto 1.

    private AtomicInteger counter = new AtomicInteger(0);

    public void increment() {
        counter.incrementAndGet();
    }

    public int getCounter() {
        return counter.getAcquire();
    }

}
