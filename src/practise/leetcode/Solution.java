package practise.leetcode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class Solution {
    public static int kInversePairs(int n, int k) {
        if(k==0)
            return 1;
        if(n==1 && k==1)
            return 0;

        
        StringBuffer str=new StringBuffer();
        for(int i=1;i<=n;i++){
            str.append(i+"");
        }
        return brute_force_approach(str.toString(),k);
    }
    
    public static Set set = new HashSet();//123,""
	public static void findAllPermutations(String string,String current){
		if(string.length()==0){
			//For duplicacy
			if(!set.contains(current)){   
				set.add(current);
            }
			return;
		}
		
		for (int i = 0; i < string.length(); i++) {		
			findAllPermutations(string.substring(0,i)+string.substring(i+1),current+string.charAt(i));
		}
	}
    
    public static int brute_force_approach(String str,int k){
		findAllPermutations(str, "");
		int count=0;
        //System.out.print(set+" ");
        Set set = Solution.set;
		for (Iterator iterator = set.iterator(); iterator.hasNext();) {
			String object = (String) iterator.next();            
            
			if(findIf_K_Inverse_Pairs_Exist(object, k))
				count++;
		}
		System.out.println(count);
        return count;
	}
	
	private static boolean findIf_K_Inverse_Pairs_Exist(String perm,int k){
		int count=0;
		for(int i=0;i<perm.length();i++){
			int curr =Integer.parseInt(perm.charAt(i)+"");
			for (int j = i+1; j < perm.length(); j++) {
				int ele = Integer.parseInt(perm.charAt(j)+"");
				if(curr>ele)
					count++;
				if(count>k)
					return false;
			}
		}
		return count==k;
	}
	public static void main(String[] args) {
		kInversePairs(2, 1);
	}
}