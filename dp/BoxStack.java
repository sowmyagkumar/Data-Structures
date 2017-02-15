package dp;

import java.util.Arrays;

public class BoxStack{

public static int stackBox(Box[] b){
	int count = 0;
	int n = b.length;
    Box[] boxes = new Box[3*n];
	int[] dp = new int[3*n];
	
	for(int i = 0; i < n; i++){
		boxes[3*i] = new Box(Math.max(b[i].length, b[i].breadth), Math.min(b[i].length, b[i].breadth), b[i].height);
		boxes[3*i + 1] = new Box(Math.max(b[i].breadth, b[i].height), Math.min(b[i].breadth, b[i].height), b[i].length);
		boxes[3*i + 2] = new Box(Math.max(b[i].height, b[i].length), Math.min(b[i].height, b[i].length), b[i].breadth);
	}
	Arrays.sort(boxes);
	
	for(int i = 0; i < 3*n; i++){
		dp[i] = boxes[i].height;
		for(int j = 0; j < i; j++){
			if(boxes[j].length < boxes[i].length && boxes[j].breadth < boxes[i].breadth){
				dp[i] = Math.max(dp[i], dp[j] + boxes[i].height);
			}
		}
		count = Math.max(count, dp[i]);
	} 
	return count;
}

public static void main(String[] args){
    Box[] b = new Box[]{new Box(4,6,7), new Box(1,2,3), new Box(4,5,6), new Box(10, 12, 32)};
    System.out.println(stackBox(b));
}
}

class Box implements Comparable<Box>{

int length;
int breadth;
int height;

Box(int length, int breadth, int height){
    this.length = length;
	this.breadth = breadth;
	this.height = height;
}

public int compareTo(Box b){
	return this.length* this.breadth - b.length* b.breadth;
}

}