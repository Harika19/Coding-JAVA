package OOPS_Concepts;

enum Status{
    NotFound, ServiceUnavailable, InternalServerError
}

public class Enum_Test {
    public static void main(String[] args) {
        Status s = Status.ServiceUnavailable; // way of accesing
        System.out.println(s.ordinal()); // index , generally starts with 0 in java
        // can use switch as well
        if(s == Status.NotFound){
            System.out.println("404 error");
        }else if (s == Status.ServiceUnavailable){
            System.out.println("500 status code");
        }
    }
}
