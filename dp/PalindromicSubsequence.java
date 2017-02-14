package dp;

public class PalindromicSubsequence{
    public static int palindrome(String s){
	    int n = s.length();
		int[][] dp = new int[n][n];
		
		for(int i = n-1; i >= 0; i--){
		    for(int j = i; j <= n-1; j++){
			    if( i == j){
				    dp[i][j] = 1;
					continue;
			    }
				if(s.charAt(i) == s.charAt(j)){
				    dp[i][j] = 2 + dp[i+1][j-1];
				}else{
				    dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
				}
			} 
		}
		return dp[0][n-1];
	}

	public static void main(String[] args){
	    System.out.println(palindrome("BBABCBCAB"));
	}
}