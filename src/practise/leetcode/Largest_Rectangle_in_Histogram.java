package practise.leetcode;

public class Largest_Rectangle_in_Histogram {
   public static int largestRectangleArea(int[] heights) {
        int maxHeight = 0,num,height=0;
        int leftHeight = 0,rightHeight = 0;
        
        for(int i=0;i<=heights.length-1;i++){
        	num = heights[i];
        	height=num;
        	for (int j = i-1;j>=0 ; j--) {
				if(heights[j]>=num)
					leftHeight+=num;
				else if(heights[j]<num)
					break;
			}
        	
        	for (int j = i+1;j<=heights.length-1 ; j++) {
				if(heights[j]>=num)
					rightHeight+=num;
				else if(heights[j]<num)
					break;
			}
        	height+=leftHeight+rightHeight;
        	leftHeight=0;rightHeight=0;
        	if(maxHeight<height)
        		maxHeight=height;
        }
        return maxHeight;
    }
   
   public static int largestRectangleAreaHelper(int[] heights,int start,int end) {
       if(start>end)
		   return 0;
       
       int minHeight=heights[start];
       int minHeightIndex=start;                             
                       
       for(int i=start;i<=end;i++){
           if(minHeight>heights[i]){
               minHeight=heights[i];
               minHeightIndex=i;
           }
       }
       
        int maxArea = minHeight*(end-start+1);
         return Math.max(maxArea,
                         Math.max(largestRectangleAreaHelper(heights,start,minHeightIndex-1),
                         largestRectangleAreaHelper(heights,minHeightIndex+1,end)));
   }
   public static void main(String[] args) {
	   int arr[]={2,1,5,6,2,3};
	   System.out.println(largestRectangleAreaHelper(arr,0,arr.length-1));
}
}
