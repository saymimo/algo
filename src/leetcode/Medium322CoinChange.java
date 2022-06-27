package leetcode;

import java.util.Arrays;

public class Medium322CoinChange {
    /**
     * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
     * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回-1 。
     * 你可以认为每种硬币的数量是无限的。
     *
     * 示例1：
     *
     * 输入：coins = [1, 2, 5], amount = 11
     * 输出：3
     * 解释：11 = 5 + 5 + 1
     * 示例 2：
     *
     * 输入：coins = [2], amount = 3
     * 输出：-1
     * 示例 3：
     *
     * 输入：coins = [1], amount = 0
     * 输出：0
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/coin-change
     * @param amount
     * @param coins
     * @return
     */
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
