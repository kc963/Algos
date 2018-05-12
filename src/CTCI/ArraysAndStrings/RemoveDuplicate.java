package CTCI.ArraysAndStrings;

public class RemoveDuplicate {

	//Time O(n), Space O(1)
	int startRemoving(char[] array) {
		int checker = 0, check = 0;
		for(int i=0; i<array.length; i++) {
			int x = array[i] - 'a';
			if((checker & (1 << x)) == 0) {
				checker |= (1 << x);
			}else {
				check |= (1 << x);
			}
		}
		int index = 0;
		for(int i=0; i<array.length; i++) {
			int x = array[i] - 'a';
			if((check & (1 << x)) == 0) {
				array[index++] = array[i];
			}
		}
		return index;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "helloeveryone";
		char[] array = str.toCharArray();
		RemoveDuplicate obj = new RemoveDuplicate();
		String answer = "";
		int index = obj.startRemoving(array);
		for(int i=0; i<index; i++) {
			answer += array[i];
		}
		System.out.println(answer);
		
	}

}
