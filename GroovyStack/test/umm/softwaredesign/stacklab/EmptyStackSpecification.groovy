package umm.softwaredesign.stacklab

import spock.lang.Specification
import spock.lang.Ignore

class EmptyStackSpecification extends Specification {
    def stack = new Stack<Integer>()
    
    def "new stack is empty"() {
        expect: "Size to be zero"
        stack.size() == 0
    }
    
    def "popping an empty stack throws an exception"() {
        when: "pop an empty stack"
        stack.pop()
        
        then: "throws an underflow exception and is still empty"
        thrown(StackUnderflowException)
        stack.isEmpty()
    }
    
    def "top on empty stack throws an exception"() {
        when: "taking top of an empty stack"
        stack.top()
        
        then: "throws an underflow exception and is still empty"
        thrown(StackUnderflowException)
        stack.isEmpty()
    }
}
