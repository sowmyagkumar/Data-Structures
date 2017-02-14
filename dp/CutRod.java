package dp;

public class CutRod{

	public static int cutRod(int[] arr, int[] val, int N, int L){
        int[] dp = new int[L+1];
		dp[0] = 0;
		for(int i = 1; i <= L; i++){
		    dp[i] = Integer.MIN_VALUE;
			for(int j = 0; j < N; j++){
			    if(i >= arr[j]){
				    dp[i] = Math.max(dp[i], dp[i-arr[j]] + val[j]);
				}
			}  
		}
		
		return dp[L];
	}

	public static void main(String[] args){
	    int[] arr = new int[]{1,2,3,4,5,6,7,8};
		int[] val = new int[]{1,5,8,9,10,17,17,20};
	    System.out.println(cutRod(arr, val, 8, 8));
	}
}