import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int noT=1; noT<=T; noT++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			int[] arr2 = new int[n];
			for(int i=0; i<n; i++) {
				int x = sc.nextInt();
				arr[i] = x;
				arr2[i] = x;
			}
			boolean done = false;
			while(!done) {
				done = true;
				for(int j=0; j<arr.length-2; j++) {
					if(arr[j] > arr[j+2]) {
						done = false;
						int temp = arr[j+2];
						arr[j+2] = arr[j];
						arr[j] = temp;
					}
				}
			}
			Arrays.sort(arr2);
			int idx = -1;
			for(int i=0; i<arr.length; i++) {
				++idx;
				if(arr[i] != arr2[i]) {
					break;
				}
			}
			if(idx != arr.length-1) {
				System.out.println("Case #" + noT + ": " + idx);
				continue;
			}else
				System.out.println("Case #" + noT + ": OK");
		}
	}
	
}
