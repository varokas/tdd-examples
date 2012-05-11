package com.huskycode.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * A very primitive implementation of stack for TDD demo purpose.
 */
public class StackImpl implements Stack {
	private List<String> anArray = new ArrayList<String>();
	
	public void push(String element) {
		if(element == null) 
			throw new IllegalArgumentException("Supplied element is null");
		
		anArray.add(element);
	}

	public String pop() {
		if(size() == 0) {
			throw new EmptyStackException("Stack is empty");
		}
		
		String returnVal = anArray.get(anArray.size() - 1);
		anArray = anArray.subList(0, anArray.size() - 1);
		
		return returnVal;
	}

	public int size() {
		return anArray.size();
	}

}
