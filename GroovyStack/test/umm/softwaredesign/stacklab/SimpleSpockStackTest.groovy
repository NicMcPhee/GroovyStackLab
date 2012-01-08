package umm.softwaredesign.stacklab

class SimpleSpockStackTest extends spock.lang.Specification {
    def "new stack is empty"() {
        setup: "Create an empty stack"
        def stack = new Stack<Integer>()
        
        expect: "Size to be zero"
        stack.size() == 0
    }
    
    def "popping an empty stack throws an exception"() {
        setup: "Create an empty stack"
        def stack = new Stack<Integer>()
        
        when: "pop an empty stack"
        stack.pop()
        
        then: "throws an underflow exception and is still empty"
        thrown(StackUnderflowException)
        stack.isEmpty()
    }
    
    def "top on empty stack throws an exception"() {
        setup: "Create an empty stack"
        def stack = new Stack<Integer>()
        
        when: "taking top of an empty stack"
        stack.top()
        
        then: "throws an underflow exception and is still empty"
        thrown(StackUnderflowException)
        stack.isEmpty()
    }
}
