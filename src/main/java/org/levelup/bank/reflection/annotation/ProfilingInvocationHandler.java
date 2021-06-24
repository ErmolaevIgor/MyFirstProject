package org.levelup.bank.reflection.annotation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProfilingInvocationHandler implements InvocationHandler {

    private Object original;

    public ProfilingInvocationHandler(Object original) {
        this.original = original;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Method originalMethod = original.getClass().getDeclaredMethod(method.getName(), method.getParameterTypes());
        if (originalMethod.getAnnotation(Profiling.class) != null) {
            long start = System.nanoTime();
            Object result = method.invoke(original, args); // вызов оригинального метода (из оригинального/реального объекта)
            System.out.println("Execution time: " + (System.nanoTime() - start));
            return result;
        }
        return method.invoke(original, args);
    }

}
