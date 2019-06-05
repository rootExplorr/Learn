package practise.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//349. Intersection of two array.
public class Intersection_of_two_array {
	    public int[] findIntersection(Set<Integer> set1,Set<Integer> set2){
	        int [] solution= new int[set2.size()];
	        int idx=0;
	        for(Integer i : set2){
	            if(set1.contains(i))
	                solution[idx++]=i;
	        }
	        return Arrays.copyOf(solution,idx);
	    }
	    
	    public int[] intersection(int[] nums1, int[] nums2) {             
	        Set<Integer> set1 = new HashSet<Integer>();        
	        Set<Integer> set2 = new HashSet<Integer>();        
	        for(int i=0;i<nums1.length;i++){
	            set1.add(nums1[i]);
	        }
	        
	        for(int i=0;i<nums2.length;i++){
	            set2.add(nums2[i]);
	        }
	        if(set1.size()>set2.size())
	            return findIntersection(set1,set2);
	        else return findIntersection(set2,set1);
	    }
}

//Inserting in Set removes duplicate element, and then contains operation runs in O(1) time.

