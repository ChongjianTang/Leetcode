package leetcode.p27.p2709;

import leetcode.p20.p2092.FindAllPeople;

import java.util.*;

public class CanTraverseAllPairs {

    public int gcd(int i, int j, Map<Integer, Map<Integer, Integer>> cache) {
        if (i == j) {
            return i;
        } else if (i < j) {
            return gcd(j, i, cache);
        } else {
            if (!cache.containsKey(i)) {
                cache.put(i, new HashMap<>());
            }
            if (cache.get(i).containsKey(j)) {
                return cache.get(i).get(j);
            } else {
                int result = gcd(i - j, j, cache);
                cache.get(i).put(j, result);
                return result;
            }
        }
    }

    /**
     * TLE
     * Union find.
     * A failed case.
     */
    public boolean canTraverseAllPairs1(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        Map<Integer, Integer> unionFindIndexMap = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        UnionFind unionFind = new UnionFind(set.size());
        int k = 0;
        for (int num : set) {
            unionFindIndexMap.put(num, k);
            k++;
        }
        nums = new int[set.size()];
        int index = 0;
        for (Integer num : set) {
            nums[index++] = num;
        }
        if (nums.length == 1) {
            if (nums[0] == 1) {
                return false;
            } else {
                return true;
            }
        }
        Map<Integer, Map<Integer, Integer>> cache = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] != nums[j]) {
                    if (gcd(nums[i], nums[j], cache) > 1) {
                        unionFind.union(i, j);
                    }
                }
            }
        }
        return unionFind.getCount() == 1;
    }

    class UnionFind {
        int count;
        int[] parent;
        int[] rank;

        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int i) {
            if (parent[i] != i) {
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
                count--;
            }
        }

        public int getCount() {
            return count;
        }
    }

    public boolean canTraverseAllPairs(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        nums = new int[set.size()];
        int index = 0;
        for (Integer num : set) {
            nums[index] = num;
            index++;
        }
        if (nums.length == 1) {
            if (nums[0] == 1) {
                return false;
            } else {
                return true;
            }
        }


        UnionFind unionFind = new UnionFind(set.size());


        Map<Integer, Set<Integer>> factorNumMap = new HashMap<>();
        factorNumMap.put(2, new HashSet<>());
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                factorNumMap.get(2).add(i);
            }
            int num = nums[i];
            while (num % 2 == 0) {
                num /= 2;
            }
            for (int j = 3; j <= Math.sqrt(num); j += 2) {
                if (num % j == 0) {
                    if (!factorNumMap.containsKey(j)) {
                        factorNumMap.put(j, new HashSet<>());
                    }
                    factorNumMap.get(j).add(i);
                    while (num % j == 0) {
                        num /= j;
                    }
                }
            }
            if (num > 2) {
                if (!factorNumMap.containsKey(num)) {
                    factorNumMap.put(num, new HashSet<>());
                }
                factorNumMap.get(num).add(i);
            }
        }

        for (Set<Integer> entry : factorNumMap.values()) {
            int base = -1;
            for (int i : entry) {
                if (base == -1) {
                    base = i;
                } else {
                    unionFind.union(base, i);
                }
            }
        }

        return unionFind.getCount() == 1;
    }

    //TODO: Check the solution

    public static void main(String[] args) {
        CanTraverseAllPairs c = new CanTraverseAllPairs();
        int[] nums = new int[]{2, 3, 6};
        System.out.println(c.canTraverseAllPairs(nums));
    }
}
