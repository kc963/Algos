package CTCI.ArraysAndStrings;

public class ReverseCStyleString {

	//Time O(n), Space O(n)
	String reverse(String str) {
		int idx = str.indexOf('\\') - 1;
		char[] string = new char[str.length()];
		int i = 0;
		while(i < idx) {
			string[i] = str.charAt(idx);
			string[idx] = str.charAt(i);
			i++;
			idx--;
		}
		if(i == idx) {
			string[i] = str.charAt(i);
		}
		string[string.length-2] = '\\';
		string[string.length-1] = '0';
		return new String(string);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "hello\\0";
		ReverseCStyleString obj = new ReverseCStyleString();
		System.out.println(obj.reverse(str));
		
	}

}
