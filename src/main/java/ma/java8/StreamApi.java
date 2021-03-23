package ma.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class StreamApi {


  public static void main(String[] args) {

    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    Function<Integer, Integer>   myFunction = (vaInteger) -> vaInteger*2;

    Function<Integer, String>   myFunction1 = (vaInteeger) ->"hello "+vaInteeger;

    //method reference
    Consumer<String>  consumer =  StreamApi::writeTofile;


    numbers.stream().map((vaInteeger) ->"hello "+vaInteeger).forEach(consumer);


    // pipeline

   // doSomething(numbers,myFunction);
   // doSomething(numbers,myFunction1);



  }

  // I use generic in this method to avoid Avoid raw types
  public static <T, R> void doSomething(List<T> numbers, Function<T, R> strategy){
    // chaque function f le stream == Higher order function
    numbers.stream().map(strategy).forEach(System.out::println);
  }



  static  void writeTofile(String arg){
    System.out.println("write to csv file ");
 }
}
