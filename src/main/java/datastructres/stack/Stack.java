package datastructres.stack;

/**
 * LIFO
 */
public class Stack {

    Object[] elements;
    int top;
    int stackSize;

    public Stack() {
        stackSize = 1;
        top = -1;
        elements = new Object[stackSize];
    }

    public void push(int item) {
        if(top >= stackSize-1) {
            reSize();
        }
        elements[++top] = item;
    }

    public Object pop() {
        if(top < 0) {
            return null;
        } else {
            return elements[top--];
        }
    }

    public void display() {
        String str = "";
        for(int i = 0; i <= top; i++)
            str = str + elements[i] + ", ";

        System.out.println(str);
    }

    private void reSize() {
        Object[] temp = elements;
        stackSize = stackSize * 2;
        elements = new Object[stackSize];

        for (int i=0; i<=top; i++) {
            elements[i] = temp[i];
        }
    }
}
