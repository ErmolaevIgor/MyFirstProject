package org.levelup.bank.reflection.annotation;

import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.Random;

public class RandomIntAnnotationProcessor {

    @SneakyThrows
    public Object createObjectByClassName(String className) {
        // "org.levelUp.bank.reflection.User"
        Class<?> objectClass = Class.forName(className); // загружает класс в память (если до этого класс не был загружен) и возвращает объект класса Class

        Object instance = objectClass.getDeclaredConstructor().newInstance(); // работает только если у класса есть публичный конструктор без параметров

        Field[] fields = objectClass.getDeclaredFields(); // список всех полей класса
        for (Field field : fields) {
            RandomInt annotation = field.getAnnotation(RandomInt.class); // получение объекта RandomInt, который стоит над полем
            if (annotation != null) { // это означает, что аннотация стоит над полем
                // Integer.MIN_VALUE - Integer.MAX_VALUE

                // для поля age мы получим значения 0 и Integer.MAX_VALUE
                int min = annotation.min();
                int max = annotation.max();

                Random r = new Random();
                int randomInt = r.nextInt(max - min) + min; // генерация псевдослучайных чисел в диапозоне [min, max)

                field.setAccessible(true);
                field.set(instance, randomInt); // установили значение в поле с аннотацией RandomInt
            }
        }

        return instance;
    }

}
