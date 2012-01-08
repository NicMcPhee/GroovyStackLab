package umm.softwaredesign.stacklab;


/**
 * Run time exception used to indicate a stack underflow, i.e., popping or
 * taking the top of an empty stack.
 *
 * <p>
 * This is really incomplete because it doesn't provide for the other three
 * constructors in <CODE>Exception</CODE> that provide for the inclusion of
 * error messages and causes.  It wouldn't be hard to add them and we probably
 * should because that would allow us to, for example, differentiate between
 * an exception caused by popping an empty stack and an exception caused by
 * taking the top of an empty stack.
 * </p>
 *
 * @author mcphee
 * @version $Revision: 1.6 $, last changed by $Author: mcphee $
 * on $Date: 2003/08/26 05:23:09 $
 *
 * @todo Implement the missing constructors.
 */
public class StackUnderflowException extends RuntimeException {
    /*
     * We don't actually need anything here, since this class exists
     * really just to provide a name.  If we want to provide some of the
     * more interesting constructors provided by Exception, then we'll
     * need to add those, but for now the default constructor will do
     * us just fine.
     */
}
