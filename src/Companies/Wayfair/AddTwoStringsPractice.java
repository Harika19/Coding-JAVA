package Companies.Wayfair;

public class AddTwoStringsPractice {
    private static String add(String num1, String num2){
        int n1 = num1.length()-1;
        int n2 = num2.length()-1;
        int carry =0;
        int sum =0;
        StringBuilder sb = new StringBuilder();
        while (n1>=0 || n2>=0 || carry >0){
            int digit1 = (n1>=0)? num1.charAt(n1--)-'0': 0;
            int digit2 = (n2>=0)? num2.charAt(n2--)-'0': 0;
            sum = digit1+ digit2+ carry;
           sb.insert(0,sum%10);
           carry= sum/10;
        }
        return formatNumber(sb.toString());
    }

    private static String formatNumber(String num){
        StringBuilder formattedNumber = new StringBuilder();
        int counter=0;
        for(int i =num.length()-1;i>=0;i--){
            formattedNumber.insert(0, num.charAt(i));
            counter++;
            if(counter%3==0 && i>0){
                formattedNumber.insert(0, ",");
            }
        }
        return formattedNumber.toString();
    }

    private static String nFibanocci(int num){
        String first = "1";
        String second = "1";
        String sum ="";
        for(int i=3;i<num;i++){
            sum = add(first, second);
            first= second;
            second= sum;
        }
        System.out.println(first+"...."+second+"..."+sum);
        return sum.toString();
    }
    public static void main(String[] args) {
        AddTwoStringsPractice obj = new AddTwoStringsPractice();
        System.out.println(add("1009", "21"));
        System.out.println(nFibanocci(7));
    }
}