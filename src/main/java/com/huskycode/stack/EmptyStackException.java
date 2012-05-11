package com.huskycode.stack;

public class EmptyStackException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public EmptyStackException(String string) {
		super(string);
	}

}
