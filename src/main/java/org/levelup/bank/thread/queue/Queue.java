package org.levelup.bank.thread.queue;

public interface Queue {

    void putDuplicate(Duplicate duplicate) throws InterruptedException;

    Duplicate takeDuplicate() throws InterruptedException;

}
