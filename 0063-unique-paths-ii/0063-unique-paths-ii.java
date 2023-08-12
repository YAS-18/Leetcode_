class Solution {
    int paths(int i ,int j , int n , int m , int[][] grid , int[][] dp){
        
        if(i<n && j<m && grid[i][j] == 1)
          return 0;
        if(i>=n || j>=m)
         return 0;  
        if(i == n-1 && j == m-1) 
          return 1;
        if(dp[i][j] != -1)
          return dp[i][j];
        
        int right = paths(i+1,j,n,m,grid,dp);
        int down = paths(i,j+1,n,m,grid,dp);

        return (dp[i][j] = right + down);   
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int dp[][] = new int[n][m];

        for(int []rows:dp)
          Arrays.fill(rows,-1);
        return paths(0 , 0 , n , m , obstacleGrid , dp);
    }
}