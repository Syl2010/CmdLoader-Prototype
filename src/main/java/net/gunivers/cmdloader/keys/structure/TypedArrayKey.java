package net.gunivers.cmdloader.keys.structure;

import java.util.function.Predicate;

public abstract class TypedArrayKey<T> extends Key<T[]>
{
	private int min = 0;
	private int max = Integer.MAX_VALUE;
	
	public TypedArrayKey(String name, T[] defaultValue, boolean singleton)
	{
		super(name, defaultValue, singleton, true);
	}
	
	public TypedArrayKey(String name, T[] defaultValue, boolean singleton, int min, int max)
	{
		super(name, defaultValue, singleton, true);
		
	}

	@Override
	public Predicate<T[]> getValider()
	{
		return array -> min <= array.length && array.length <= max && getSubValider().test(array);
	}

	public abstract Predicate<T[]> getSubValider();
}
