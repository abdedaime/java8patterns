package ma.java8;

import java.util.Objects;
import java.util.function.Supplier;

public class SupplierExample {
 // supplier  == lazy evaluation  in java

  // optionnal and method reference

  public static void main(String[] args) {
    System.out.println("-----------------v1--------------");

  //  v1();

    System.out.println("-----------------v2--------------");

    v2();
  }


  public static void v1() {
    // v1
    Supplier<Integer> supplier = SupplierExample::expensiveOperation;
    int a = 5;
    if (a >= 5) {
      System.out.println(" v1 " + supplier.get());
      supplier.get();
    } else {
      System.out.println("condition 2");

    }
  }

  public static void v2() {
    // v2 to cache value
    Holder<Integer> supplier = new Holder<>(SupplierExample::expensiveOperation);
    int a = 5;
    if (a >= 5) {
      System.out.println(" v2 " + supplier.getValue());
      supplier.getValue();
    } else {
      System.out.println("condition 2");

    }
  }


  public static int expensiveOperation() {
    System.out.println("expensiveOperation");
    return 6;
  }

  static class Holder<T> {

    Supplier<T> supplier;
    private T value;

    Holder(Supplier<T> supplier) {
      Objects.requireNonNull(supplier);
      this.supplier = supplier;
    }

    public T getValue() {
      if (Objects.isNull(value)) {
        value = supplier.get();
      }
      return value;
    }


  }
}
