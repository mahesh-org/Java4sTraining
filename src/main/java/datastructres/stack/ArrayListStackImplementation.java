package datastructres.stack;

import java.util.ArrayList;
import java.util.Collection;

/**
 * A faster, smaller stack implementation. ArrayListStack is final and unsynchronized (the JDK's
 * methods are synchronized). In addition you can set the initial capacity if you want via the
 * ArrayListStack(int) constructor.
 *
 * @author Mahesh Muttal
 * @param <T>
 */
public class ArrayListStackImplementation<T> extends ArrayList<T>{
    private static final long serialVersionUID = 1L;

    /**
     * Construct.
     *
     * @param initialCapacity
     *            Initial capacity of the stack
     */
    public ArrayListStackImplementation(final int initialCapacity)
    {
        super(initialCapacity);
    }

    /**
     * Construct.
     */
    public ArrayListStackImplementation()
    {
        this(10);
    }

    /**
     * Construct.
     *
     * @param collection
     *            The collection to add
     */
    public ArrayListStackImplementation(final Collection<T> collection)
    {
        super(collection);
    }

    /**
     * Pushes an item onto the top of this stack.
     *
     * @param item
     *            the item to be pushed onto this stack.
     */
    public final void push(final T item)
    {
        add(item);
    }

    /**
     * Removes the object at the top of this stack and returns that object.
     *
     * @return The object at the top of this stack
     * @exception ArrayListStackImplementation
     *                If this stack is empty.
     */
    public final T pop() throws Exception {
        final T top = peek();
        remove(size() - 1);
        return top;
    }

    /**
     * Looks at the object at the top of this stack without removing it.
     *
     * @return The object at the top of this stack
     * @exception ArrayListStackImplementation
     *                If this stack is empty.
     */
    public final T peek() throws Exception {
        int size = size();
        if (size == 0)
        {
            throw new Exception("Array list is empty");
        }
        return get(size - 1);
    }

    /**
     * Tests if this stack is empty.
     *
     * @return <code>true if and only if this stack contains no items; <code>false
     *         otherwise.
     */
    public final boolean empty()
    {
        return size() == 0;
    }

    /**
     * Returns the 1-based position where an object is on this stack. If the object <tt>o</tt>
     * occurs as an item in this stack, this method returns the distance from the top of the stack
     * of the occurrence nearest the top of the stack; the topmost item on the stack is considered
     * to be at distance <tt>1</tt>. The <tt>equals</tt> method is used to compare <tt>o</tt>
     * to the items in this stack.
     *
     * @param o
     *            the desired object.
     * @return the 1-based position from the top of the stack where the object is located; the
     *         return value <code>-1 indicates that the object is not on the stack.
     */
    public final int search(final T o)
    {
        int i = lastIndexOf(o);
        if (i >= 0)
        {
            return size() - i;
        }
        return -1;
    }
}
