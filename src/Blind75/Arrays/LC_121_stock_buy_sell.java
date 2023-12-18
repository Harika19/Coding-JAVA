package Blind75.Arrays;

import java.util.Scanner;

public class LC_121_stock_buy_sell {
    public int maxProfit(int[] prices) {
        int profit=0;
        int mini = Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
            mini = Math.min(mini, prices[i]);
            profit = Math.max(profit, prices[i]- mini);
        }
        return profit;
    }

    public static void main(String[] args) {
        LC_121_stock_buy_sell obj = new LC_121_stock_buy_sell();
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] prices = new int[size];
        for(int i=0;i<size;i++){
            prices[i] = scanner.nextInt();
        }
        System.out.println(obj.maxProfit(prices));
    }
}
