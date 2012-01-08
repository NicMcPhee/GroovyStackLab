package umm.softwaredesign.stacklab;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

/**
 * JUnit tests for the <code>Stack</code> class provided by the instructor for
 * the students in the first Software Design lab. The students then need to
 * implement a <code>Stack</code> class that passes these tests. <b>Note</b>,
 * however, that passing these tests does <i>not</i> guarantee the correctness
 * of the <code>Stack</code> implementation. Tests can never guarentee the
 * absence of errors, although they can increase our confidence,
 * <P>
 * These are basic tests to help the students see the progress in their Stack
 * implementation. While this is a reasonable start, this is not necessarily the
 * kind of testing that should be practiced in larger projects.
 * <code>StackAcceptanceTest</code> contains examples of more sophisticated
 * (and complete) testing of the <code>Stack</code> class, and may be more
 * appropriate as models for more complex tests later on.
 * 
 * @author Amanda Prodger
 * @version $Revision: 1.4 $, last changed by $Author: mcphee $ on $Date:
 *          2006/01/06 18:06:31 $
 * 
 * @see StackAcceptanceTests
 */
public class SimpleStackTest {

    /**
     * An array of values to be used in building test stacks.
     */
    private static String[] values = new String[] { "One", "Two", "Three" };

    /**
     * Construct a new, empty stack of Integers.  Having a factory
     * method like this is by no means necessary for testing, but often
     * simplifies other design and testing issues.  In this case it
     * makes it easier for us to switch from testing the students'
     * implementations of the Stack class and our instructor
     * implementation.
     * 
     * In particular, note that if you wanted to switch from testing
     * one implementation of StackIF, you'd only have to change the
     * constructors in the two factory methods.  Without them, there
     * would be constructor calls scattered throughout this file, all
     * of which would need to be changed to test a different implementation
     * of StackIF.
     *
     * @return a new, empty stack of Integers
     */
    private StackIF<Integer> makeIntegerStack() {
        return new Stack<Integer>();
    }

    /**
     * Construct a new, empty stack of Strings.  Having a factory
     * method like this is by no means necessary for testing, but often
     * simplifies other design and testing issues.  In this case it
     * makes it easier for us to switch from testing the students'
     * implementations of the Stack class and our instructor
     * implementation.
     * 
     * In particular, note that if you wanted to switch from testing
     * one implementation of StackIF, you'd only have to change the
     * constructors in the two factory methods.  Without them, there
     * would be constructor calls scattered throughout this file, all
     * of which would need to be changed to test a different implementation
     * of StackIF.
     *
     * @return a new, empty stack of Strings
     */
    private StackIF<String> makeStringStack() {
        return new Stack<String>();
    }

    /**
     * Tests that a stack is empty when it's initially created.
     */
    @Ignore
    @Test
    public void isNewStackEmpty() {
        final StackIF<Integer> stack = makeIntegerStack();
        assertEquals("Empty stack should have size 0", 0, stack.size());
    }
    
    /**
     * Tests that popping an empty stack throws a StackUnderflowException.
     */
    @Ignore
    @Test(expected = StackUnderflowException.class)
    public void poppingEmptyThrowsException() {
        final StackIF<Integer> stack = makeIntegerStack();
        stack.pop();
    }

    /**
     * Tests that calling top on an empty stack throws a StackUnderflowException.
     */
    @Ignore
    @Test(expected = StackUnderflowException.class)
    public void topOnEmptyThrowsException() {
        final StackIF<Integer> stack = makeIntegerStack();
        stack.top();
    }

    /**
     * Tests that isEmpty() is working correctly when items are being
     * pushed/popped.
     */
    @Ignore
    @Test
    public void testEmptyMethod() {
        final StackIF<Integer> stack = makeIntegerStack();
        assertTrue("Stack should be empty", stack.isEmpty());
        stack.push(1);
        stack.push(2);
        assertFalse("Stack should not be empty", stack.isEmpty());
        stack.pop();
        stack.pop();
        assertTrue("Stack should be empty", stack.isEmpty());
    }

    /**
     * Simple test to show that size() is working correctly as items are being
     * pushed/popped.
     */
    @Ignore
    @Test
    public void testPushPopSize() {
        final StackIF<String> stack = makeStringStack();
        stack.push(values[0]);
        stack.push(values[1]);
        stack.push(values[1]);
        assertEquals("Stack should have a size of 3", stack.size(), 3);
        stack.pop();
        stack.push(values[2]);
        stack.push(values[1]);
        stack.push(values[0]);
        assertEquals("Stack should have a size of 5", stack.size(), 5);
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        assertEquals("Stack should be empty", stack.size(), 0);
    }

    /**
     * A simple test to show that top() is working correctly when items are
     * being pushed/popped
     */
    @Ignore
    @Test
    public void testPushPopTop() {
        final StackIF<String> stack = makeStringStack();
        stack.push(values[2]);
        assertEquals("The top item of the stack should be 'Three'",
                stack.top(), "Three");
        stack.push(values[2]);
        stack.push(values[0]);
        stack.pop();
        assertEquals("The top item of the stack should be 'Three'",
                stack.top(), "Three");
        stack.pop();
        stack.push(values[1]);
        stack.push(values[1]);
        stack.pop();
        assertEquals("The top item of the stack should be 'Two'", stack.top(),
                "Two");
    }

    /**
     * Check that a newly created stack isn't full, and doesn't become
     * full when we push several things on it.  In fact _no_ stack in
     * this implementation should ever be full.
     * 
     * Note that this is a <em>classic</em> example of how testing can never
     * <em>prove</em> that code is correct.  No matter how many items
     * we push on this stack, we can never be sure that it we just pushed
     * <em>one</em> more on we could cause full to return true.
     */
    @Ignore
    @Test
    public void testIsFull() {
        final StackIF<Integer> stack = makeIntegerStack();
        assertFalse("Stacks should never be full", stack.isFull());
        for (int i = 0; i < 100; ++i) {
            stack.push(i);
            assertFalse("Stacks should never be full", stack.isFull());
        }
    }
}
