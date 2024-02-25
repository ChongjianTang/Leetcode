package leetcode.p9.p997;

public class FindJudge {
    /**
     * Feb 22, 2024 00:15
     * Graph Theory. Two arrays can be optimized to 1.
     * Time Complexity: O(trust.length)
     * Space Complexity: O(n)
     */
    public int findJudge(int n, int[][] trust) {
        int[] inDegree = new int[n];
        int[] outDegree = new int[n];
        for (int i = 0; i < trust.length; i++) {
            outDegree[trust[i][0] - 1]++;
            inDegree[trust[i][1] - 1]++;
        }
        for (int i = 0; i < n; i++) {
            if (outDegree[i] == 0 && inDegree[i] == n - 1) {
                return i + 1;
            }
        }
        return -1;
    }
}
