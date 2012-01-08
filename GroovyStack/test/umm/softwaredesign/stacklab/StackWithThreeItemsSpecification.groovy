package umm.softwaredesign.stacklab

import spock.lang.Specification

class StackWithThreeItemsSpecification extends Specification {
    def stack = new Stack<Integer>()
    
    def setup() {
        stack.push(5)
        stack.push(8)
        stack.push(9)
    }
    
    def "should not be empty"() {
        expect:
        !stack.isEmpty()
    }
    
    def "should have size 3"() {
        expect:
        stack.size() == 3
    }
    
    def "top should be the last element pushed & not change size"() {
        expect:
        stack.top() == 9
        stack.size() == 3
    }
    
    def "popping should remove last element pushed & size should become 2"() {
        when:
        stack.pop()
        
        then:
        stack.top() == 8
        stack.size() == 2
    }
}
