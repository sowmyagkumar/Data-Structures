package dp;

public class LongestConsecutivePath{

    public static int findLen(int i, int j , char[][]M){
	    int[] row = {0, 0, -1, -1, -1, 1, 1, 1};
		int[] col = {-1, 1, -1, 0, 1, -1, 0, 1};
		int r = i, c = j;
		boolean b = false;
		for(int m = 0; m < 8; m++){
		    r = i + row[m];
			c = j + col[m]; 
			if(r>=0 && r<3 && c>=0 && c<3 && M[r][c]==(M[i][j]+1)){
			    b = true;
				break;
			}
		}
		if(b == true){
		    return 1+findLen(r,c,M);
		}
		return 1;
	}
    
	public static void main(String[] args){
	    char[][] M={{'a','c','d'},{'h','b','e'},{'i','g','f'}};
	    int i = 0, j =0; 
		boolean b = false;
		char start = 'e';
	    for(i=0; i<3; i++){
		    for(j=0; j<3; j++){
			    if(M[i][j] == start){
				    b = true;
					break;
				}
			}
			if(b == true)
			    break;
		}
		System.out.println(findLen(i, j, M));
		
	}
}