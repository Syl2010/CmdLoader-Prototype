package net.gunivers.cmdloader.keys.keys;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

import net.gunivers.cmdloader.keys.Key;
import net.gunivers.cmdloader.keys.structure.abstracts.ArrayKey;
import net.gunivers.cmdloader.keys.structure.abstracts.CompoundKey;
import net.gunivers.cmdloader.keys.structure.abstracts.SimpleValueKey;

/**
 * 
 * @author A~Z
 *
 */
public abstract class KeyRegister
{
	public static final ArgumentsKey arguments = new ArgumentsKey();
	public static final CommandKey command = new CommandKey();
	public static final DescriptionKey description = new DescriptionKey();
	public static final OnlyOpKey only_op = new OnlyOpKey();
	
	
	@SuppressWarnings("rawtypes")
	public static final Map<String, Key> keys = Collections.unmodifiableMap(KeyRegister.keys);
	
	/**
	 * 
	 * @return an ArrayList<SimpleValueKey<?>>
	 *                                        which contains all the key that were registered
	 */
	public static ArrayList<SimpleValueKey<?>> getSimpleValueKeys()
	{
		final ArrayList<SimpleValueKey<?>> keys = new ArrayList<>();
		
		KeyRegister.keys.values().stream().filter(k -> k instanceof SimpleValueKey).forEach(k -> keys.add((SimpleValueKey<?>) k));
		
		return keys;
	}
	
	public static ArrayList<ArrayKey<?>> getTypedArrayKeys()
	{
		final ArrayList<ArrayKey<?>> keys = new ArrayList<>();
		
		KeyRegister.keys.values().stream().filter(k -> k instanceof ArrayKey).forEach(k -> keys.add((ArrayKey<?>) k));
		
		return keys;
	}
	
	public static ArrayList<CompoundKey> getSimpleCompoundKeys()
	{
		final ArrayList<CompoundKey> keys = new ArrayList<>();
		
		KeyRegister.keys.values().stream().filter(k -> k instanceof CompoundKey).forEach(k -> keys.add((CompoundKey) k));
		
		return keys;
	}
}
