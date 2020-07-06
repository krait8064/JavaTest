package cn.krait8063.algorithm;

import org.junit.Test;

/**
 * created by krait8064 at 2020/07/06
 */
public class MaxProfitShare {

    public int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }

    public int maxProfit2(int prices[]) {
        int result = 0;
        if (prices != null && prices.length > 1) {
            int end = 1;
            while (end < prices.length) {
               if (prices[end] > prices[end-1]) {
                    result += prices[end ] - prices[end-1];
                }
                end++;
            }
        }
        System.out.println("rsult:"+result);
        return result;
    }

    @Test
    public void test() {
        int[] arr = {1, 2, 3};
        int res = maxProfit2(arr);
    }


}
