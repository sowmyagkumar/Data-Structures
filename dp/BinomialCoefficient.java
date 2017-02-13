package dp;

public class BinomialCoefficient{

public static int binomial(int n, int k){
    int[][] dp = new int[n+1][k+1];
	for(int i = 0; i <= n; i++){
	    for(int j = 0; j <= k; j++){
		    if(j == 0 || i == j){
			    dp[i][j] = 1;
				continue;
			}
			if(i < j){
			 break;
			}
			dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
		}
	}
	return dp[n][k];
}

public static void main(String[] args){
	System.out.println(binomial(5,2));
}

}