package dp;

public class UglyNumbers{

public static int ugly(int n){
    int[] dp = new int[n];
	int k1 = 0; 
	int k2 = 0;
	int k3 = 0;
	int t1 = 2, t2 = 3, t3 = 5;
	dp[0] = 1;
	int val = 0;
	for(int i = 1; i < n; i++){
	    val = Math.min( t1, Math.min( t2, t3));
		dp[i] = val;
		if( val == t1){
		    k1++;
			t1 = 2*dp[k1];
		}
		if(val == t2){
		    k2++;
			t2 = 3*dp[k2];
		}
		if(val == t3){
		    k3++;
			t3 = 5*dp[k3];
		}
		dp[i] = val;
	}
	
	return dp[n-1];
}

public static void main(String[] args){
    System.out.println(ugly(150));
}
}