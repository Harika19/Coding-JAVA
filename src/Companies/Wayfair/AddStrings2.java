package Companies.Wayfair;

public class AddStrings2 {
    public static void main(String args[]){
        System.out.println(add("5,456","1,234"));
        System.out.println(add("1,000","2"));
        System.out.println(add("1,000,000,000","1,000,111"));
        System.out.println(add("55","44"));
        System.out.println(add("99","1"));
    }
    public static String add(String num1, String num2){
        String a = num1.replace(",","");
        String b = num2.replace(",","");
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
        return formattedNumber(out.reverse().toString());
    }
    public static String formattedNumber(String num){
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        for(int i = num.length()-1;i>=0;i--){
            sb.insert(0,num.charAt(i));
            counter++;

            if(counter %3 ==0 && i>0){
                sb.insert(0,",");
            }
        }
        return sb.toString();
    }
}
