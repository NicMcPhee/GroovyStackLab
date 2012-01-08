package umm.softwaredesign.stacklab;

// WARNING - both these imports are unnecessary and a Bad Idea.  These may
// even be flagged by Eclipse or a plugin like PMD.
// Fix them, don't just ignore them.  If you don't understand why they're a
// Bad Thing, you definitely should ask.
import java.lang.Object;
import java.util.ArrayList;
import java.util.List;

import umm.softwaredesign.stacklab.StackIF;

/**
 * Implementation of the StackIF interface for a basic stack.
 * 
 * @author Nic McPhee, last changed by $Author: prodgera $ on $Date: 2006/01/25
 *         19:26:03 $
 * @version $Revision: 1.16 $
 */
public class Stack<T> implements StackIF<T> {
    private List<T> elements = new ArrayList<T>();

    /**
     * Construct an empty stack.
     */
    public Stack() {
        // Do nothing - the construction of the elements list in its declaration is all
        // we need.
    }

    /**
     * Makes a (shallow) copy of the given stack. "Shallow" here means that we
     * don't copy the items on the stack as well, so both stacks contain
     * references to the same items in the same order.
     * 
     * We need this for (at least) testing purposes, as we want to be able to
     * make copies of stacks before we manipulate them so we can compare the
     * stack at the end of a process to the stack we had at the beginning. There
     * are also no doubt non-testing contexts where cloning could be useful as
     * well.
     * 
     * @param stack
     *            the stack to copy
     */
    // You may get a warning that the argument to this constructor isn't being
    // used.  That will presumably go away when you implement this copy
    // constructor.
    public Stack(final Stack<T> stack) {
        throw new UnsupportedOperationException();
    }

    /**
     * Push the specified value onto the stack.
     * 
     * @param value
     *            the value to be pushed.
     */
    // WARNING - this parameter should be final so you can't reassign to it
    // in the body of the method. If it's not clear why you'd care, you should
    // definitely ask.
    // This may be flagged by Eclipse or a plugin.
    public void push(T value) {
        elements.add(value);
    }

    /**
     * Return the value on top of the stack. This does not change the stack in
     * any way. If the stack is empty a StackUnderflowException is thrown.
     * 
     * @return the top value on the stack
     */
    public T top() {
        // This should throw a StackUnderflowException if the stack is empty.
        throw new StackUnderflowException();
    }

    /**
     * Removes the top value from the stack. If the stack is empty a
     * StackUnderflowException is thrown.
     */
    public void pop() {
        // This should throw a StackUnderflowException if the stack is empty.
        throw new StackUnderflowException();
    }

    /**
     * Computes the size of the stack.
     * 
     * @return the number of elements on the stack
     */
    public int size() {
        return elements.size();
    }

    /**
     * Determines if a stack is empty.
     * 
     * @return true if the stack is empty, false otherwise
     */
    public boolean isEmpty() {
        return true;
    }

    /**
     * Determines if a stack is full.
     * 
     * If you use an appropriate Java library Container class to store the stack
     * elements, this should always return false.
     * 
     * @return true if the stack is full, false otherwise
     */
    public boolean isFull() {
        throw new UnsupportedOperationException();
    }

    /**
     * Generate a string representation of our stack. A stack containing
     * elements [x0, x1, x2, ..., xn] (where x0 is the bottom of the stack and
     * xn is the top) is represented by the string "Stack[s0, s1, s2, ..., sn]",
     * where the si are the string (printed) representations of the elements xi.
     * 
     * @return a string of this stack
     */
    @Override
    public String toString() {
        throw new UnsupportedOperationException();
    }

    /**
     * Determines if this stack contains the same elements as the other stack.
     *
     * @param other is another stack to check against this one
     * @return a boolean value telling if the stacks have the same elements
     */
    public boolean hasEqualElements(StackIF<T> other) {
        throw new UnsupportedOperationException();
    }
}
