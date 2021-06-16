package org.levelup.bank.reflection.annotation;

public class ConsolePrinter implements Printer {

    @Override
    @Profiling
    public void printInformation() {
        // получить текущее время
        System.out.println("Hello, I'm printing some information...");
        // посчитать разницу между текущим временем и временем начала метода - (end - start)

    }
}
