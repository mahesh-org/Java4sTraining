package oops.overloading;

/**
 * Created by Maheshwar Muttal on 5/17/2017.
 */
public class OverloadingExample {

    public int add(int i){
        return 0;
    }
    public void add(float i) { }
    public void add(double i) { }
    public Object add(Object i){
        System.out.println("Over loading Object ");
        return null;
    }

    public Object add(String i){
        System.out.println("Over loading String");
        return null;
    }
    //public abstract void add(float i);

    ///This is illegal, will not work
    //public int add(int i){    }

    public static void main(String[] args) {
        OverloadingExample test = new OverloadingExample();
        test.add("");
    }

}
