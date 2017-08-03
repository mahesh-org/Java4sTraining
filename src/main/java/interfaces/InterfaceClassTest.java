package interfaces;

/**
 * Created by Maheshwar Muttal on 5/17/2017.
 */
public class InterfaceClassTest implements Employee,oldInterface {

    int i;
    int b;
    public static void main(String[] args) {
        InterfaceClassTest test = new InterfaceClassTest();

        test.newDefaultMethod();
        oldInterface.staticMethod();
    }

    @Override
    public void newDefaultMethod() {
        System.out.println("");
        //Employee.super.newDefaultMethod1();
    }

    public void newDefaultMethodSD() {
        i = 10;
        b = 10;
        System.out.println("");
        Employee.super.newDefaultMethod1();
    }
}


