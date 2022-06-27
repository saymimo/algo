package leetcode;

import java.util.Arrays;

public class Medium322CoinChange {

    public int coinChange(int amount, int[] coins){
        int unMax = amount + 1;
        int[] arr = new int[amount + 1];
        Arrays.fill(arr, unMax);
        arr[0] = 0;
        // 自底向上循环设置每个金额的最优解（最优解=最少硬币个数）
        for(int i = 1; i < arr.length; i++){
            for(int coin : coins){
                if(i >= coin){
                    /**
                     金额i的最优解为，金额i-coin的最优解再加一枚coin的金币
                     如金额11:
                     假设 >> 在第一枚选了1时，问题转化为金额10的最优解+一枚1元硬币
                     假设 >> 在第一枚选了2时，问题转化为金额9的最优解+一枚2元硬币
                     假设 >> 在第一枚选了5时，问题转化为金额6的最优解+一枚5元硬币
                     即F(i) = F(i-coin) + 1，问题在于第一手coin的变化，再从第一手不同情况中取出最小的次数，即为金额i的最优解
                     */
                    arr[i] = Math.min(arr[i], arr[i-coin] + 1);
                }
            }
        }
        return arr[amount] == unMax ? -1 : arr[amount];
    }

}
