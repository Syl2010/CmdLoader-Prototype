package net.gunivers.cmdloader.keys.keys;

import java.util.function.Predicate;

import net.gunivers.cmdloader.keys.structure.abstracts.SimpleValueKey;

/**
 * 
 * @author A~Z
 *
 */
public class OnlyOpKey extends SimpleValueKey<Boolean>
{
	protected OnlyOpKey()
	{
		super("only_op", true, true);
	}

	@Override
	public Predicate<Boolean> getValider()
	{
		return b -> true;
	}

	@Override
	public KeyInstance<Boolean> parse(String value)
	{
		if (!(value.equals("true") || value.equals("false")))
			throw new ClassCastException("Couldn't convert '" + value + "' to boolean");
		
		return this.newInstance(Boolean.valueOf(value));
	}

	@Override
	public boolean trigger(Boolean value, KeyInstance<Boolean> instance)
	{
		instance.setValue(value);
		return true;
	}
}
