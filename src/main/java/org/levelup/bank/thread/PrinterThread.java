package org.levelup.bank.thread;

import lombok.SneakyThrows;

public class PrinterThread extends Thread{


    @Override
    @SneakyThrows
    public void run() { // содержит код, который выполняется в отдельном потоке
        for (int i = 0; i < 10; i++) {
            Thread.sleep(400);
            System.out.println(getName() + ": " + i);
        }
    } // когда метод run завершен - завершен поток
}
