package practise.leetcode;

import java.util.*;
import java.lang.*;
import java.io.*;

public class MaximumOccurredInteger {
	public static void main (String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int testCaseCount = Integer.parseInt(br.readLine());
		
		int L[],R[];
		for(int i=1;i<=testCaseCount;i++){
		    int arraySize = Integer.parseInt(br.readLine());
		    //Left ranges
		    L=new int[arraySize];
		    String str[] = br.readLine().split(" ");
		    for(int i1=0;i1<str.length;i1++){
		        L[i1]=Integer.parseInt(str[i1]);
		    }
		    
		    //Right ranges
		    R=new int[arraySize];
		    str = br.readLine().split(" ");
		    for(int i1=0;i1<str.length;i1++){
		        R[i1]=Integer.parseInt(str[i1]);
		    }
		    System.out.println();
		    System.out.println(firstMaxOccurInt(L,R));
		}
	}	
	
	public static int firstMaxOccurInt(int[] L,int[] R){
	    int n = L.length,diff;
	    int maxRange=-1;
	    for(int i=0;i<n;i++){
	        diff = R[i]-L[i];
	        if(R[i]-L[i] > maxRange)
	             maxRange=diff;
	    }
	    return maxRange;
	}
 }
