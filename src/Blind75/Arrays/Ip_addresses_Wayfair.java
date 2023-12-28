//Range of IP addresses were mentioned in the question. It should be declared by us in the code as static itself.
//        Zone 1 : 0.0.0.0 - 127.255.255.255
//        Zone 2 : 128....... - ..........................
//        Zone 3 : ............. - ..........................
//        Zone 4 : ......... - 255.255.255.255
//        Array of IP addresses were given as strings. Find out to which region zone they belong to. If an IP address does not fall into any region, just put -1 for that.
//        Input : ["0.0.0.123","129.234.233.24","256.256.2.1"]
//        output : [1,2,-1]

//[
//        [[0,0,0,0],[128.......]],
//      [[127.255.255.255],[..]...]
//        ]

package Blind75.Arrays;

import java.util.Arrays;

public class Ip_addresses_Wayfair {
    private int[] findIPZone(String[][] zoneArr, String[] ipStrArr){
        int len = ipStrArr.length;
        int[] res = new int[len];
        Arrays.fill(res, -1);
        int row=0, col=0;
        int[][] parsedFromIp = new int[zoneArr.length][4];
        int[][] parsedToIp = new int[zoneArr.length][4];
        int[] startIPResult= new int[4];
        int[] endIPResult= new int[4];


        for(String[] aZone : zoneArr){
            boolean fromFlag = true;
            String[] startIP = aZone[0].split("\\."); // ['0,0,0,0]
            String[] endIP = aZone[1].split("\\.");

            startIPResult = Arrays.stream(startIP).mapToInt(s -> Integer.parseInt(s)).toArray();
            endIPResult = Arrays.stream(endIP).mapToInt(s -> Integer.parseInt(s)).toArray();

            parsedFromIp[row]= startIPResult;
            parsedToIp[row] = endIPResult;
            row++;



//            for(String zone: aZone) {
//                String[] addressStrArray = zone.split("\\.");
//                int ind = 0;
//
//                for (String address: addressStrArray) {
//                    if(fromFlag) {
//                        parsedFromIp[row][ind++] = Integer.parseInt(address);
//                    } else {
//                        parsedToIp[row][ind++] = Integer.parseInt(address);
//                    }
//                }
//                fromFlag = !fromFlag;
//
//            }
//            row++;
        }

        System.out.println(Arrays.deepToString(parsedFromIp));
        System.out.println(Arrays.deepToString(parsedToIp));

        for(int k =0; k<ipStrArr.length; k++){
            int[] parsedIp = Arrays.stream(ipStrArr[k].split("\\."))
                    .mapToInt(str -> Integer.parseInt(str))
                    .toArray();
            System.out.println("parsedIp "+ Arrays.toString(parsedIp));
            boolean isFound = false;
            for(int i=0; i<parsedFromIp.length && !isFound; i++){
                for(int j=0; j<4 && !isFound; j++){
                    System.out.println("parsedFromIp "+ Arrays.toString(parsedFromIp[i]));
                    System.out.println("parsedToIp "+ Arrays.toString(parsedToIp[i]));
                    System.out.println(parsedIp[j] + "  "+ parsedFromIp[i][j] + "  "+parsedToIp[i][j] );
                    if((parsedIp[j] >= parsedFromIp[i][j]) && (parsedIp[j] <= parsedToIp[i][j])){
                        res[k] = i;
                        isFound= true;
                        break;
                    }
                }
            }
            System.out.println("\n");
        }

        //System.out.println(Arrays.toString(parsedIp));
//        System.out.println(Arrays.deepToString(parsedToIp));

        return res;
    }

    private int[] ip_range(String[] arr){
        int[] res = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            String temp = arr[i];
            String[] no = temp.split("\\.");
            System.out.println(Arrays.toString(no));
            int first = Integer.parseInt(no[0]);
            if(first>=0 && first<=127){
                res[i]=1;
            }else if(first>128 && first<=250){
                res[i]=2;
            }else{
                res[i]=-1;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Ip_addresses_Wayfair obj = new Ip_addresses_Wayfair();
        String[][] zones = {
                {"0.0.0.0",   "127.255.255.255"},
                {"128.0.0.0", "191.255.255.255"},
                {"192.0.0.0", "223.255.255.255"},
                {"224.0.0.0", "255.255.255.255"}
        };
        String[] arr={"0.0.0.123","129.234.233.24","256.256.2.1"};
        System.out.println(Arrays.toString(obj.findIPZone(zones, arr)));
    }
}

//
//import java.util.regex.Matcher;
//        import java.util.regex.Pattern;
//
//public class Ip_addresses_Wayfair {
//    private String[] zoneRanges; // Array to store the range of each zone
//
//    public Ip_addresses_Wayfair(String[] zoneRanges) {
//        this.zoneRanges = zoneRanges;
//    }
//
//    public int findZone(String ipAddress) {
//        long ipNum = ipToLong(ipAddress);
//        for (int i = 0; i < zoneRanges.length; i++) {
//            String[] range = zoneRanges[i].split("-");
//            long lowerBound = ipToLong(range[0].trim());
//            long upperBound = ipToLong(range[1].trim());
//
//            if (ipNum >= lowerBound && ipNum <= upperBound) {
//                return i + 1; // Zones are 1-indexed
//            }
//        }
//        return -1; // IP does not fall into any zone
//    }
//
//    private long ipToLong(String ipAddress) {
//        long result = 0;
//        String[] ipAddressParts = ipAddress.split("\\.");
//
//        for (int i = 0; i < ipAddressParts.length; i++) {
//            int power = 3 - i;
//            int ip = Integer.parseInt(ipAddressParts[i]);
//            result += ip * Math.pow(256, power);
//        }
//        System.out.println("00000..   "+ result);
//        return result;
//    }
//
//    public static void main(String[] args) {
//        String[] zones = {"0.0.0.0 - 127.255.255.255", "128.0.0.0 - 191.255.255.255", "192.0.0.0 - 223.255.255.255", "224.0.0.0 - 255.255.255.255"};
//        Ip_addresses_Wayfair finder = new Ip_addresses_Wayfair(zones);
//
//        String[] testIps = {"0.0.0.123", "129.234.233.24", "256.256.2.1"};
//        for (String ip : testIps) {
//            System.out.println(finder.findZone(ip));
//        }
//    }
//}
