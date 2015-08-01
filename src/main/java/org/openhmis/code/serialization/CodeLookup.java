package org.openhmis.code.serialization;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openhmis.code.BaseCode;


public class CodeLookup<E extends Enum<E> & BaseCode> {
    private Map<Integer, E> lookup;

    public CodeLookup(E... values) {
        lookup = new HashMap<Integer, E>();
        for (E e : values) {
         lookup.put(e.getCode(), e);
        }
    }

    public E valueByCode(Integer code) {
        return lookup.get(code);
    }
}