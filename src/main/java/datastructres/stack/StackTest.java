package datastructres.stack;

/**
 * Created by Maheshwar Muttal on 3/13/2017.
 */
public class StackTest {
    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(10);
        stack.push(20);
        stack.display();
        System.out.println("pop: " + stack.pop());
        stack.display();
        System.out.println(stack.pop());
        System.out.println(stack.pop());


    }
}
