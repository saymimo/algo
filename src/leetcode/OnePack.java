package leetcode;

/**
 * @author 孙勇
 * @date 2023/3/2
 */
public class OnePack {
    public static void main(String[] args) {
        int[] wi = {1,2,3};
        int[] vi = {4,5,6};
        System.out.println(maxVal(5,wi,vi));
    }
    //weights {1, 2, 3}
    // vals   {4, 3, 5}
    public static int maxVal(int W, int[] weights, int[] vals) {
        int n = weights.length;
        // dp[i][j]含义：前i个物品装满j的最大价值
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (j < weights[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(vals[i - 1] + dp[i - 1][j - weights[i - 1]],dp[i - 1][j]);
                }
            }
        }

        return dp[n][W];
    }
}
