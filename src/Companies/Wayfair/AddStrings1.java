package Companies.Wayfair;

public class AddStrings1 {
    public static void main(String args[]){
        System.out.println(add("5456","1234"));
        System.out.println(add("1000","2"));
        System.out.println(add("999","1"));
        System.out.println(add("55","44"));
        System.out.println(add("0","0"));
    }
    public static String add(String a, String b){
        int n1 = a.length()-1;
        int n2 = b.length()-1;
        int carry = 0;
        int sum = 0;
        StringBuilder out = new StringBuilder();
        while(n1>=0 || n2>=0 || carry>0){
            int d1 = n1>=0 ? a.charAt(n1--)-'0' : 0;
            int d2 = n2>=0 ? b.charAt(n2--)-'0' : 0;
            sum = d1+d2+carry;
            out.append(sum%10);
            carry = sum/10;
        }
        return out.reverse().toString();
    }
}

