package umm.softwaredesign.stacklab

import spock.lang.Ignore;
import spock.lang.Specification

class StackWithOneItemSpecification extends Specification {
    /*
     * Note the persistent and annoying repetition of the code to push the
     * one item that appears in every method in this file. This can be eliminated
     * either with a setup() method or via a helper method. I'd lean towards a
     * setup() method, but that forces you to change all the "then:" blocks to
     * "expect:" blocks, and I felt that the "when/then" pairs would be easier
     * to read in our first exposure to Spock tests so I left the repetition in
     * for now. Groups should feel free to clean that up, though.
     */
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
    
    def "top should be the pushed element & not change size"() {
        when:
        stack.push("Morris")
        
        then:
        stack.top() == "Morris"
        stack.size() == 1
    }
    
    def "pop should remove pushed element & size should become 0"() {
        when:
        stack.push("Morris")
        stack.pop()
        
        then:
        stack.size() == 0
    }
}
