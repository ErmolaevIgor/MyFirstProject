package org.levelup.bank.thread;

import lombok.SneakyThrows;

public class ThreadExamples {

    @SneakyThrows
    public static void main(String[] args) {

        // Thread - main
        Thread printer = new PrinterThread(); // сощдали поток
        // printer.run(); - выполнить метод run в рамках текущего потока
//        printer.setDaemon(true);
        printer.start(); // запускает выполнение в рамках потока printer

        printer.join(); // поток, в котором вызвали метод t.join(), будет ждать пока поток t не завершится

        Thread.sleep(3000);
        System.out.println("Поток main завершен");
    }
}
