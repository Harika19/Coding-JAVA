package Blind75.Strings;

public class LC_415_Add_Strings {
    private static String addString(String num1, String num2){
        StringBuilder sb = new StringBuilder();
        int carry =0;
        while (num1.length()<num2.length()){
            num1 = "0" + num1;
        }
        while (num2.length()<num1.length()){
            num2 = "0" + num2;
        }

        for(int i=num1.length()-1;i>=0;i--){
            int digit1= num1.charAt(i) - '0';
            int digit2= num2.charAt(i) - '0';

            int sum = digit1+digit2+ carry;
            System.out.println("2222"  +sum%10);
            sb.insert(0, sum%10);
            System.out.println("1111"+sb);
            carry = sum/10;
        }

        if(carry>0){
            sb.insert(0,carry);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String num1="456";
        String num2="77";
        System.out.println(addString(num1, num2));
    }
}
