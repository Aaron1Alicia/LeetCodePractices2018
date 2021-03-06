package advanced.chaptersix.optional;

public class BackPackFive {

    // It is possible to reduce to one dimension array
    // O(n*m)
    public int backPackV(int[] nums, int target) {
        if(nums==null || nums.length==0) {
            return 0;
        }

        int n = nums.length;

        int[][] dp = new int[n+1][target+1];
        dp[0][0] = 1;
        for(int i=1; i<=target; i++) {
            dp[0][i] = 0;
        }

        for(int i=1; i<=n; i++) {
            dp[i][0] = 1;
            for(int j=1; j<=target; j++) {
                dp[i][j] = dp[i-1][j];

                if(j>=nums[i-1]) {
                    dp[i][j] +=dp[i-1][j-nums[i-1]];
                }
            }
        }

        return dp[n][target];
    }
}
