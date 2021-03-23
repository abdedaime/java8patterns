package ma.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;


public class FpVSPoo {

  private static List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);


  public static void main(String[] args) {

    // System.out.println(getEvenJava8());

    // solution 1 in java 7

    MyThread runnable = new MyThread();

    Thread th = new Thread(runnable);
    th.start();

    // before java 8 == anonymous class . solution 2
    // anonymous class  produces new file class in compilation
    // the compilator uses invokeDynamic to create new file .class
    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.println("inside runnable ");
      }
    });

    thread.start();

    Thread thread1 = new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.println("inside runnable ");
      }
    });

    thread1.start();

    Thread threadx = new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.println("inside runnable ");
      }
    });

    threadx.start();

    /// java 8   == Runnable is a FunctionalInterface = anonymous function  = function without name

    Runnable runnableLambda = () -> {
      System.out.println("inside runnable ");
    };

    // plus simple == it can replace anonymous class like objects 'thread or thread1'
    Runnable runnableLambda_simple = () -> System.out.println("inside runnable ");

    thread = new Thread(runnableLambda_simple);

    // plus simple

    thread = new Thread(() -> System.out.println("inside runnable "));


    // custom functional interface
    MyFunctionalInterface myFunctionalInterface = (a, b) -> System.out
        .println("myFunctionalInterface runnable " + a + "b" + b);

    myFunctionalInterface.show(5, 10);

    Consumer<Integer> consumer = (arg) -> System.out.println("consumer accept " + arg);
    consumer.accept(5);

    Function<Integer, String> mapper = (val) -> String.valueOf(val);

    System.out.println(mapper.apply(10));
    Predicate<Integer> predicate = (val) -> val % 2 == 0;

    System.out.println(predicate.test(5));

    //

    Supplier<Integer> supplier = () -> 10;

    System.out.println(supplier.get());

  }

  //


  // before java 8
  // style imperative
  private static List<Integer> getEven() {
    // des instructions  : muttable
    List<Integer> evenNumbers = new ArrayList<>();
    for (Integer number : numbers) {
      if (number % 2 == 0) {
        evenNumbers.add(number);
      }
    }
    return evenNumbers;
  }

  // after java 8
  // style declarative
  private static List<Integer> getEvenJava8() {
    //pipeline
    // expression  immutable
    return numbers.stream().filter(number -> number % 2 == 0)
        .collect(Collectors.toList());
  }


  public void myFunction(MyFunctionalInterface myFunctionalInterface, int a, int b) {
    myFunctionalInterface.show(a, b);
  }

  // FunctionalInterface  = SAM =SINGLE ABSTRACT METHOD

  @FunctionalInterface
  interface MyFunctionalInterface {

    void show(int a, int b);
  }
}


