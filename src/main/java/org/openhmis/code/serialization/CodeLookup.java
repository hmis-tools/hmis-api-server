package org.openhmis.code.serialization;

import java.util.HashMap;
import java.util.Map;

import org.openhmis.code.BaseCode;
import org.openhmis.exception.InvalidParameterException;


public class CodeLookup<E extends Enum<E> & BaseCode> {
    private Map<Integer, E> lookup;

	public CodeLookup(E... values) {
        lookup = new HashMap<Integer, E>();
        for (E e : values) {
         lookup.put(e.getCode(), e);
        }
    }

    public E valueByCode(Integer code) {
    	E value = lookup.get(code);
    	if(value == null)
    		throw new InvalidParameterException();
        return value;
    }
}