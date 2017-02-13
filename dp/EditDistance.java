package dp;

public class EditDistance{
    public static int editDistance(String s1, String s2){
	    int len1 = s1.length();
		int len2 = s2.length();
		
		int[][] dp = new int[len1+1][len2+1];
		for(int i = 0; i <= len1; i++){
		    for(int j = 0; j <= len2; j++){
			    if(i == 0 && j == 0){
				    dp[i][j] = 0;
					continue;
				}
				if(i==0){
					dp[i][j] = 1+dp[i][j-1];
					continue;
				}
				if(j==0){
					dp[i][j] = 1+dp[i-1][j];
					continue;
				}
				if(s1.charAt(i-1) == s2.charAt(j-1)){
					dp[i][j] = dp[i-1][j-1];
				}else{
					dp[i][j] = 1+Math.min(Math.min(dp[i-1][j], dp[i][j-1]),dp[i-1][j-1]);
				}
			}
		}
		return dp[len1][len2];
	}
	
	public static void main(String[] args){
	    System.out.println(editDistance("sunday","saturday"));
	}
}