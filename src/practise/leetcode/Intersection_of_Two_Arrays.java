package practise.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Intersection_of_Two_Arrays {
	//Brute force solution
	public int[] intersection(int[] nums1, int[] nums2) {
        int k;
        List intersection = new ArrayList();
        for(int l=0;l<nums1.length;l++){
            k=nums1[l];
            for(int m=0;m<nums2.length;m++){
                if(nums2[m]==k && !intersection.contains(k)){
                    intersection.add(k);
                    break;
                }
            }
        }
        int arr[]=new int[intersection.size()];
        for(k=0;k<intersection.size();k++)
            arr[k]=(int)intersection.get(k);
        return arr;
    }
	
	//Hashmap solution
	public int[] intersectionUsingHashMap(int[] nums1, int[] nums2) {
		Map map = new HashMap();
		for(int i=0;i<nums1.length;i++){
			map.put(nums1[i],i);
		}
		
		List list = new ArrayList();		
		for (int i = 0; i < nums2.length; i++) {
			if(map.containsKey(nums2[i])){
				list.add(nums2[i]);
			}
		}
		
		int[] arr = new int[list.size()];
		int index=0;
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			int intValue = (int) iterator.next();
			arr[index]=intValue;
		}
		return arr;
	}
}