package practise.leetcode;

public class Remove_Duplicates_from_Sorted_Array {
	public static int removeDuplicates(int[] nums) {
		if(nums.length==1)
            return 1;
        if(nums==null||nums.length==0)
            return 0;
       int j=0,pos=0;
		for(int i=0;i<nums.length;i++){
            j=i;
            while((i+1)<=nums.length-1 && nums[i]==nums[i+1]){
                i++;
            }
            if(i<nums.length-1 && j!=i){
                nums[++pos]=nums[++i];
            }
            else if(i<nums.length-1 && j==i){
                pos++;
                nums[pos]=nums[++i];
            }
		}
        return pos+1;
	}
	public static void main(String[] args) {
		int []x = new int[]{1,2,};
		int length = removeDuplicates(x);
		System.out.println(length);
		for (int i = 0; i <=length-1; i++) {
			System.out.println(x[i]);
		}
	}
}
