package arrays;

import java.util.HashSet;

public class Array{
	
	public int sumDivisors (int n) {
	    int sum = 1;
		int sqrt = Math.sqrt(n);
	    for (int i = 2; i <= sqrt; i++){
		    if (n % i == 0) {
			    sum += i;
				if (n/i != i) {
				    sum += n/i;
				}
			}
		}
		return sum;
	}
	
    public int amicablePairs (ArrayList<Integer> a) {
	    HashSet<Integer> hs = new HashSet<Integer>();
		int count = 0;
		for (int i = 0; i < a.size(); i++) {
			hs.put(a.get(i));
		}
		for (int i = 0; i < a.size()-1; i++) {
			int val = sumDivisors(a.get(i));
			if (hs.get(val) != null){
			    count++;
			}
		}
		return count;
	}
}