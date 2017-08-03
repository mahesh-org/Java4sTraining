package thread.deadlock;

/**
 * http://www.journaldev.com/1058/deadlock-in-java-example
 *
 * Deadlock in java is a programming situation where two or more threads are blocked forever.
 *
 * Ask for a thread DUMP and look for BLOCKED state and then the resources it’s waiting to lock.
 * Every resource has a unique ID using which we can find which thread is already holding the lock on the object. For example Thread “t3” is waiting to lock 0x000000013df2f658 but it’s already locked by thread “t1”.
 * Solution :
 *      Avoid Nested Locks:
 *      Lock Only What is Required
 *      Avoid waiting indefinitely
 */
public class ThreadDeadlock {

    public static void main(String[] args) throws InterruptedException {
        Object obj1 = new Object();
        Object obj2 = new Object();
        Object obj3 = new Object();

        Thread t1 = new Thread(new SyncThread(obj1, obj2), "t1");
        Thread t2 = new Thread(new SyncThread(obj2, obj3), "t2");
        Thread t3 = new Thread(new SyncThread(obj3, obj1), "t3");

        t1.start();
        Thread.sleep(5000);
        t2.start();
        Thread.sleep(50000);
        t3.start();
    }
}

class SyncThread implements Runnable {

    private Object obj1;
    private Object obj2;

    public SyncThread(Object obj1, Object obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();

        System.out.println(name + " acquiring a lock on " + obj1);
        synchronized (obj1) {
            System.out.println(name + " acquired a lock on " + obj1);
            work();
            System.out.println(name + " acquiring a lock on " + obj2);
            synchronized (obj2) {
                System.out.println(name + " acquired a lock on " + obj2);
                work();
            }
            System.out.println(name + " released lock on " + obj2);
        }
        System.out.println(name + " released lock on " + obj1);
        System.out.println("Finished execution......");
    }

    private void work() {
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
