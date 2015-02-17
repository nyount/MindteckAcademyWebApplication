package com.mindteck.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mindteck.entities.Assignment;

public class CollectionTest {

	public static void main(String... args) {
		List<Assignment> list = new ArrayList<Assignment>();
		Assignment a = new Assignment();
		
		
		for (int i = 0; i < 5; i++) {
			a.setAssignmentId(i);
			list.add(a);
		}
		
		print(list);
		
		foo(list);
		
		print(list);
		
		String [] O = {};
		String[] Ox = new String[3];
		O = Arrays.copyOf(Ox, Ox.length);
		
		for (String s : O) { System.out.println(s); }
		
	}
	
	private static void print(List<Assignment> l) {
		System.out.println();
		for (Assignment as : l) {
			System.out.println(as.getAssignmentId());
		}
		System.out.println();
	}
	
	private static void foo(List<Assignment> l) {
		System.out.println("\nfoo()\n");
		Assignment a = l.get(0);
		a.setAssignmentId(10);
		l.remove(0);
		l.add(0, a);
	}
	
}

