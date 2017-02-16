package dp;

public class MinJumps{

public static int minJumps(int[] arr){
    int n = arr.length;
    int[] dp = new int[n];
	dp[0] = 0;
	for(int i = 1; i<n; i++)
		dp[i] = Integer.MAX_VALUE;
	for(int i = 0; i < n; i++){
		for(int j = 1; j <= arr[i] && i+j < n ; j++){
			int k = i + j;
			dp[k] = Math.min( dp[k], dp[i] + 1);
		}
	}
	for(int i = 0; i< n; i++)
		System.out.println(dp[i]+"  ");
	return dp[n-1];
}

public static void main(String[] args){
    int[] arr = new int[]{1, 3, 6, 3, 2, 3, 6, 8, 9, 5};
    System.out.println(minJumps(arr));
}

}