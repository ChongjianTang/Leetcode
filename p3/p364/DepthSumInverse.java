package leetcode.p3.p364;

import java.util.List;

interface NestedInteger {
//       // Constructor initializes an empty nested list.
//               public NestedInteger();
//
//               // Constructor initializes a single integer.
//               public NestedInteger(int value);

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value);

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni);

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

public class DepthSumInverse {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int depth = getDepth(nestedList);
        return getWeightSum(nestedList, depth);
    }

    public int getDepth(List<NestedInteger> nestedList) {
        int depth = 0;
        for (NestedInteger element : nestedList) {
            if (!element.isInteger()) {
                int temp = getDepth(element.getList());
                if (temp > depth) {
                    depth = temp;
                }
            }
        }
        return depth + 1;
    }

    public int getWeightSum(List<NestedInteger> nestedList, int depth) {
        int sum = 0;
        for (NestedInteger element : nestedList) {
            if (element.isInteger()) {
                sum += depth * element.getInteger();
            } else {
                sum += getWeightSum(element.getList(), depth - 1);
            }
        }
        return sum;
    }

    //TODO more to do and check the solution: single pass one
}
