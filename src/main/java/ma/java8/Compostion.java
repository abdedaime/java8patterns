package ma.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Compostion {

  public static void main(String[] args) {

    List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

    List<String> names = Arrays.asList("HICHAM", "HMOGHITE", "ABDO");

    List<Person> personList = Arrays.asList(new Person("Med", 20),
        new Person("AMINE", 20),
        new Person("HATIM", 20),
        new Person("ABDO", 30),
        new Person("MOGHITE", 30),
        new Person("HICHAM", 50),
        new Person("AHCRAF", 60)

    );

    // solution 1
    numbers.stream().map(value -> value + 1).map(value -> value * 2).map(value -> value - 1)
        .forEach(
            System.out::println);

    System.out.println("----Solution 2-----");

    numbers.stream().map(plusOne()).map(multiplyTwo()).map(minusOne()).forEach(System.out::println);

    System.out.println("----Solution 3-----");

    numbers.stream().map(compositeFunction()).forEach(System.out::println);

    String csvNames = names.stream().filter(s -> s.startsWith("H")).map(s -> s.toLowerCase())
        .collect(Collectors.joining(","));

    System.out.println(csvNames);

    Map<Integer, List<Person>> personByAge = personList.stream()
        .collect(Collectors.groupingBy(o -> o.age));

    personByAge.forEach((integer, people) -> {
      System.out.println(people);
    });

    numbers.stream()
        .reduce((value, accumaltorValue) -> accumaltorValue + value).ifPresent(System.out::println);

    numbers.stream()
        .reduce(Integer::sum).ifPresent(System.out::println);

    numbers.stream().mapToDouble(Integer::doubleValue).average().ifPresent(System.out::println);

    numbers.stream().limit(2).forEach(System.out::println);
    numbers.stream().skip(1).forEach(System.out::println);


  }

  private static Function<Integer, Integer> compositeFunction() {

    return plusOne().andThen(multiplyTwo()).andThen(minusOne());

  }

  // composition

  private static Function<Integer, Integer> plusOne() {
    return value -> value + 1;
  }

  private static Function<Integer, Integer> multiplyTwo() {
    return value -> value * 2;
  }

  private static Function<Integer, Integer> minusOne() {
    return value -> value - 1;
  }

  static class Person {

    String name;
    int age;

    Person(String name, int age) {
      this.age = age;
      this.name = name;
    }

    @Override
    public String toString() {
      return "age= " + age + " name = " + name;
    }
  }

}
