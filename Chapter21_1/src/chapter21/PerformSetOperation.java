package chapter21;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class PerformSetOperation {
	public static void main(String[] args){
		Set<String> set1 = new LinkedHashSet<>();
		 
		
		set1.add("Jim");
		set1.add("John");
		set1.add("Blake");
		set1.add("Kevin");
		set1.add("Michael");
		
		System.out.println("set1 is " + set1);
		System.out.println(set1.size() + " elements in set1");
		
Set<String> set2 = new LinkedHashSet<>();
		
		set2.add("George");
		set2.add("Katie");
		set2.add("Kevin");
		set2.add("Michelle");
		set2.add("Ryan");
		
		System.out.println("\nset2 is " + set2);
		System.out.println(set2.size() + " elements in set2");
		
		
		Iterator<String> setIterator = set1.iterator();
		while(setIterator.hasNext()){
			System.out.print(setIterator.next() + " ");
		}
		System.out.println();
		
		set1.addAll(set2);
		System.out.println("\nAfter adding set2 to set1, set1 is " + set1); 
		
		set1.retainAll(set2);
		System.out.println("\nAfter retain set2 to set1, set1 is " + set1);
		
		
	}

}
