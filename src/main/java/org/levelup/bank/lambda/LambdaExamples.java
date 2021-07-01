package org.levelup.bank.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LambdaExamples {

    public static void main(String[] args) {

        // public class WeightComparator implements Comparator<Phone>
        //      public int compare(Phone o1, Phone o2) ( return Double.compare(...); }
        // }
        // Comparator<Phone> weightComparator = new WeightComparator();

        Comparator<Phone> weightComparator = new Comparator<Phone>() {
            @Override
            public int compare(Phone o1, Phone o2) {
                return Double.compare(o1.getWeight(), o2.getWeight());
            }
        };

        int maxLength = 5;
        Predicate<Phone> maxLengthPredicate = new Predicate<Phone>() {
            @Override
            public boolean test(Phone phone) {
                return phone.getBrand().length() <= maxLength;
            }
        };

        // 3 parts of lambda
        // - arguments
        // - delimiter ( -> )
        // - method body
        Predicate<Phone> maxLengthLambdaPredicate = phone -> phone.getBrand().length() <= maxLength;
        Predicate<Phone> maxLengthLambdaPredicate2 = (p) -> { // одно и тоже, что и выше
            return p.getBrand().length() <= maxLength;
        };

        Comparator<Phone> weightComparator2 = (p1, p2) -> Double.compare(p1.getWeight(), p2.getWeight()); // только теперь в одну строчку

        List<Phone> list = new ArrayList<>();
        list.add(new Phone("Xiaomi", "Redmi", 134));
        list.add(new Phone("Xiaomi", "Mi", 164));
        list.add(new Phone("Samsung", "S20", 210));
        list.add(new Phone("Samsung", "Note 20", 250));
        list.add(new Phone("IPhone", "12 Pro Max", 189));
        list.add(new Phone("Huawei", "8 Max", 195));

        List<Phone> filteredList = list.stream() // Stream<Phone> --- лучший вариант
                .filter(phone -> phone.getBrand().length() <= maxLength)
                .collect(Collectors.toList());

        List<Phone> filteredWithoutStream = new ArrayList<>(); // одно и тоже, что и выше
        for (Phone phone : list) {
            if (phone.getBrand().length() <= maxLength) {
                filteredWithoutStream.add(phone);
            }
        }

        // Stream<?>
        // IntStream
        // LongStream
        // DoubleStream
        List<Double> weights = list.stream() // Stream<Phone>
                .map(phone -> phone.getWeight()) // Stream<Double>
                .filter(weight -> weight >= 200)
                .collect(Collectors.toList());

        List<Double> weights2 = new ArrayList<>(); // одно и тоже
        for (Phone p : list) {
            if (p.getWeight() >= 200) {
                weights2.add(p.getWeight());
            }
        }

        OptionalDouble optional = list.stream()
//                .mapToDouble(p -> p.getWeight())
                .mapToDouble(Phone::getWeight)
                .max();

        // если optional содержит null (== Optional.EMPTY), то тогда orElse метод вернет 0 ~~ getOrDefault(0)
        // если optional хранит существующий объект (не null), то тогда вернется его значение (его ссылка, к примеру)
        double maxWeight = optional.orElse(0);

        // Comparator#compare(p1, p2)
        // если compare вернул число меньше 0, то p1 < p2
        // если compare вернул число равное 0, то p1 = p2
        // если compare вернул число больше 0, то p1 > p2
        list.stream()
                .sorted((p1, p2) -> -p1.getBrand().compareTo(p2.getBrand()))
                .collect(Collectors.toList());

        for (Phone phone : list) {
            System.out.println(phone);
        }
        list.forEach(phone -> System.out.println());
        list.forEach(System.out::println); // method reference ~~ (phone -> System.out.println(phone))

    }

}
