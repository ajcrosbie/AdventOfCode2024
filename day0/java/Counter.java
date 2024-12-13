package day0.java;

import java.util.HashMap;
import java.util.Iterator;

public class Counter<T> implements Iterable<T> {
    private HashMap<T, Integer> c = new HashMap<T, Integer>();

    public Counter() {
    }

    public Counter(Iterable<T> list) {
        for (T i : list) {
            addToCount(i);
        }
    }

    public Integer getCount(T val) {
        if (c.get(val) == null) {
            return 0;
        }
        return c.get(val);
    }

    public Iterator<T> iterator() {
        return c.keySet().iterator();
    }

    public void addToCount(T val) {
        Integer currCount = c.get(val);
        if (currCount == null) {
            c.put(val, 1);
        } else {
            c.put(val, currCount + 1);
        }
    }
}
