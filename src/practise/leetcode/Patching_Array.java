package practise.leetcode;

import java.util.Random;

// 330. Patching Array
public class Patching_Array {
	public int minPatches(int[] nums, int n) {
        long maxSum=0;
        int i=0;
        int patches=0;
        Random r=new Random();
        //int x=r.nextInt
        while(maxSum<n){
            if(i<nums.length&&nums[i]<=maxSum+1){
                maxSum+=nums[i];
                i++;
            }else{
                patches++;
                maxSum+=maxSum+1;
            }
        }
        return patches;
    }
}