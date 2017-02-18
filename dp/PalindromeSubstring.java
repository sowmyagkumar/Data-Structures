package dp;

public class PalindromeSubstring{

public static void palindrome(String s){
    int n = s.length();
	if(n == 0|| n == 1)
	    return;
	int k = 1;
	int start = 0;
	boolean[][] dp = new boolean[n][n];
	for( int i = n-1; i >=0 ; i--){
	    for(int j = i; j<n; j++){
		    if( i == j ){
			    dp[i][j] = true;
			}else{
			    if( i+1 == j){
				    dp[i][j] = (s.charAt(i) == s.charAt(j));
				}else{
				    dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i+1][j-1];
					if(dp[i][j] == true){
						if(k < j - i +1 ){
						    k = j - i + 1;
							start = i;
						}
					}
				}
			}
		}
	}
	System.out.println(s.substring(start, start + k));
}

public static void main(String[] args){
    palindrome("forgeeksskeegfor");	
}
}