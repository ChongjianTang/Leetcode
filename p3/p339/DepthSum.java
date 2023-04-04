package leetcode.p3.p339;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

interface NestedInteger {
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

class NestedIntegerImplementation implements NestedInteger {

    private List<NestedInteger> nestedIntegerList;
    private boolean isSingleInteger;
    private int num;
    private boolean isEmpty;

    // Constructor initializes an empty nested list.
    public NestedIntegerImplementation() {
        isEmpty = true;
    }

    // Constructor initializes a single integer.
    public NestedIntegerImplementation(int value) {
        nestedIntegerList = null;
        isSingleInteger = true;
        num = value;
        isEmpty = false;
    }

    @Override
    public boolean isInteger() {
        return isSingleInteger;
    }

    @Override
    public Integer getInteger() {
        if (isSingleInteger) {
            return num;
        } else {
            return null;
        }
    }

    @Override
    public void setInteger(int value) {
        nestedIntegerList = null;
        isSingleInteger = true;
        num = value;
        isEmpty = false;
    }

    @Override
    public void add(NestedInteger ni) {
        if (isEmpty) {
            nestedIntegerList = new ArrayList<>();
        } else {
            if (isSingleInteger) {
                isSingleInteger = false;
                nestedIntegerList = new ArrayList<>();
                nestedIntegerList.add(new NestedIntegerImplementation(num));
            }
        }
        nestedIntegerList.add(ni);
    }

    @Override
    public List<NestedInteger> getList() {
        if (isSingleInteger) {
            return new ArrayList<>();
        } else {
            return nestedIntegerList;
        }
    }
}

public class DepthSum {
    /**
     * DFS
     */
    public static int depthSum(List<NestedInteger> nestedList) {
        int sum = 0;
        for (NestedInteger nestedInteger : nestedList) {
            sum += helper1(1, nestedInteger);
        }
        return sum;
    }

    public static int helper1(int depth, NestedInteger nestedInteger) {
        if (nestedInteger.isInteger()) {
            return depth * nestedInteger.getInteger();
        } else {
            int sum = 0;
            List<NestedInteger> nestedList = nestedInteger.getList();
            for (NestedInteger integer : nestedList) {
                sum += helper1(depth + 1, integer);
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        List<NestedInteger> nestedList;
        int output;

        nestedList = new ArrayList<>();
        NestedIntegerImplementation temp = new NestedIntegerImplementation(1);
        temp.add(new NestedIntegerImplementation(1));
        nestedList.add(temp);
        nestedList.add(new NestedIntegerImplementation(2));

        temp = new NestedIntegerImplementation(1);
        temp.add(new NestedIntegerImplementation(1));
        nestedList.add(temp);

        output = 10;

        System.out.println(depthSum(nestedList) == output);

        nestedList = new ArrayList<>();
        nestedList.add(new NestedIntegerImplementation(1));
        temp = new NestedIntegerImplementation(4);
        NestedIntegerImplementation temp2 = new NestedIntegerImplementation();
        temp2.add(new NestedIntegerImplementation(6));
        temp.add(temp2);

        nestedList.add(temp);
        output = 27;
        System.out.println(depthSum(nestedList) == output);
    }
}
