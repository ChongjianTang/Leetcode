package leetcode.p17.p1700;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CountStudents {
    /**
     * Apr 08, 2024 22:41
     */
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> foodQueue = new LinkedList<>();
        Queue<Integer> studentQueue = new LinkedList<>();
        for (int i = 0; i < students.length; i++) {
            studentQueue.offer(students[i]);
            foodQueue.offer(sandwiches[i]);
        }
        Queue<Integer> nextQueue = new LinkedList<>();
        int size = studentQueue.size();
        while (nextQueue.size() != size) {
            nextQueue = new LinkedList<>();
            size = studentQueue.size();
            while (!studentQueue.isEmpty()) {
                int student = studentQueue.poll();
                if (student == foodQueue.peek()) {
                    foodQueue.poll();
                } else {
                    nextQueue.offer(student);
                }
            }
            studentQueue = nextQueue;
        }
        return nextQueue.size();
    }

    public static void main(String[] args) {
        CountStudents c = new CountStudents();
        int[] students;
        int[] sandwiches;

        students = new int[]{1, 1, 1, 0, 0, 1};
        sandwiches = new int[]{1, 0, 0, 0, 1, 1};
        System.out.println(c.countStudents(students, sandwiches) == 3);
    }
}
