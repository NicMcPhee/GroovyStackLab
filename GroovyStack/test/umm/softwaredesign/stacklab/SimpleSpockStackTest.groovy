package umm.softwaredesign.stacklab

class SimpleSpockStackTest extends spock.lang.Specification {
    def "new stack is empty"() {
        setup:
        def stack = new Stack<Integer>()
        
        expect:
        stack.size() == 0
    }
    
    def "popping an empty stack throws an exception"() {
        setup:
        def stack = new Stack<Integer>()
        
        when:
        stack.pop()
        
        then:
        thrown(StackUnderflowException)
        stack.isEmpty()
    }
    
    def "top on empty stack throws an exception"() {
        setup:
        def stack = new Stack<Integer>()
        
        when:
        stack.top()
        
        then:
        thrown(StackUnderflowException)
        stack.isEmpty()
    }
}
