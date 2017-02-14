package dp;

public class EggDrop{

public static int egg(int n, int k){
    int[][] dp = new int[n+1][k+1];
	for(int i = 0; i <= n; i++){
	    for(int j = 0; j <= k; j++){
			
		    if( i == 0)
				continue;
			if(j==0||j == 1 || i==1){
			    dp[i][j] = j;
				continue;
			}
		
			dp[i][j] = Integer.MAX_VALUE;
			for(int l = 1; l <= j; l++){
			    dp[i][j] = Math.min(1+Math.max(dp[i-1][l-1], dp[i][j-l]), dp[i][j]);
			}
		}
	}
	return dp[n][k];
}

public static void main(String[] args){
    System.out.println(egg(2, 36));
}

}