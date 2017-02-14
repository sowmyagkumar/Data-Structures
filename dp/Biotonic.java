package dp;

public class Biotonic{
    public static int biotonic(int[] arr){
	    int n = arr.length;
		int[] inc = new int[n];
		int[] dec = new int[n];
		
		for(int i = 0; i < n; i++){
		    inc[i] = 1;
		    for(int j = 0; j < i; j++){
			    if(arr[j] < arr[i]){
				    inc[i] = Math.max(inc[j]+1, inc[i]);
				}
			}
		}
		
		for(int i = n-1; i >= 0; i--){
		    dec[i] = 1;
			for(int j = n-1; j > i; j--){
			    if(arr[i] > arr[j]){
				    dec[i] = Math.max(dec[j]+1, dec[i]);
				}
			}
		}
		int val = 0;
		for(int i = 0; i < n; i++){
		    val = Math.max(inc[i] + dec[i] -1, val);
		}
		return val;
	}
	
	public static void main(String[] args){
	    int[] arr = new int[]{12, 11, 40, 5, 3, 1};
	    System.out.println(biotonic(arr));
	}
}