package com.dhruba.java.generics;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CircularBufferGenericTest {
	
	private CircularBufferGenerics<String> buffer = new CircularBufferGenerics<String>(2);
	
	@Test
	public void shouldOfferPollableElement() {
		assertTrue(buffer.offer("1"));
		assertEquals("1", buffer.poll());
		assertNull(buffer.poll());
	}
	
	@Test
	public void shouldNotOfferWhenBufferIsFull() {
		assertTrue(buffer.offer("1"));
		assertTrue(buffer.offer("2"));
		assertFalse(buffer.offer("3"));
	}
	
	@Test
	public void shouldNotPollWhenBufferIsEmpty() {
		assertNull(buffer.poll());
	}
	
	@Test
	public void shouldRecycleBuffer() {
		assertTrue(buffer.offer("1"));
		assertTrue(buffer.offer("2"));
		assertEquals("1", buffer.poll());
		assertTrue(buffer.offer("3"));
		assertEquals("2", buffer.poll());//Since this is like a Queue - FIFO
		assertEquals("3", buffer.poll());
	}
}
