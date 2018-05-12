package Practice;

import java.util.LinkedList;
import java.util.List;

public class QuickSort {

	List<String> sortStrings(List<String> list, boolean asc){
		int start = 0;
		int end = list.size() - 1;
		if(end - start <= 1) {
			return list;
		}
		
		if(asc) {
			sort(list, start, end);
		}else {
			reverseSort(list, start, end);
		}
		
		return list;
	}
	
	void sort(List<String> list, int start, int end) {
		
		if((end - start)<1) {
			return;
		}
		//System.out.println("Test: " + list);
		
		int pivot = end;
		
		String strpivot = list.get(pivot);
		int i=start;
		for(int j=start; j<pivot; j++) {
			String str = list.get(j);
			if(str.length() < strpivot.length()) {
				String temp = list.get(i);
				list.set(i, str);
				list.set(j, temp);
				i++;
			}
			//System.out.println("Test2   : " + i + "," + j + "," + pivot + "  : " + list);
		}
		String temp = list.get(i);
		list.set(i, strpivot);
		list.set(pivot, temp);
		
		sort(list, start, i - 1);
		sort(list, i + 1, end);
		
	}
	
	void reverseSort(List<String> list, int start, int end) {
		
		if((end - start)<1) {
			return;
		}
		//System.out.println("Test: " + list);
		
		int pivot = end;
		
		String strpivot = list.get(pivot);
		int i=start;
		for(int j=start; j<pivot; j++) {
			String str = list.get(j);
			if(str.length() > strpivot.length()) {
				String temp = list.get(i);
				list.set(i, str);
				list.set(j, temp);
				i++;
			}
			//System.out.println("Test2   : " + i + "," + j + "," + pivot + "  : " + list);
		}
		String temp = list.get(i);
		list.set(i, strpivot);
		list.set(pivot, temp);
		
		reverseSort(list, start, i - 1);
		reverseSort(list, i + 1, end);
		
	}
	
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		list.add("done");
		list.add("abcd");
		list.add("howdy");
		list.add("whatup");
		list.add("supdude");
		list.add("yoy");
		System.out.println(list);
		QuickSort qs = new QuickSort();
		System.out.println(qs.sortStrings(list, false));
	}
	
}
