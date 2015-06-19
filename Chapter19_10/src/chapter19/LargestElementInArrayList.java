package chapter19;

import java.util.ArrayList;

public class LargestElementInArrayList {
	public static <E extends Comparable<E>> E max(ArrayList<E> list){
		E currentMax = list.get(0);
		for(int i = 1; i < list.size() - 1; i++){
			if(list.get(i).compareTo(currentMax) > 0){
				currentMax = list.get(i);
			}
						 			
		}
		return currentMax;
		
	}
}
