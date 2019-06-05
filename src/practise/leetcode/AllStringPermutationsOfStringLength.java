package practise.leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class AllStringPermutationsOfStringLength {
	public static Set set = new TreeSet();
	public static void main(String[] args) {
		findAllPermutations("abc","");
		System.out.println(set);
	}
	
	public static void findAllPermutations(String string,String current){
		if(string.length()==0){
			set.add(current);
			return;
		}
		
		for (int i = 0; i < string.length(); i++) {
			findAllPermutations(string.substring(0,i)+string.substring(i+1),current+string.charAt(i));
		}
	}
}