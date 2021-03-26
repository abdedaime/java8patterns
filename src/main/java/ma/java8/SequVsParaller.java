package ma.java8;

import java.util.Arrays;
import java.util.List;

public class SequVsParaller {
  public static void main(String[] args) {

    // sequentiel

    List<String> names = Arrays.asList("HICHAM", "HMOGHITE", "ABDO","HAMID","HAM");

    for(String name : names){
      if(name.startsWith("H"))
      System.out.println(name);
    }


    System.out.println("-------------");




    // Sequentiel

    names.stream().filter(s -> s.startsWith("H")).forEach(s -> {


      System.out.println("thread name :"+Thread.currentThread().getName()+"------------"+s);

    });


    System.out.println("-------------");

    names.parallelStream().filter(s -> s.startsWith("H")).forEachOrdered(s -> {


      System.out.println("thread name :"+Thread.currentThread().getName()+"------------"+s);

    });


  }
}
