package practise.leetcode;

import java.security.AllPermission;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class K_Inverse_Pairs_Array {
	public static Set set = new HashSet();
	public static void findAllPermutations(String string,String current){
		if(string.length()==0){
			//For duplicacy
			if(!set.contains(current))
				set.add(current);
			return;
		}
		
		for (int i = 0; i < string.length(); i++) {
			findAllPermutations(string.substring(0,i)+string.substring(i+1),current+string.charAt(i));
		}
	}
	
	public static int brute_force_approach(String str,int k){
		findAllPermutations(str, "");
		Set set = K_Inverse_Pairs_Array.set;
		int count=0;
		System.out.println(set);
		for (Iterator iterator = set.iterator(); iterator.hasNext();) {
			String object = (String) iterator.next();
			if(findIf_K_Inverse_Pairs_Exist(object, k)){
				count++;
			}
		}
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
		int n=2;
		StringBuffer str = new StringBuffer();
		 for(int i=1;i<=n;i++){
	            str.append(i+"");
	        }
		 
		System.out.println(brute_force_approach(str.toString(),1));
	}
}
