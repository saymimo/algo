package dp;

public class ZeroOnePackage {
    public static void main(String[] args) {
        int[] wt = {2, 1, 3};
        int[] val = {4, 2, 3};
        System.out.println(maxVal(1,wt,val));
        System.out.println(maxVal(2,wt,val));
        System.out.println(maxVal(3,wt,val));
        System.out.println(maxVal(4,wt,val));
        System.out.println(maxVal(5,wt,val));
    }

    public static int maxVal(int W, int[] wt, int[] val) {
        // 物品数n
        int n = wt.length;
        // dp[i][j] 定义：重量j约束下，放下前i个物品的最大价值和
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 1; i <= n; i++) {
            // 当前物品的重量
            for (int j = 1; j <= W; j++) {
                // 当前比
                if (j < wt[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                }else {
                    int in = dp[i-1][j - wt[i-1]] + val[i-1];
                    dp[i][j] = Math.max(in, dp[i-1][j]);
                }

            }
        }
        return dp[n][W];
    }
}
