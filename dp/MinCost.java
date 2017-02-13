package dp;

public class MinCost{

public static int minCost(int[][] cost){
    int m = cost.length;
	int n = cost[0].length;
	int[][] dp = new int[m][n];
	for(int i = 0; i < m; i++){
	    for(int j = 0; j < n; j++){
		    if( i == 0 && j == 0){
			    dp[i][j] = cost[i][j];
				continue;
			}
			if(i == 0){
			    dp[i][j] = dp[i][j-1] + cost[i][j];
				continue;
			}
			if(j == 0){
			    dp[i][j] = dp[i-1][j] + cost[i][j];
				continue;
			}
			dp[i][j] = cost[i][j] + Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]) ;
		}
	}
	return dp[m-1][n-1];
}

public static void main(String[] args){
	int cost[][] = {{1, 2, 3},{4, 8, 2},{1, 5, 3}};
	System.out.println(minCost(cost));				 
}
}