package com.dhruba.java.generics.comparator;

import java.util.Comparator;

public class ReverseComparator<T> implements Comparator<T> {

	private Comparator<T> delegateComparator;

	public ReverseComparator(final Comparator<T> delegateComparator) {
		this.delegateComparator = delegateComparator;
	}

	@Override
	public int compare(T left, T right) {
		return -1 * delegateComparator.compare(left, right);
	}

}
