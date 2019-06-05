package practise.leetcode;

import java.util.PriorityQueue;

public class Find_Kth_Largest_Element_In_An_Array {
	 public int findKthLargest(int[] nums, int k) {
	        PriorityQueue queue = new PriorityQueue();
	        
	        for(int i=0;i<nums.length;i++){
	            queue.add(nums[i]);            
	        }
	        
	       for(int i=1;i<nums.length-1-k;i++){
	            queue.remove();
	        }
	        return ((Integer)queue.peek()).intValue();
	    }
}


//QuickSort solution. : 6%

/*class Solution {
    public int findKthLargest(int[] nums, int k) {
       sort(nums,0,nums.length-1);
        return nums[nums.length-k];
    }
    
    int partition(int arr[], int low, int high) 
	{ 
		int pivot = arr[high]; 
		int i = (low-1); // index of smaller element 
		for (int j=low; j<high; j++) 
		{ 
			// If current element is smaller than or 
			// equal to pivot 
			if (arr[j] <= pivot) 
			{ 
				i++; 

				// swap arr[i] and arr[j] 
				int temp = arr[i]; 
				arr[i] = arr[j]; 
				arr[j] = temp; 
			} 
		} 

		// swap arr[i+1] and arr[high] (or pivot) 
		int temp = arr[i+1]; 
		arr[i+1] = arr[high]; 
		arr[high] = temp; 

		return i+1; 
	} 


	/* The main function that implements QuickSort() 
	arr[] --> Array to be sorted, 
	low --> Starting index, 
	high --> Ending index */
/*	void sort(int arr[], int low, int high) 
	{ 
		if (low < high) 
		{ 
			/* pi is partitioning index, arr[pi] is 
			now at right place */
//			int pi = partition(arr, low, high); 

			// Recursively sort elements before 
			// partition and after partition 
	//		sort(arr, low, pi-1); 
		/*	sort(arr, pi+1, high); 
		} 
	} 
}*/
