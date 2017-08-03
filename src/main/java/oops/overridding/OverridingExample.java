package oops.overridding;

import oops.overloading.OverloadingExample;

public class OverridingExample extends OverloadingExample {

    @Override
    public String add(Object s) {
        return null;
    }

    @Override
    public String add(String s) {
        return null;
    }

    @Override
    public int add(int i) {
        return 0;
    }

     //varargs............

    @Override
    public void add(float i) {

    }

}
