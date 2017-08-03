package interfaces;

/**
 * Created by Maheshwar Muttal on 5/17/2017.
 */
public interface oldInterface  {

    int i = 20;
    int b = 10;

    default public void newDefaultMethod() {
        System.out.println(i == 10);

        System.out.println("oldInterface:::Emp Default");
    }

    default public void newDefaultMethodArg(int abc) {
        System.out.println(abc = 10);

        System.out.println("oldInterface:::Emp Default");
    }

    public static void staticMethod() {
        System.out.println("oldInterface:::Emp static");
    }
}
