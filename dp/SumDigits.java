package dp;

public class SumDigits{

    public static int sumOfDigitsUtil(int n){
	    int sum = 0;
		while(n > 0){
		    sum += n%10;
			n = n/10;
		}
		return sum;
	}
    
	public static int sumOfDigits(int n){
	    if(n<10){
		    return n*(n+1)/2;
		}
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;
		for(int i = 2; i <= n; i++){
		    if(i%10 != 0){
			    dp[i] = 2*dp[i-1] - dp[i-2] + 1;
			}else{
			    dp[i] = dp[i-1] + sumOfDigitsUtil(i);
			}
		}
		return dp[n];
	}
    
	public static void main(String[] args){
	    System.out.println(sumOfDigits(328));
	}

}