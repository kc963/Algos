package CTCI.ArraysAndStrings;

import java.util.HashSet;

public class UniqueCharacterString {

	//Time O(n), Space O(n), n -> number of characters in the string
	boolean check(String s) {
		HashSet<Character> set = new HashSet<Character>();
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(set.contains(c))
				return false;
			set.add(c);
		}
		return true;
	}
	
	//Time O(n^2), Space O(1)
	boolean checkwithoutextraspace(String s) {
		for(int i=0; i<s.length(); i++) {
			for(int j=i+1; j<s.length(); j++) {
				if(s.charAt(i) == s.charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}
	
	//Time O(n), Space O(1)
	boolean checkbitoperationsLowercase(String s) {
		s = s.toLowerCase();
		int x = 0, length = s.length();
		for(int i=0; i<length; i++) {
			int n = s.charAt(i) - 'a';
			if((x & (1 << n)) > 0) {
				return false;
			}else {
				x |= (1 << n);
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "hello";
		UniqueCharacterString obj = new UniqueCharacterString();
		System.out.println(obj.check(str));
		System.out.println(obj.checkwithoutextraspace(str));
		System.out.println(obj.checkbitoperationsLowercase(str));
		
	}

}
