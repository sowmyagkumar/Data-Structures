package dp;

public class Partition{

public static boolean partition(int[] arr){
    int n = arr.length;
	int sum = 0;
	for(int i = 0; i < n; i++){
	    sum += arr[i];
	}
	if(sum % 2 != 0)
	    return false;
	int s = sum / 2;
	boolean[][] dp = new boolean[s+1][n];
	
	for(int i = 0; i <= s; i++){
	    dp[i][0] = false;
	}
	for(int i = 0; i <n; i++){
	    dp[0][i] = true;
	}
	for(int i = 1; i <= s; i++){
	    for(int j = 1; j < n; j++){
			if(i >= arr[j]){
			    dp[i][j] = dp[i-arr[j]][j-1] || dp[i][j-1];
			}else{
			    dp[i][j] = dp[i][j-1];
			}
		} 
	}
	return dp[s][n-1];
}

public static void main(String[] args){
    int[] arr = new int[]{3, 1, 5, 9, 12};
	System.out.println(partition(arr));
}
}