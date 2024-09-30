

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PuttingIntoPractice {

    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //1. Найти все транзакции за 2011 год и отсортировать их по сумме (от меньшей к большей).
        System.out.println("Задача 1. Найти все транзакции за 2011 год и отсортировать их по сумме");
        transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .forEach(System.out::println);


        // 2. Вывести список неповторяющихся городов, в которых работают трейдеры.
        System.out.println("Задача 2. Вывести список неповторяющихся городов, в которых работают трейдеры");
        transactions.stream()
                .map(e -> e.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);
        //3. Найти всех трейдеров из Кембриджа и отсортировать их по именам.


        System.out.println("Задача 3. Найти всех трейдеров из Кембриджа и отсортировать их по именам");
        transactions.stream()
                .map(Transaction::getTrader)
                .filter(e -> e.getCity().equals("Cambridge"))
                .sorted((e1, e2) -> e1.getName().compareTo(e2.getName()))
                .forEach(System.out::println);
        //4.Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном порядке


        System.out.println("Задача 4. Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном порядке");
        transactions.stream()
                .map(e -> e.getTrader().getName())
                .distinct()
                .sorted()
                .forEach(System.out::println);
        //5. Выяснить, существует ли хоть один трейдер из Милана.


        System.out.println("Задача 5. Выяснить, существует ли хоть один трейдер из Милана.");
        transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Milan"))
                .limit(1)
                .forEach(System.out::println);


        //6. Вывести суммы всех транзакций трейдеров из Кембриджа.
        System.out.println("Задача 6. Вывести суммы всех транзакций трейдеров из Кембриджа.");
        Integer i = transactions.stream()
                .filter(e1 -> e1.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .reduce(0, (a, b) -> a + b);
                        System.out.println(i);


        //7. Какова максимальная сумма среди всех транзакций?
        System.out.println("Задача 7. Какова максимальная сумма среди всех транзакций?");
        Integer i2 = transactions.stream()
                .map(e -> e.getValue())
                .max(Integer::compareTo).get();
                        System.out.println(i2);


        //8. Найти транзакцию с минимальной суммой.
        System.out.println("Задача 8. Найти транзакцию с минимальной суммой.");
        transactions.stream()
                .min(Comparator.comparingInt(Transaction::getValue))
                .ifPresent(System.out::println);
    }
}