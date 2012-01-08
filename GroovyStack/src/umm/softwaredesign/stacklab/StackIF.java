package umm.softwaredesign.stacklab;

/**
 * Interface for a basic stack class. Implementations of this interface should
 * also implement a copy contructor.  If, for example, class
 * <CODE>Stack</CODE> implements this interface, it should provide a
 * constructor with the signature <CODE>public Stack(Stack stack)</CODE> which
 * can be used to make copies of stacks. One could use <CODE>clone()</CODE> to
 * accomplish the same thing, but there are numerous problems with
 * <CODE>clone()</CODE> that make this approach preferable.  See Item 10 of
 * <CITE>Effective Java</CITE> for more on this.
 * 
 * @param <T> the type of the elements in the stack
 *
 * @author Nic McPhee, last changed by $Author: mcphee $ on $Date: 2003/08/24
 *         02:40:57 $
 * @version $Revision: 1.11 $
 */
public interface StackIF<T> {
    /**
     * Determines if a stack is empty.
     *
     * @return true if the stack is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Determines if a stack is full. If you use an appropriate Java library
     * Container class to store the stack elements, this should always return
     * false.
     *
     * @return true if the stack is full, false otherwise
     */
    boolean isFull();

    /**
     * Removes the top value from the stack.  If the stack is empty a
     * StackUnderflowException is thrown.
     */
    void pop();

    /**
     * Push the specified value onto the stack.
     *
     * @param value the value to be pushed.
     */
    void push(T value);

    /**
     * Computes the size of the stack.
     *
     * @return the number of elements on the stack
     */
    int size();

    /**
     * Determines if this stack contains the same elements as the other stack.
     *
     * @param other is another stack to check against this one
     * @return a boolean value telling if the stacks have the same elements
     */
    boolean hasEqualElements(StackIF<T> other);
    
    /**
     * Generate a string representation of our stack.  A stack containing
     * elements [x0, x1, x2, ..., xn] (where x0 is the bottom of the stack and
     * x1 is the top) is represented by the string "Stack[s0, s1, s2, ...,
     * sn]", where the si are the string (printed) representations of the
     * elements xi.
     *
     * @return a string of this stack
     */
    String toString();

    /**
     * Return the value on top of the stack.  This does not change the stack in
     * any way.  If the stack is empty a StackUnderflowException is thrown.
     *
     * @return the top value on the stack
     */
    T top();
}
