package leetcode.p1.p121;

public class MaxProfit {
    /**
     * the divide and conquer method as I was taught in the CSCI-570
     */
    public static int maxProfit1(int[] prices) {
        return helper1(prices, 0, prices.length - 1)[0];
    }

    public static int[] helper1(int[] prices, int start, int end) {
        int[] result = new int[3];
        if (end - start <= 3) {
            result[1] = prices[start];
            result[2] = prices[start];
            for (int i = start; i <= end; i++) {
                for (int j = i + 1; j <= end; j++) {
                    if (prices[j] - prices[i] > result[0]) {
                        result[0] = prices[j] - prices[i];
                    }
                }
                if (prices[i] > result[1]) {
                    result[1] = prices[i];
                }
                if (prices[i] < result[2]) {
                    result[2] = prices[i];
                }
            }
        } else {
            int[] temp1 = helper1(prices, start, (start + end) / 2);
            int[] temp2 = helper1(prices, (start + end) / 2 + 1, end);
            result[0] = Math.max(temp2[1] - temp1[2], Math.max(temp1[0], temp2[0]));
            result[1] = Math.max(temp1[1], temp2[1]);
            result[2] = Math.min(temp1[2], temp2[2]);
        }
        return result;
    }

    /**
     * One pass!
     */
    public static int maxProfit(int[] prices) {
        int profit = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > min) {
                if (prices[i] - min > profit) {
                    profit = prices[i] - min;
                }
            } else if (prices[i] < min) {
                min = prices[i];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices;

        prices = new int[]{6, 1, 3, 2, 4, 7};
        System.out.println(maxProfit(prices) == 6);

        prices = new int[]{7, 6, 4, 3, 1};
        System.out.println(maxProfit(prices) == 0);

        prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices) == 5);

    }
}

