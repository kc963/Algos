package CTCI.ArraysAndStrings;

import java.util.HashSet;

public class UniqueCharacterString {

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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "hello";
		UniqueCharacterString obj = new UniqueCharacterString();
		System.out.println(obj.check(str));
		System.out.println(obj.checkwithoutextraspace(str));
		
	}

}
