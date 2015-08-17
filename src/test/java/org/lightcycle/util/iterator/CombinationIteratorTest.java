package org.lightcycle.util.iterator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class CombinationIteratorTest {
    @Test
    public void handlesCombinationsOfZero() throws Exception {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        try {
            Iterator<List<Integer>> combinationIter = new CombinationIterator<Integer>(set, 0);
            fail("Expected an IllegalArgumentException to be thrown.");
        } catch (IllegalArgumentException exception) { }
    }

    @Test
    public void handlesCombinationsOfEmptyCollection() throws Exception {
        Set<Integer> set = new HashSet<>();
        try {
            Iterator<List<Integer>> combinationIter = new CombinationIterator<Integer>(set, 1);
            fail("Expected an IllegalArgumentException to be thrown.");
        } catch (IllegalArgumentException exception) { }
    }

    @Test
    public void returnsCorrectNumberOfCombinations() throws Exception {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        Iterator<List<Integer>> combinationIter = new CombinationIterator<Integer>(set, 3);
        int count = 0;
        while (combinationIter.hasNext()) {
            count++;
            combinationIter.next();
        }
        assertEquals(count, (int)Math.pow(set.size(), 3));
    }
}