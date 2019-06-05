package practise.leetcode;

//238. Product of Array Except Self
public class Product_of_Array_Except_Self {
	public int[] productExceptSelf(int[] nums) {
		  int n = nums.length;
	        if(n==0)
	            return nums;
	        //Each index stores , product till that index.
	        int left[]=new int[n];
	        int right[]=new int[n];
	        
	        left[0]=1;
	        right[n-1]=1;
	        
	        for(int i=1;i<n;i++){
	            left[i]=left[i-1]*nums[i-1];
	        }
	        
	        for(int i=n-2;i>=0;i--){
	            right[i]=right[i+1]*nums[i+1];
	        }
	        
	        for(int i=0;i<n;i++){
	            nums[i]=left[i]*right[i];
	        }
	        return nums;
}
}
