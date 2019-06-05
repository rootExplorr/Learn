package practise.leetcode;

import java.util.Stack;

public class LargestAreaInHistogram {

	public static void main(String[] args) {
		int[] heights=new int[]{2,1,5,6,2,3};
		System.out.println(largestRectangleArea(heights));
	}
	
	   public static int largestRectangleArea(int[] heights) {
	        Stack<Integer> stack = new Stack<Integer>();
	        int area,tmp,maxArea=0;
	        for(int i=0;i<heights.length;i++){
	            if(stack.isEmpty() || heights[stack.peek()]<=heights[i]){
	                stack.push(i);
	            }
	            else{
	                while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
	                    tmp=stack.pop();	                   
	                    maxArea=Math.max(maxArea,(i-tmp)*heights[tmp]);
	                    
	                }
	                stack.push(i);
	            }
	        }
	        
	            while(!stack.isEmpty()){
	                tmp=stack.pop();
	                maxArea=Math.max(maxArea,(tmp-(stack.size()>0?stack.peek():-1))*heights[tmp]);
	            }
	        return maxArea;
	    }

}
