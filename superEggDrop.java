// Problem1: Super Egg Drop (https://leetcode.com/problems/super-egg-drop/)

// Time Complexity : O(nk) 
// Space Complexity : O(nk)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, max no.of attempts possible are n in worst case so lets try to fill matrix of attempts on rows and eggs on columns with max floors
 * can be reached. If dp[attempts][k] reaches n then return attempts.
 */
//1
class Solution {
    public int superEggDrop(int k, int n) {
        int [][] dp = new int[k+1][n+1];
        for(int j = 1; j <= n ; j++){
            dp[1][j] = j;
        }
        for(int i = 2; i <= k ; i++){
            for(int j = 1; j <= n; j++ ){
                dp[i][j] = 999999;
                for(int f = 1; f <= j; f++){
                    //kth is made attempt from
                    int curr = 1 + Math.max(dp[i-1][f-1], dp[i][j-f]);
                    dp[i][j] = Math.min(dp[i][j], curr);
                }
            }
        }
        return dp[k][n];
    }
}
// 2
class Solution {
    public int superEggDrop(int k, int n) {
        int [][] dp = new int[n+1][k+1];
        int attempts = 0;
        while(dp[attempts][k] < n){
            attempts++;
            for(int j = 1; j <= k; j++){
                dp[attempts][j] = 1 + dp[attempts-1][j-1] + dp[attempts-1][j]; 
            }
        }
        return attempts;
    }
}