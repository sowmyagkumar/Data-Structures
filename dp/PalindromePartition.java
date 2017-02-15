package dp;

public class PalindromePartition{
	
	public static int partition(String s){
		int n = s.length();
		int[][] p = new int[n][n];
		int[][] dp = new int[n][n];
		
		for(int i = n-1; i >= 0; i--){
			for(int j = i; j <= n-1; j++){
				if(i == j){
					p[i][j] = 1;
				}else{
					if(j == i+1){
						p[i][j] = (s.charAt(i) == s.charAt(j))? 1 : 0;
					}else{
						if(s.charAt(i) == s.charAt(j)){
							p[i][j] = p[i+1][j-1];
						}else{
							p[i][j] = 0;
						}
					}
				}
				if(p[i][j] == 1){
					dp[i][j] = 0;
				}else{
					dp[i][j] = Integer.MAX_VALUE;
					for(int k = i; k < j; k++){
						dp[i][j] = Math.min(dp[i][j], dp[i][k]+dp[k+1][j]+1);
					} 
				}
			}
		}
		return dp[0][n-1];
	}
	
	public static void main(String[] args){
		System.out.println(partition("ababbbabbababa"));
	}
	
}