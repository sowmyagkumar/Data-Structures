package dp;

public class LongestIncreasingSubsequence{

public static int lis(int[] arr){
    int n = arr.length;
	int[] lis = new int[n];
	int maxLis = Integer.MIN_VALUE;
	for(int i = 0; i < n; i++){
	    lis[i] = 1;
	}
	for(int i = 0; i < n; i++){
	    for(int j = i-1; j >=0; j--){
		    if(arr[j] < arr[i] && lis[j]+1 > lis[i]){
			    lis[i] = lis[j] + 1;
			}
		}
		maxLis = Math.max(maxLis, lis[i]);
	}
	return maxLis;
}

public static void main(String[] args){
    int[] arr = new int[]{3, 10, 2, 1, 20};
	System.out.println(lis(arr));
}

}