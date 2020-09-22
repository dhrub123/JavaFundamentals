package com.dhruba.java.generics.comparable;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ComparisonUsingComparable {

	@Test
	public void shouldRetainOrderOfSortedPair() {

		SortedPair<Integer> pair = new SortedPair<Integer>(1, 2);
		assertEquals(1, pair.getFirst().intValue());
		assertEquals(2, pair.getSecond().intValue());

	}
	
	@Test
	public void shouldFlipOrderOfSortedPair() {

		SortedPair<Integer> pair = new SortedPair<Integer>(2, 1);
		assertEquals(1, pair.getFirst().intValue());
		assertEquals(2, pair.getSecond().intValue());

	}

}
