package Transactions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class TransactionsMain {

    public static void main(String[] args) {

        Trader raoul = new Trader("Raoul", "cambridge");
        Trader mario = new Trader("Mario","milan");
        Trader alan = new Trader("Alan","cambridge");
        Trader brian = new Trader("Brian","cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        System.out.println("---------transactions in the year 2011 and sort them by value------------");
        transactions
                .stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .forEach(System.out::println);

        System.out.println();

        System.out.println("-----------unique cities where the traders work--------------");

        transactions
                .stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);
        System.out.println();

        System.out.println("--------------- all traders from Cambridge and sort them by name---------");

       // List<Trader> traders =
                transactions
                .stream()
                .map(Transaction::getTrader)
                .filter(t -> t.getCity().equalsIgnoreCase("cambridge"))
                .distinct()
                .sorted(comparing(Trader::getName))
                        .forEach(System.out::println);
            //    .collect(Collectors.toList());

      //  System.out.println(traders);
        System.out.println();

        System.out.println("------------- all traders’ names sorted alphabetically----------------");
        String sortedNames =
                transactions
                .stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (n1, n2) -> n1 + n2);

        System.out.println(sortedNames);

        String traders =
                transactions
                .stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining(","));
        System.out.println(traders);
        System.out.println();

        System.out.println("----------any traders based in Milan-----------");
        boolean anyMatch =
                transactions
                .stream()
                .anyMatch(trader -> trader.getTrader().getCity().equalsIgnoreCase("milan"));
        System.out.println(anyMatch);
        System.out.println();

        System.out.println("---------all transactions’ values from the traders living in Cambridge--------------");

        transactions
                .stream()
                .filter(t -> t.getTrader().getCity().equalsIgnoreCase("cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        System.out.println();
        System.out.println("--------------------the highest value of all the transactions------------------");

        Integer max =
                transactions
                .stream()
                .map(Transaction::getValue)
                .reduce(Integer::max)
                .get();
        System.out.println(max);

        System.out.println("--------------------the smallest value of all the transactions------------------");
        Integer min =
                transactions
                .stream()
                .map(Transaction::getValue)
                .reduce(Integer::min)
                .get();
        System.out.println(min);

        Transaction smallestTransaction =
                transactions
                .stream()
                .reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2).get();
        System.out.println(smallestTransaction);

        Transaction minTransaction =
                transactions
                .stream()
                .min(comparing(Transaction::getValue))
                .get();
        System.out.println(minTransaction);


        boolean b = transactions.removeIf(t -> Character.isDigit(t.getTrader().getCity().charAt(0)));
        System.out.println(b);

        transactions
                .stream()
                .map(t -> Character.toUpperCase(t.getTrader().getCity().charAt(0)) + t.getTrader().getCity().substring(1))
               // .collect(Collectors.toList())
                .forEach(System.out::println);


    }
}
