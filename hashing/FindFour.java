package hashing;

import java.util.HashMap;

class Pair{
    int i, j;
	Pair(int i, int j){
	    this.i = i;
		this.j = j;
	}
}

public class FindFour{

    public static void findFour(int[] arr){
	    int n = arr.length;
		HashMap<Integer, Pair> map = new HashMap<Integer, Pair>();
		
		for(int i = 0; i < n; i++){
		    for( int j = i+1; j<n; j++){
			    int sum = arr[i] + arr[j];
				if(map.containsKey(sum)){
				    System.out.println("The two pairs are:("+arr[i]+","+arr[j]+") and ("+arr[map.get(sum).i]+","+arr[map.get(sum).j]+")");
					return;
				}else{
				    Pair p = new Pair(i, j);
				    map.put(sum, p);
				}
			}
		}
	}
	
    public static void main(String[] args){
	    int[] arr = {3, 4, 7, 1, 2, 9, 8};
		findFour(arr);
	}

}