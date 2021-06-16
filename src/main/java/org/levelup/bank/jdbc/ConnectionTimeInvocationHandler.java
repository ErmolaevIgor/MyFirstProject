package org.levelup.bank.jdbc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ConnectionTimeInvocationHandler implements InvocationHandler {

    private Object original;

    public ConnectionTimeInvocationHandler(Object original) {
        this.original = original;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.nanoTime();

        Object result = method.invoke(original, args);
        System.out.println("Connection time: " + (System.nanoTime() - start) + " nanoSec");
        return result;
    }

}
