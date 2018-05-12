import java.util.Scanner;

public class Solution1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int nooftest=1; nooftest<=T; nooftest++) {
			int D = sc.nextInt();
			int swaps = 0;
			String sequence = sc.nextLine();
			char seq[] = sequence.toCharArray();
			int[] powarray = new int[seq.length];
			int noS = 0, noC=0, pow=1, damage=0;
			for(int i=0; i<seq.length; i++) {
				switch(seq[i]) {
				case 'S' : noS++;
					damage += pow;
					break;
				case 'C' : noC++;
					pow *= 2;
					break;
				}
				powarray[i] = pow;
			}
			if(D < noS) {
				System.out.println("Case #" + nooftest + ": IMPOSSIBLE");
				continue;
			}
			if(damage < D) {
				System.out.println("Case #" + nooftest + ": 0");
				continue;
			}
			while(damage > D) {
				int idx = sequence.lastIndexOf("CS");
				if(idx > -1) {
					sequence = sequence.substring(0,idx) + "SC" + sequence.substring(idx+2);
					swaps++;
				}
				powarray[idx] /= 2;
				damage -= powarray[idx];
			}
			System.out.println("Case #" + nooftest + ": " + swaps);
			continue;
		}
	}

}
