package umm.softwaredesign.stacklab

import spock.lang.Specification

class StackWithThreeItemsSpecification extends Specification {
    def stack = new Stack<Integer>()
    def elements = [5, 8, 9]
    
    def setup() {
        elements.each { element ->
            stack.push(element)
        }
    }
    
    def "should not be empty"() {
        expect:
        !stack.isEmpty()
    }
    
    def "should have size 3"() {
        expect:
        stack.size() == elements.size
    }
    
    def "top should be the last element pushed & not change size"() {
        expect:
        // Groovy (like Python and Ruby) let you use negative indices to count from the end
        // of the list, so elements[-1] is the last item in the list.
        stack.top() == elements[-1]
        stack.size() == elements.size
    }
    
    def "popping should remove last element pushed & size should become drop by 1"() {
        when:
        stack.pop()
        
        then:
        // elements[-2] is the next to the last item in the list.
        stack.top() == elements[-2]
        stack.size() == elements.size - 1
    }
}
