package CTCI.ArraysAndStrings;

public class ReverseCStyleString {

	String reverse(String str) {
		int idx = str.indexOf('\\') - 1;
		System.out.println(idx);
		char[] string = new char[str.length()];
		int i = 0;
		while(i < idx) {
			string[i] = str.charAt(idx);
			string[idx] = str.charAt(i);
			System.out.println(string[i] + "," + string[idx]);
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
