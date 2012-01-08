package umm.softwaredesign.stacklab

import spock.lang.Ignore;
import spock.lang.Specification


class StackWithOneItemSpecification extends Specification {
    def stack = new Stack<String>()
    
    def "should have size 1"() {
        when:
        stack.push("Morris")
        
        then:
        stack.size() == 1
    }
    
    def "should not be empty"() {
        when:
        stack.push("Morris")
        
        then:
        !stack.isEmpty()
    }
}
