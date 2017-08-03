package oops.test;

/**
 * Created by Maheshwar Muttal on 6/17/2017.
 */
public class SynchronizedTest {

    private String name;

    public SynchronizedTest(String name) {
        this.name = name;
    }

    public static synchronized void staticSyncMethod() {
        System.out.print("SM1 ");
        System.out.print("SM2 ");
    }

    public synchronized void syncMethod() {
        System.out.print(name + "M1 ");
        System.out.print(name + "M2 ");
    }

    public static void main(String[] args) {

        String str = "hello";
        str.concat("world");
        System.out.println(str);

        /*SynchronizedTest o1 = new SynchronizedTest("O1");
        Thread t1 = new Thread() {
            @Override
            public void run() {
                o1.syncMethod();
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                staticSyncMethod();
            }
        };

        Thread t3 = new Thread() {
            @Override
            public void run() {
                staticSyncMethod();
            }
        };

        t1.start();
        t2.start();
        t3.start();
        t1.start();
        t2.start();
        t3.start();*/
    }
}
