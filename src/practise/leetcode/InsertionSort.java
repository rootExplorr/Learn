package practise.leetcode;

public class InsertionSort {
		/*Function to sort array using insertion sort*/
		void sort(int nums[]) 
		{ 
			int indx=-1,j;
		for(int i=0;i<nums.length;i++){   
	   j=i-1;
	   indx=i;
	   int value=nums[i];
	   while(j>=0 && nums[j]>value){
		   nums[j+1]=nums[j];
		   j--;
	   }
	   nums[j+1]=value; 
		} 
	    }

		/* A utility function to print array of size n*/
		static void printArray(int arr[]) 
		{ 
			int n = arr.length; 
			for (int i = 0; i < n; ++i) 
				System.out.print(arr[i] + " "); 

			System.out.println(); 
		} 

		static void mergeSort(int nums[],int start,int end){
			int mid = (start+end)/2;
			/*if(start==end)
				return new int[]{nums[start]};*/
			if(start>=end)
				return;
			mergeSort(nums, start, mid);
			mergeSort(nums, mid+1, end);
			merge(nums,start,mid,end);
		}
		private static int[] merge(int[] nums,int start,int mid, int end) {
			int[] merge1=new int[mid-start+1];
			int[] merge2=new int[end-mid];
			
			for(int i=0;i<=(mid-start);i++){
				merge1[i]=nums[start+i];
			}
			
			for(int i=0;i<merge2.length;i++){
				merge2[i]=nums[mid+i+1];
			}
			
			int i=0,j=0,indx=start;
			
			while(i<=merge1.length-1 && j<=merge2.length-1){
				if(merge1[i]>=merge2[j])
					nums[indx++]=merge2[j++];
				else nums[indx++]=merge1[i++];
			}
			
			if(i<merge1.length){
				for(;i<=merge1.length-1;i++)
					nums[indx++]=merge1[i];
			}
			
			else if(j<merge2.length){
				for(;j<=merge2.length-1&& (i+j)<=(end-start);j++)
					nums[indx++]=merge2[j];
			}
			
			return nums;			
		}

		// Driver method 
		public static void main(String args[]) 
		{ 
			int arr[] = { 12, 11, 13, 5, 6 ,1}; 

			//InsertionSort ob = new InsertionSort(); 
			mergeSort(arr, 0,arr.length-1);
			printArray(arr); 
		} 
	} 
