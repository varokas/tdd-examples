package com.huskycode.stack;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class StackImplTest {
	private Stack stack;
	
	@Before
	public void before() {
		stack = new StackImpl();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void pushShouldThrowExceptionWhenNullIsSupplied() {
		stack.push(null);
	}
	
	@Test
	public void popShouldReturnWhatIsJustPushed() {
		String pushedString = "str";
		
		stack.push(pushedString);
		
		assertThat(stack.pop(), is(pushedString));
	}
	
	@Test(expected=EmptyStackException.class)
	public void popShouldThrowExceptionIfPopWhenEmpty() {
		stack.pop();
	}
	
	@Test
	public void stackShouldBeFirstInLastOut() {
		String first = "first";
		String second = "second";
		
		stack.push(first);
		stack.push(second);
		
		assertThat(stack.pop(), is(second));
		assertThat(stack.pop(), is(first));
	}
	
	@Test
	public void sizeShouldReturnZeroForNewStack() {
		assertThat(stack.size(), is(0));
	}
	
	@Test
	public void sizeShouldReturnOneIfAfterPushed() {
		stack.push("anElement");
		
		assertThat(stack.size(), is(1));
	}
	
	@Test
	public void sizeShouldReducedAfterPop() {
		stack.push("anElement");
		stack.push("anElement2");
		
		int beforeSize = stack.size();
		
		stack.pop();
		
		assertThat(stack.size(), is(beforeSize - 1));
	}
}
