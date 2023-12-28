package Companies.Wayfair;

//  Time Complexity:
//
//        The time complexity of the add method is O(max(N, M)), where N and M are the lengths of the input strings.
//        The time complexity of the NthFibonacci method is O(N * max(N, M)), where N is the input number and M is the length of the strings.
//  Space Complexity:
//
//        The space complexity is O(max(N, M)) for both the add and formattedNumber methods.
public class AddTwoStrings {
    public static void main(String[] args) {
        String a = "5467";
        String b = "4";

        // Testing the add method
        System.out.println(add(a, b));

        // Testing the NthFibonacci method
        System.out.println(NthFibonacci(1));
        System.out.println(NthFibonacci(2));
        System.out.println(NthFibonacci(5));
        System.out.println(NthFibonacci(10));
        System.out.println(NthFibonacci(31));
        System.out.println(NthFibonacci(0));
    }
    public static String add(String num1, String num2) {
        // Removing commas and adding numbers
        String a = num1.replace(",", "");
        String b = num2.replace(",", "");

        int n1 = a.length() - 1;
        int n2 = b.length() - 1;
        int carry = 0;
        StringBuilder result = new StringBuilder();

        // Adding numbers digit by digit
        while (n1 >= 0 || n2 >= 0 || carry > 0) {
            int d1 = n1 >= 0 ? a.charAt(n1--) - '0' : 0;
            int d2 = n2 >= 0 ? b.charAt(n2--) - '0' : 0;


            int sum = d1 + d2 + carry;
            result.append(sum % 10);
            carry = sum / 10;
        }

        // Formatting the result with commas
        return formattedNumber(result.reverse().toString());
    }
    public static String formattedNumber(String num) {
        StringBuilder formatted = new StringBuilder();
        int counter = 0;

        // Inserting commas in the formatted number
        for (int i = num.length() - 1; i >= 0; i--) {
            formatted.insert(0, num.charAt(i));
            counter++;

            if (counter % 3 == 0 && i > 0) {
                formatted.insert(0, ",");
            }
        }
        return formatted.toString();
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
