package umm.softwaredesign.stacklab;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * JUnit tests for the <code>Stack</code> class provided by the instructor for
 * the students in the first Software Design lab. The students then need to
 * implement a <code>Stack</code> class that passes these tests. <b>Note</b>,
 * however, that passing these tests does <i>not</i> guarantee the correctness
 * of the <code>Stack</code> implementation. Tests can never guarantee the
 * absence of errors, although they can increase our confidence,
 * <P>
 * These tests should also provide a useful (but not simple) example of writing
 * JUnit tests for later labs and projects where the tests don't come "for
 * free". The <code>SimpleStackTest</code> class provides some simpler, but
 * less complete, tests that may be easier to use as a template. The ideas in
 * this class, however, are important and useful in the building of more
 * sophisticated suites of tests, and one should not simply ignore these because
 * they're more complicated.
 * 
 * @author Nic McPhee
 * @version $Revision: 1.12 $, last changed by $Author: mcphee $ on $Date:
 *          2006/01/09 17:37:46 $
 * 
 * @see umm.softwaredesign.stacklab.StackIF
 * @see umm.softwaredesign.stacklab.Stack
 * @see umm.softwaredesign.stacklab.SimpleStackTest
 */
/*
 * To change this from testing the student stack to testing the instructor
 * stack, make the changes indicated below in both makeStack() and
 * makeStack(final StackIF<T> stack).
 */
public class StackAcceptanceTests {
    /**
     * The number of test stacks that we'll construct.
     */
    public static final int NUM_TEST_STACKS = 6;

    /**
     * An array of test stacks. These are initialized in <CODE>setUp</CODE>
     * and then used in the various tests.
     */
    private StackIF<Integer>[] stacks;

    /**
     * Get the specified test stack.
     * 
     * @param index
     *            the index of the desired test stack
     * @return the index-th test stack
     */
    private StackIF<Integer> getTestStack(final int index) {
        return stacks[index];
    }

    /**
     * This is a simple utility method that constructs a new, empty, Stack.
     * 
     * @return a new, empty, Stack
     */
    /*
     * To change from testing the student stack to the instructor stack, change
     * the constructor below to new InstructorStack<Integer>().
     */
    private StackIF<Integer> makeStack() {
        return new Stack<Integer>();
    }

    /**
     * Construct a stack that's a (shallow) clone of the given stack by calling
     * the copy constructor in our stack class.
     * 
     * @param <T>
     *            The type of the objects on the stack being copied
     * @param stack
     *            the stack we want to make a copy of
     * 
     * @return a copy of the given stack
     */
    /*
     * To change from testing the student stack to the instructor stack, change
     * the constructor below to new InstructorStack<T>((InstructorStack<T>)
     * stack).
     */
    private <T> StackIF<T> makeStack(final StackIF<T> stack) {
        return new Stack<T>((Stack<T>) stack);
    }

    /**
     * Construct a stack having the specified number of elements, namely the
     * <CODE>Integer</CODE>s containing the values from 0 (on the bottom) to
     * size-1 (on the top).
     * 
     * @param size
     *            the size of the stack to construct
     * @return the constructed stack
     */
    private StackIF<Integer> makeStack(final int size) {
        final StackIF<Integer> stack = makeStack();
        for (int i = 0; i < size; ++i) {
            stack.push(i);
        }
        return stack;
    }

    /**
     * Construct a stack having the elements specified in the given array, with
     * the zero-th array element at the bottom of the stack and the last on the
     * top.
     * 
     * @param values
     *            the array of values to put on the stack
     * @return the constructed stack
     */
    private StackIF<Integer> makeStack(final int[] values) {
        final StackIF<Integer> stack = makeStack();
        for (int i = 0; i < values.length; ++i) {
            stack.push(values[i]);
        }
        return stack;
    }

    /**
     * Construct a collection of test stacks that we can use in our testing.
     * This constructs <CODE>NUM_TEST_STACKS</CODE> stacks, where the ith
     * stack has i elements, namely the <CODE>Integer</CODE>s containing the
     * values from 0 (on the bottom) to i-1 (on the top).
     * 
     * Note that <CODE>setUp()</CODE> is a JUnit method, and is automatically
     * called by JUnit before every test method is called to ensure that we get
     * a clean set of stacks for each test. This means that this collection of
     * stacks (exactly as described here) will be available at the beginning of
     * every test.
     */
    @SuppressWarnings("unchecked")
    @Before
    public final void makeStackArray() {
        stacks = new StackIF[NUM_TEST_STACKS];
        for (int i = 0; i < NUM_TEST_STACKS; ++i) {
            stacks[i] = makeStack(i);
        }
    }

    /**
     * Test the copy constructor by making copies of several stacks and
     * verifying that they have equal elements to the original without being being ==.
     * 
     * A copy constructor is a constructor that takes another object of the
     * same type (in this case another stack) and constructs a new object
     * (a new stack) that is a copy of the one that was passed in.  In our
     * case this is what's called a <em>shallow copy</em>, meaning we make
     * a new stack, but we <em>don't</em> make copies of all the elements
     * of the stack and instead only copy references to them.
     */
    @Test
    @Ignore("Remove this line when ready to test the copy constructor")
    public final void testCopyConstructor() {
        for (int i = 0; i < NUM_TEST_STACKS; ++i) {
            final StackIF<Integer> copy = makeStack(getTestStack(i));
            assertEquality(copy, getTestStack(i));
            assertStacksNotSame(copy, getTestStack(i));
        }
    }

    /**
     * Assert that the two given stacks are hasEqualElements() (if shouldBeEqual is true)
     * or not hasEqualElements() (if shouldBeEqual is false). The message generated if the
     * assertion fails is similar to the default message generated by
     * assertEquals(), but modified slightly to better suit this assertion.
     * <P>
     * As a rule one won't call this method directly, but will instead call
     * assertEquality or assertInequality.
     * <P>
     * 
     * @param <T>
     *            the type of the objects on the stacks being tested for
     *            equality
     * @param first
     *            a Stack object
     * @param second
     *            a Stack object
     * @param shouldBeEquals
     *            a boolean, where true indicates that first and second should be
     *            hasEqualElements(), and false indicates that they should <EM>not</EM>
     *            be equals.
     */
    private <T> void checkEquality(final StackIF<T> first,
            final StackIF<T> second, final boolean shouldBeEquals) {
        final boolean equalityResult
            = first.hasEqualElements(second) == shouldBeEquals;

        final StringBuilder msg = new StringBuilder("Should have been ");
        if (!shouldBeEquals) {
            msg.append("NOT ");
        }
        msg.append("hasEqualElements(): < " + first + "> and <" + second + ">");

        assertTrue(msg.toString(), equalityResult);
    }

    /**
     * Assert that the two given stacks are hasEqualElements(). The message generated if
     * the assertion fails is similar to the default message generated by
     * assertEquals(), but modified slightly to better suit this assertion.
     * 
     * @param <T>
     *            the type of the elements on the stacks being compared
     * @param first
     *            a Stack object
     * @param second
     *            a Stack object
     */
    private <T> void assertEquality(final StackIF<T> first,
            final StackIF<T> second) {
        checkEquality(first, second, true);
    }

    /**
     * <Integer> Assert that the two given stacks are NOT hasEqualElements(). The message
     * generated if the assertion fails is similar to the default message
     * generated by assertEquals(), but modified slightly to better suit this
     * assertion.
     * 
     * @param <T>
     *            the type of the elements of the stacks being compared
     * @param first
     *            a Stack object
     * @param second
     *            a Stack object
     */
    private <T> void assertInequality(final StackIF<T> first,
            final StackIF<T> second) {
        checkEquality(first, second, false);
    }

    /**
     * Asserts that the two given stacks are not ==, i.e., not references to the
     * same object.
     * 
     * @param <T>
     *            the type of the elements of the stacks being compared
     * @param first
     *            a Stack object
     * @param second
     *            a Stack object
     */
    private <T> void assertStacksNotSame(final StackIF<T> first,
            final StackIF<T> second) {
        assertNotSame("Should have been !=:  <" + first + "> and <" + second
                + ">", first, second);
    }

    /**
     * Verifies that the a stack generated using makeStack(int) having the
     * specified length is hasEqualElements() to the appropriate stack in _stacks, and NOT
     * hasEqualElements() to the other stacks in _stacks.
     * 
     * @param size
     *            the size of the stack to construct and compare
     */
    private void checkStackOnList(final int size) {
        final StackIF<Integer> stack = makeStack(size);
        for (int i = 0; i < NUM_TEST_STACKS; ++i) {
            if (i == size) {
                assertEquality(stack, getTestStack(i));
            } else {
                assertInequality(stack, getTestStack(i));
            }
        }
    }

    /**
     * Test the stack hasEqualElements() method, by constructing several new stacks, and
     * then comparing them to various of our tests stacks in _stacks.
     */
    @Test
    @Ignore("Remove this line when ready to test the hasEqualElements() method")
    public final void testHasEqualElements() {
        // Verify that a stack isn't equal to a non-stack
        for (int i = 0; i < NUM_TEST_STACKS; ++i) {
            assertFalse("Stacks shouldn't be equal to non-stacks",
                    getTestStack(i).equals("A string, not a stack"));
        }

        // checkStackOnList() constructs a stack of the specified size,
        // and then verifies that it's hasEqualElements() to just the one
        // stack in _stacks that it's supposed to be. Thus we'll just
        // call checkStackOnList() for all the sizes in _stacks.
        for (int i = 0; i < NUM_TEST_STACKS; i++) {
            checkStackOnList(i);
        }

        // Try it once with a stack that's longer than anything on _stacks.
        checkStackOnList(2 * NUM_TEST_STACKS);

        // Now we'll construct a stack that's got the same elements as
        // one of the stacks in _stacks, but in a different order, and
        // verify that this is not hasEqualElements() to anything in _stacks.
        final int[] values = { 0, 2, 1 };
        final StackIF<Integer> stack = makeStack(values);
        for (int i = 0; i < NUM_TEST_STACKS; ++i) {
            assertInequality(stack, getTestStack(i));
        }
    }

    /**
     * Test the push() method. For this we need to verify that adding an item
     * indeed adds it (i.e., top(s.push(x)) == x), and that it doesn't alter any
     * of the other items in the stack.
     */
    @Test
    @Ignore("This depends on the copy constructor.  Remove this line once you've implemented that")
    public final void testPush() {
        // We'll run several tests on all of the test stacks in _stacks[].
        for (int i = 0; i < NUM_TEST_STACKS; ++i) {
            final StackIF<Integer> originalStack = getTestStack(i);
            final StackIF<Integer> stack = makeStack(originalStack);

            final Integer object = 31;
            stack.push(object);

            // Verify that the stack size is one greater than before.
            assertEquals("Pushing should increase stack size by one",
                    originalStack.size() + 1, stack.size());

            // Verify that the top is the new object
            assertEquals("Top after push(x) should yield x", object, stack
                    .top());

            // Verify that the rest of the Stack is unchanged.
            stack.pop();
            assertEquals("Popping after push should yield original stack",
                    originalStack, stack);
        }
    }

    /**
     * Verify that popping an empty stack throws a StackUnderflowException.
     */
    @Ignore
    @Test(expected = StackUnderflowException.class)
    public void poppingEmptyThrowsException() {
        getTestStack(0).pop();
    }

    /**
     * Test the pop() method. We've already done quite a bit of testing of this
     * in our testing of the push() method since the two are pretty tightly
     * linked. Here we'll verify that popping an item only removes the top item
     * and doesn't change any other parts of the stack.
     */
    @Test
    @Ignore("This depends on the copy constructor.  Remove this line once you've implemented that")
    public final void testPop() {
        // We'll run several tests on all of the test stacks in _stacks[].
        for (int i = 1; i < NUM_TEST_STACKS; ++i) {
            final StackIF<Integer> originalStack = getTestStack(i);
            final StackIF<Integer> stack = makeStack(originalStack);
            stack.pop();
            // We should now have the same stack as the preceding one
            // in the array.
            assertEquals("Popping should have given us "
                    + "a stack with one less element", getTestStack(i - 1),
                    stack);
            assertEquals("Popping should give us a stack with size "
                    + "one less than before", i - 1, stack.size());
        }
    }

    /**
     * Test the size() method by simply verifying that all our test stacks have
     * the correct size. We use size() in several other tests as well, so this
     * method gets exercised quite heavily.
     */
    @Ignore
    @Test
    public final void testSize() {
        // Check that all the stacks in _stacks have the correct size.
        // I could test that pushing and popping do the right thing to
        // but I do that in <CODE>testPush()</CODE> and
        // <CODE>testPop()</CODE> and there's no real reason to repeat
        // it here.
        for (int i = 0; i < NUM_TEST_STACKS; ++i) {
            assertEquals("Stack " + i + " should have size " + i, i,
                    getTestStack(i).size());
        }
    }

    /**
     * Verify that calling top() on an empty stack throws a
     * StackUnderflowException.
     */
    @Ignore
    @Test(expected = StackUnderflowException.class)
    public void topOnEmptyThrowsException() {
        getTestStack(0).top();
    }

    /**
     * Test the top() method. We verify that taking top() of an empty stack
     * throws a StackUnderflowException, and that the top of all our test stacks
     * are the expected values.
     */
    @Ignore
    @Test
    public final void testTop() {
        for (int i = 1; i < NUM_TEST_STACKS; ++i) {
            assertEquals("Top of stack " + i + " should be " + (i - 1), i - 1,
                    getTestStack(i).top().intValue());
        }
    }

    /**
     * No stack in this implementation should ever be full. Since we can't test
     * <em>all</em> stacks, we'll simply verify that pushing a large number
     * (10001) items onto a stack doesn't cause it to fill.
     */
    @Ignore
    @Test
    public final void testIsFull() {
        final StackIF<Integer> stack = new Stack<Integer>();
        final int numItems = 10001;
        for (int i = 0; i < numItems; ++i) {
            assertFalse("Stacks should never be full", stack.isFull());
            stack.push(i);
        }
        assertFalse("Stacks should never be full", stack.isFull());
    }

    /**
     * A helper method that constructs the expected toString() output for one
     * our test stacks (without actually building a stack and calling
     * toString()).
     * 
     * @param size
     *            the size of the stack to build a String representation of
     * 
     * @return the String representation of _stacks[size]
     */
    private String makeStackString(final int size) {
        final StringBuilder result = new StringBuilder("Stack[");
        for (int i = 0; i < size; ++i) {
            if (i > 0) {
                result.append(", ");
            }
            result.append(i);
        }
        result.append("]");

        return result.toString();
    }

    /**
     * Test the toString() method by verifying that each of our test stacks has
     * the toString() form that is specified in Stack.
     * 
     * @see umm.softwaredesign.stacklab.Stack#toString()
     */
    @Test
    @Ignore("Remove this line when you've implemented the toString() method")
    public final void testToString() {
        for (int i = 0; i < NUM_TEST_STACKS; ++i) {
            assertEquals("toString() for " + i + " was wrong",
                    makeStackString(i), getTestStack(i).toString());
        }
    }
}
