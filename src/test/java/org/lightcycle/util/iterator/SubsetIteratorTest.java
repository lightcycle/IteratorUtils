package org.lightcycle.util.iterator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class SubsetIteratorTest {
    @Test
    public void handlesEmptySet() throws Exception {
        Set<Integer> set = new HashSet<>();
        Iterator<Set<Integer>> subsetIter = new SubsetIterator<Integer>(set);
        Set<Integer> subset = subsetIter.next();
        assertEquals(0, subset.size());
        assertFalse(subsetIter.hasNext());
    }

    @Test
    public void returnsCorrectNumberOfSubsets() throws Exception {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        Iterator<Set<Integer>> subsetIter = new SubsetIterator<Integer>(set);
        int count = 0;
        while (subsetIter.hasNext()) {
            count++;
            subsetIter.next();
        }
        assertEquals(count, 1 << set.size());
    }

    @Test
    public void returnsExpectedSubsets() throws Exception {
        Set<Integer> set = new HashSet<>();
        Integer one = new Integer(1);
        Integer two = new Integer(2);
        set.add(one);
        set.add(two);
        Iterator<Set<Integer>> subsetIter = new SubsetIterator<Integer>(set);
        Set<Integer> subset;
        subset = subsetIter.next();
        assertEquals(2, subset.size());
        assertTrue(subset.contains(one));
        assertTrue(subset.contains(two));
        subset = subsetIter.next();
        assertEquals(1, subset.size());
        assertTrue(subset.contains(two));
        subset = subsetIter.next();
        assertEquals(1, subset.size());
        assertTrue(subset.contains(one));
        subset = subsetIter.next();
        assertEquals(0, subset.size());
        assertFalse(subsetIter.hasNext());
    }
}