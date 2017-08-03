package interfaces;

/**
 * Created by Maheshwar Muttal on 5/17/2017.
 */
public interface Employee {



    default public void newDefaultMethod1() {
        System.out.println("Emp Default");
    }

    public static void staticMethod() {
        System.out.println("Emp static");
    }
}
