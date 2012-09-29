package com.apple.interview.iterator;

import java.util.Iterator;

public abstract class MultiDimArrayBackedIterator<E> implements Iterator<E> {

	/* -----------------------------------------------------------------------
	 * Instance Variables
	 * -----------------------------------------------------------------------
	 */
	/**
	 * Keep track of the current array we are using
	 */
	protected int currentArrayPointer = 0;
	
	protected Iterator<E> currentIterator;
	
	
	/* -----------------------------------------------------------------------
	 * Abstract Method definitions
	 * -----------------------------------------------------------------------
	 */
	protected abstract void increment();
	
	
	/* ------------------------------------------------------------------------
	 * Default implementations of methods defined in the Iterator<E> interface
	 * ------------------------------------------------------------------------
	 */
	@Override
	public boolean hasNext() {
		return getCurrentIterator().hasNext();
	}

	@Override
	public E next() {
		return getCurrentIterator().next();
	}

	@Override
	public void remove() {
		getCurrentIterator().remove();
	}
	
	/* -----------------------------------------------------------------------
	 * Utility methods
	 * -----------------------------------------------------------------------
	 */
	protected Iterator<E> getCurrentIterator() {
		return getCurrentIterator(true);
	}
	
	protected Iterator<E> getCurrentIterator(boolean incrementFlag) {		
		if ( (currentIterator == null) || !currentIterator.hasNext()) {
			if (incrementFlag)
				increment();
		}
		return currentIterator;
	}
	
}
