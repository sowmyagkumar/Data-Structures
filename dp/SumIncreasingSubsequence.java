package dp;

public class SumIncreasingSubsequence{

    public static int sum(int[] arr){
	    int len = arr.length;
		int[] dp = new int[len];
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < len; i++){
		    dp[i] = arr[i];
		    for(int j = 0; j < i; j++){
			    if(arr[i] > arr[j]){
					dp[i] = Math.max(dp[i], dp[j] + arr[i]);
				}
			}
			max = (max < dp[i])? dp[i] : max;
		}
		return max;
	}

	public static void main(String[] args){
	int[] arr = new int[]{1, 101, 2, 3, 100, 4, 5};
	    System.out.println(sum(arr));
	}
}