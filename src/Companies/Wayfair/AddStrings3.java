package Companies.Wayfair;

public class AddStrings3 {
    public static void main(String args[]){
        System.out.println(NthFibonacci(1));
        System.out.println(NthFibonacci(2));
        System.out.println(NthFibonacci(5));
        System.out.println(NthFibonacci(10));
        System.out.println(NthFibonacci(31));
        System.out.println(NthFibonacci(0));
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
    public static String NthFibonacci(int num){
        if(num<=0){
            return "Invalid input";
        }
        if(num<=2){
            return String.valueOf(num);
        }
        String a = "1";
        String b = "1";
        String sum = "";
        for(int i=3;i<=num;i++){
            sum = add(a,b);
            a=b;
            b=sum;
        }
        return sum;
    }
}
