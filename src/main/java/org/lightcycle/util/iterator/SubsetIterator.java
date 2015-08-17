package org.lightcycle.util.iterator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Iterator that returns all subsets of a set, including the full set and empty set.
 *
 * @param <T>
 */
public class SubsetIterator<T> implements Iterator<Set<T>> {
    private int mask = 0;

    private Set<T> set;

    public SubsetIterator(Set<T> set) {
        this.set = set;
        mask = (1 << set.size()) - 1;
    }

    @Override
    public boolean hasNext() {
        return mask >= 0;
    }

    @Override
    public Set<T> next() {
        Set<T> subset = new HashSet<>();
        int i = mask;
        for (T member : set) {
            if (i % 2 != 0) {
                subset.add(member);
            }
            i >>= 1;
        }
        mask--;
        return subset;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
