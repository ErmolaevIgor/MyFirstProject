package org.levelup.bank.reflection.annotation;

public class RandomApp {

    public static void main(String[] args) {
        RandomIntAnnotationProcessor processor = new RandomIntAnnotationProcessor();
        User user = (User) processor.createObjectByClassName(User.class.getName());
        System.out.println(user);
    }

}
