package org.lightcycle.util.iterator;

import java.util.*;

/**
 * Iterator that returns all possible sequences of n elements selected from a collection.
 *
 * @param <T>
 */
public class CombinationIterator<T> implements Iterator<List<T>> {
    private int counter = 0;

    private List<T> elements;

    private int n;

    public CombinationIterator(Collection<T> collection, int n) {
        if (collection.size() == 0) {
            throw new IllegalArgumentException("Called with an empty collection.");
        }
        if (n <= 0) {
            throw new IllegalArgumentException("Called with n <= 0.");
        }
        elements = new ArrayList<>();
        elements.addAll(collection);
        counter = (int)Math.pow(elements.size(), n) - 1;
        this.n = n;
    }

    @Override
    public boolean hasNext() {
        return counter >= 0;
    }

    @Override
    public List<T> next() {
        List<T> list = new LinkedList<>();
        for (int i = 0, mask = counter; i < n; i++, mask /= elements.size()) {
            list.add(elements.get(mask % elements.size()));
        }
        counter--;
        return list;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
