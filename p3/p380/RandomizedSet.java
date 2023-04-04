package leetcode.p3.p380;

import java.util.*;

public class RandomizedSet {

    List<Integer> array;
    HashMap<Integer, Integer> map;

    public RandomizedSet() {
        array = new ArrayList<>();
        map = new HashMap<>();
    }

    public boolean insert(int val) {
        if (map.get(val) != null) {
            return false;
        } else {
            map.put(val, array.size());
            array.add(val);
            return true;
        }
    }

    public boolean remove(int val) {
        if (map.get(val) == null) {
            return false;
        } else {
            int index = map.get(val);
            if (index == array.size() - 1) {
                map.remove(val);
                array.remove(index);
            } else {
                map.put(array.get(array.size() - 1), index);
                array.set(index, array.get(array.size() - 1));
                map.remove(val);
                array.remove(array.size() - 1);
            }
            return true;
        }
    }

    public int getRandom() {
        Random r = new Random();
        return array.get(r.nextInt(array.size()));
    }

    public static void main(String[] args) {
        RandomizedSet a = new RandomizedSet();
        a.insert(0);
        a.insert(1);
        a.remove(0);
        a.insert(2);
        a.remove(1);
        System.out.println(a.getRandom() == 2);
    }
}
