package Practice;

import java.util.LinkedList;

public class DictionarySubsequence {

	QuickSort qs;
	
	DictionarySubsequence(){
		qs = new QuickSort();
	}
	
	String execute(String S, LinkedList<String> D) {
		String answer = "";
		D = (LinkedList<String>) qs.sortStrings(D, false);
		for(String d : D) {
			answer = checker(S,d, answer) ? d : answer;
			if(answer.length() > 0) {
				break;
			}
		}
		return answer;
	}
	
	boolean checker(String s, String d, String lastanswer) {
		String str = lcs(s,d);
		if(str.equals(d)) {
			if(str.length() > lastanswer.length()) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	
	String lcs(String s, String d) {
		//System.out.println("start of lcs : " + s + " , " + d);
		if(s.length() < d.length() || s.length() == 0) {
			return "";
		}
		//System.out.println("lcs : " + s + " , " + d);
		String ans = "";
		if(d.charAt(0) == s.charAt(0)) {
			ans += d.charAt(0) + lcs(s.substring(1), d.substring(1));
		}else {
			ans += lcs(s.substring(1), d);
		}
		return ans;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String S = "abppple";
		LinkedList<String> D = new LinkedList<String>();
		D.add("able");
		D.add("ale");
		D.add("apple");
		D.add("bale");
		D.add("kangaroo");
		DictionarySubsequence ds = new DictionarySubsequence();
		System.out.println(ds.execute(S, D));
		
		
	}

}
