package Companies.Wayfair;

public class CodingRound_StringManipulation {
    private String add(String a, String b){
        int l1 = a.length()-1;
        int l2 = b.length()-1;
        int carry =0;
        int sum =0;
        StringBuilder str = new StringBuilder();
        while (l1>=0 || l2>=0 || carry>0){
            int no1= (l1>=0)? a.charAt(l1--) - '0': 0;
            int no2 = (l2>=0)? b.charAt(l2--)-'0': 0;
            sum = no2+ no1+ carry;
            //str.append(sum%10);
            str.insert(0, sum%10);
            System.out.println("22222  " +str.toString());
            carry = sum/10;
        }
        return str.toString();
    }

//    private String formatNumber(String num){
//
//    }


    public static void main(String[] args) {
        CodingRound_StringManipulation obj = new CodingRound_StringManipulation();
        String a = "155";
        String b = "454";
        System.out.println(obj.add(a,b));
    }
}
