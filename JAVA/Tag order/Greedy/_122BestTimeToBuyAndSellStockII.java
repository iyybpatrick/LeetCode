/**
 * Created by YuebinYang on 2017/3/27.
 */
public class _122BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <=1) return 0;
        int sum = 0;
        for (int i = 0; i < prices.length - 1; i++){
            if (prices[i + 1] > prices[i]){
                sum += prices[i + 1] - prices[i];
            }
        }
        return sum;
    }

    public static void main(String[] args){
        _122BestTimeToBuyAndSellStockII A =new _122BestTimeToBuyAndSellStockII();
        int[]prices = {1,4,2,5,8,1,9};
        System.out.println(A.maxProfit(prices));
    }
}


//question;
    //Say you have an array for which the ith element is the price of a given stock on day i.
    //
    //        Design an algorithm to find the maximum profit. You may complete as many transactions as you like
    //        (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple
    //        transactions at the same time (ie, you must sell the stock before you buy again).