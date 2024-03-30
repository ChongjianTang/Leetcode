package leetcode.p20.p2092;

import java.util.*;

public class FindAllPeople {
    /**
     * Feb 24, 2024 02:27
     * My approach. Union Find. Not very hard but it is hard to code and debug for corner cases.
     * Time Complexity: ?
     * Space Complexity: ?
     */
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        class UnionFind {
            int[] parent;
            int[] rank;

            public UnionFind(int n) {
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
                }
            }
        }
        PriorityQueue<int[]> priorityQueueMeetings = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        Set<Integer> peopleWithSecrets = new HashSet<>();
        peopleWithSecrets.add(0);
        peopleWithSecrets.add(firstPerson);
        for (int i = 0; i < meetings.length; i++) {
            priorityQueueMeetings.add(meetings[i]);
        }
        while (!priorityQueueMeetings.isEmpty()) {
            Map<Integer, Integer> personUnionFindMap = new HashMap<>();
            int i = 0;
            int time = priorityQueueMeetings.peek()[2];
            List<int[]> sameTimeMeetings = new ArrayList<>();
            while (!priorityQueueMeetings.isEmpty() && priorityQueueMeetings.peek()[2] == time) {
                int[] meeting = priorityQueueMeetings.poll();
                sameTimeMeetings.add(meeting);
                if (!personUnionFindMap.containsKey(meeting[0])) {
                    personUnionFindMap.put(meeting[0], i);
                    i++;
                }
                if (!personUnionFindMap.containsKey(meeting[1])) {
                    personUnionFindMap.put(meeting[1], i);
                    i++;
                }
            }
            UnionFind unionFind = new UnionFind(personUnionFindMap.size());
            Set<Integer> secretUnion = new HashSet<>();
            for (int[] meeting : sameTimeMeetings) {
                int x = personUnionFindMap.get(meeting[0]);
                int y = personUnionFindMap.get(meeting[1]);
                if (secretUnion.contains(unionFind.find(x)) || secretUnion.contains(unionFind.find(y)) || peopleWithSecrets.contains(meeting[0]) || peopleWithSecrets.contains(meeting[1])) {
                    unionFind.union(x, y);
                    secretUnion.add(unionFind.find(x));
                } else {
                    unionFind.union(x, y);
                }
            }

            for (Map.Entry<Integer, Integer> entry : personUnionFindMap.entrySet()) {
                if (secretUnion.contains(unionFind.find(entry.getValue()))) {
                    peopleWithSecrets.add(entry.getKey());
                }
            }
        }
        return new ArrayList<>(peopleWithSecrets);
    }


    // TODO: Check the solution

    public static void main(String[] args) {
        FindAllPeople f = new FindAllPeople();
        int n = 5;
        int[][] meetings = new int[][]{{3, 4, 2}, {1, 2, 1}, {2, 3, 1}};
        int firstPerson = 1;
        List<Integer> output = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));
        System.out.println(f.findAllPeople(n, meetings, firstPerson).equals(output));

        n = 5;
        meetings = new int[][]{{1, 4, 3}, {0, 4, 3}};
        firstPerson = 3;
        output = new ArrayList<>(Arrays.asList(0, 1, 3, 4));
        System.out.println(f.findAllPeople(n, meetings, firstPerson).equals(output));

        n = 5;
        meetings = new int[][]{{4, 3, 1}, {3, 1, 1}, {2, 1, 1}};
        firstPerson = 2;
        output = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));
        System.out.println(f.findAllPeople(n, meetings, firstPerson).equals(output));
    }
}
