package practise.leetcode;

public class Search_in_Rotated_Sorted_Array {
/*	 public boolean search(int[] nums,int target) {
	        if(nums==null || nums.length==0)
	             return false;
	         if(nums.length==1){             
	             if(nums[0]==target)
	                 return true;
	             else return false;
	         }
	        int pivot =  findPivot(nums,0,nums.length-1);
	        
	        System.out.println("Pivot Element : " + pivot);
	        int left=0,right=0;
	        
	        if(pivot ==-1){
	        	left=0;
	        	right=nums.length-1;
	        }
	        else if (nums[pivot]==target)
	        	return true;
	        //If target lies in second sorted array.
	        else if(target>=nums[pivot+1] && target<=nums[nums.length-1]){
	        	left=pivot+1;
	            right=nums.length-1;        	
	        }
	        //If target lies in first sorted array.
	        else if(target>=nums[0] && target<=nums[pivot]){
	        	left=0;right=pivot;
	        }
	        int location = -1;
	        while(left<=right){
	        	int mid=(left+right)/2;
	        	if(nums[mid]==target){
	        		location = mid;
	        		break;
	        	}
	        	else if(target<nums[mid])
	        		right=mid-1;
	        	else left=mid+1;
	        }
	        return (location>-1?true:false);
	    }
	    public  int findPivot(int[] num,int left,int right){
	    	
	    	int mid = (left+right)/2;
	    	
	    	//Pivot found
	    	if(mid<right && num[mid]>num[mid+1])
	    		return mid;
	    	
	    	if(mid>left && num[mid]<num[mid-1])
	    		return mid-1;
	    	
	    	//If pivot is on the left
	    	if(num[mid]<=num[left])
	    		return findPivot(num, left, mid-1);
	    	else if(num[mid]>num[right]) return findPivot(num, mid+1, right);
	     }
	    */
	    public boolean searchNonPivoted(int nums[],int target){
	    	return searchNonPivotedRecursiveHelper(nums, 0, nums.length-1, target);	    	
	    }
		private boolean searchNonPivotedRecursiveHelper(int[] nums, int start, int end, int target) {
			if(start>end)
				return false;
			
			int mid = (start + end)/2;
			
	    	if(nums[mid]==target)
	    		return true;
	    	
	    	//Means left side of the mid is a sorted array.
	    	if(nums[mid]>nums[start]){
	    		if(target>=nums[start] && target<=nums[mid]){
	    			end = mid-1;
	    		}
	    		else start = mid+1;
	    	}
	    	
	    	//Means right side of the mid is a sorted array.
	    	else if(nums[mid]<nums[start]){
	    		if(target>=nums[mid+1] && target<=nums[end]){
	    			start = mid+1;
	    		}
	    		else end = mid-1;
	    	}
	    	else if(nums[start]==nums[mid])
	    		start++;
	    	return searchNonPivotedRecursiveHelper(nums, start, end, target);
		}
		public boolean searchNonPivotedHelper(int nums[],int start ,int end,int target){
			     while(start<=end){
			    	int mid = (start+end)/2;
			    	
			    	if(nums[mid]==target)
			    		return true;
			    	
			    	//Means left side of the mid is a sorted array.
			    	if(nums[mid]>nums[start]){
			    		if(target>=nums[start] && target<=nums[mid]){
			    			end = mid-1;
			    		}
			    		else start = mid+1;
			    	}
			    	
			    	//Means right side of the mid is a sorted array.
			    	else if(nums[mid]<nums[start]){
			    		if(target>=nums[mid+1] && target<=nums[end]){
			    			start = mid+1;
			    		}
			    		else end = mid-1;
			    	}
			    	else if(nums[start]==nums[mid])
			    		start++;
			     }
			     return false;
           }
		
	    public static void main(String[] args) {
			Search_in_Rotated_Sorted_Array search = new Search_in_Rotated_Sorted_Array();
			System.out.println(search.searchNonPivoted(new int[]{1,1,1,1,1,1,1,1,2,1,1},2));
		}
}