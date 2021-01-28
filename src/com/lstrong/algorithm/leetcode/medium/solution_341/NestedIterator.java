package com.lstrong.algorithm.leetcode.medium.solution_341;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * @author asus
 */
public class NestedIterator implements Iterator<Integer> {

    private final List<Integer> list;
    private int index;

    public NestedIterator(List<NestedInteger> nestedList) {
        list = integerIterator(nestedList);
        index = 0;
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            return list.get(index++);
        }

        return 0;
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    private List<Integer> integerIterator(List<NestedInteger> nestedList) {
        List<Integer> list = new ArrayList<>();
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                list.add(nestedInteger.getInteger());
            } else {
                list.addAll(integerIterator(nestedInteger.getList()));
            }
        }

        return list;
    }


    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        List<NestedInteger> getList();
    }
}