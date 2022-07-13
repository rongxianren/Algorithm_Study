package com.rongxianren.algorithm.recurion;

import java.util.HashSet;
import java.util.Set;

public class TotalPermutationOfString {
	private static Set<String> sResultSet = new HashSet<String>();
	public static void main(String[] args){
		String testStr = "abcd";
		totalPermutation(testStr.toCharArray(), 0);
		for (String value : sResultSet) {
			System.out.println(value);
		}
	}

	private static void totalPermutation(char[] charArray, int index){
		if( index>=charArray.length-1){
//			System.out.println(charArray);
			sResultSet.add(new String(charArray));
			return;
		}
		for(int i= index; i<charArray.length; i++){
			swapChar(charArray, index, i);
			totalPermutation(charArray, index+1);
			swapChar(charArray, i, index);
		}
	}

	private static void swapChar(char[] charArray, int right, int left){
		char temp = charArray[right];
		charArray[right] = charArray[left];
		charArray[left] = temp;
	}
}
