package org.levelup.bank.thread.queue;

public interface Queue {

    void putDuplicate(Duplicate duplicate);

    Duplicate takeDuplicate() throws InterruptedException;

}
