package org.levelup.bank.reflection;

import lombok.SneakyThrows;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionApp {

    @SneakyThrows
    public static void main(String[] args) {

        // 1 var (using object)
        Phone phone = new Phone(8, "Sony Xperia");
        Class<?> phoneClass = phone.getClass();

        // 2 var (using class literal)
        Class<?> classOfPhone = Phone.class;

        String className = classOfPhone.getName(); // полное имя класса (имя пакета + имя класса)
        System.out.println("Class name: " + className);

        // getFields();
        // getField(StringName);
        // getDeclaredFields();
        // getDeclaredField(StringName);
        Field[] publicFields = classOfPhone.getFields();
        System.out.println("List of public fields:");
        for (Field pf : publicFields) {
            System.out.println(pf.getType().getName() + " " + pf.getName());
        }

        System.out.println();
        System.out.println("List of all fields:");
        Field[] fields = classOfPhone.getDeclaredFields();
        for (Field f : fields) {
            System.out.println(f.getType().getName() + " " + f.getName());
        }

        Field ramField = classOfPhone.getDeclaredField("ram");
        ramField.setAccessible(true);
        ramField.set(phone, 16);

        int ram = (int) ramField.get(phone); // int ram = phone.ram;
        System.out.println("Ram: " + ram);

        Method method = classOfPhone.getDeclaredMethod("printPhone");
        method.setAccessible(true);
        method.invoke(phone);

        Constructor<?> allArgsConstructor = classOfPhone
                .getDeclaredConstructor(String.class, String.class, int.class);
        allArgsConstructor.setAccessible(true);
        Phone samsung = (Phone) allArgsConstructor.newInstance("Samsung", "Galaxy S21", 16);
        method.invoke(samsung);
    }

}
