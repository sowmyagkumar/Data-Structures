package dp;

public class Submatrix{

public static int submatrix(int[][] M){
    int m = M.length;
	int n = M[0].length;
	int max = Integer.MIN_VALUE;
    int[][] dp = new int[m][n];
	for(int i = 0; i < m; i++){
	    dp[i][0] = M[i][0];
	}
	for(int j = 0; j < n; j++){
	    dp[0][j] = M[0][j];
	}
	
	for(int i = 1; i < m; i++){
	    for(int j = 1; j < n; j++){
		    if(M[i][j] == 1){
		        dp[i][j] = Math.min(dp[i][j-1], Math.min(dp[i-1][j-1], dp[i-1][j]))+1;
			}else{
			    dp[i][j] = 0;
			}
			max = Math.max(max, dp[i][j]);
		}
	}
	return max;
}

public static void main(String[] args){
    int[][] M = new int[][]{{0, 1, 1, 0, 1}, {1, 1, 0, 1, 0}, {0, 1, 1, 1, 0}, {1, 1, 1, 1, 0}, {1, 1, 1, 1, 1}, {0, 0, 0, 0, 0}};
	System.out.println(submatrix(M));
}
}