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
        int row=0, col=0;
        int[][] parsedIpMatrix = new int[zoneArr.length][4];
        for(String[] aZone : zoneArr){
            for(String zone: aZone){
                String[] addressStrArray = zone.split("\\.");
                //int index =
                for (String address: addressStrArray){

                }

            }
            col=0;
            row++;

        }

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
        String[] arr={"0.0.0.123","129.234.233.24","256.256.2.1"};
        System.out.println(Arrays.toString(obj.ip_range(arr)));
    }
}
