package umm.softwaredesign.stacklab

class SimpleSpockStackTest extends spock.lang.Specification {
    def "new stack is empty"() {
        expect:
        (new Stack()).size() == 0
    }
}

//class HelloSpock extends spock.lang.Specification {
//    def "length of Spock's and his friends' names"() {
//        expect:
//        name.size() == length
//
//        where:
//        name     | length
//        "Spock"  | 5
//        "Kirk"   | 3
//        "Scotty" | 6
//    }
//}

