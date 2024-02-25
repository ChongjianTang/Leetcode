package leetcode.p24.p2402;

import java.util.*;

public class MostBooked {
    // This is a very useful bug example!
//    public int mostBooked(int n, int[][] meetings) {
//        Arrays.sort(meetings, Comparator.comparingInt(o -> o[0]));
//        Map<Integer, int[]> roomMeetingMap = new HashMap<>();
//        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(o -> roomMeetingMap.get(o)[1]));
//        Queue<Integer> delayedMeetings = new LinkedList<>();
//        int[] count = new int[n];
//        for (int i = 0; i < meetings.length; i++) {
//            while (!pq.isEmpty() && roomMeetingMap.get(pq.peek())[1] <= meetings[i][0]) {
//                int room = pq.poll();
//                count[room]++;
//                if (!delayedMeetings.isEmpty()) {
//                    int meetingLength = delayedMeetings.poll();
//                    int[] previousMeeting = roomMeetingMap.get(room);
//                    int[] nextMeeting = new int[]{previousMeeting[1], previousMeeting[1] + meetingLength};
//                    roomMeetingMap.put(room, nextMeeting);
//                    pq.offer(room);
//                } else {
//                    roomMeetingMap.remove(room);
//                }
//            }
//            if (pq.size() != n) {
//                for (int j = 0; j < n; j++) {
//                    if (!roomMeetingMap.containsKey(j)) {
//                        roomMeetingMap.put(j, meetings[i]);
//                        pq.offer(j);
//                        break;
//                    }
//                }
//            } else {
//                delayedMeetings.offer(meetings[i][1] - meetings[i][0]);
//            }
//        }
//        while (!pq.isEmpty()) {
//            int room = pq.poll();
//            count[room]++;
//            if (!delayedMeetings.isEmpty()) {
//                int meetingLength = delayedMeetings.poll();
//                int[] previousMeeting = roomMeetingMap.get(room);
//                int[] nextMeeting = new int[]{previousMeeting[1], previousMeeting[1] + meetingLength};
//                roomMeetingMap.put(room, nextMeeting);
//                pq.offer(room);
//            } else {
//                roomMeetingMap.remove(room);
//            }
//        }
//        int max = 0;
//        int index = 0;
//        for (int i = 0; i < count.length; i++) {
//            if (count[i] > max) {
//                max = count[i];
//                index = i;
//            }
//        }
//        return index;
//    }

    /**
     * Feb 19, 2024 15:19
     * My approach
     * Time Complexity: ?
     * Space Complexity: ?
     */
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(o -> o[0]));
        Map<Integer, int[]> roomMeetingMap = new HashMap<>();
        PriorityQueue<Integer> emptyRooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            emptyRooms.offer(i);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            if (roomMeetingMap.get(o1)[1] == roomMeetingMap.get(o2)[1]) {
                return o1 - o2;
            } else {
                return roomMeetingMap.get(o1)[1] - roomMeetingMap.get(o2)[1];
            }
        });
        Queue<Integer> delayedMeetings = new LinkedList<>();
        int[] count = new int[n];
        for (int i = 0; i < meetings.length; i++) {
            // If any meeting rooms become available, they should be released and any delayed meetings should be checked.
            while (!pq.isEmpty() && roomMeetingMap.get(pq.peek())[1] <= meetings[i][0]) {
                int room = pq.poll();
                count[room]++;
                if (!delayedMeetings.isEmpty()) {
                    int meetingLength = delayedMeetings.poll();
                    int[] previousMeeting = roomMeetingMap.get(room);
                    int[] nextMeeting = new int[]{previousMeeting[1], previousMeeting[1] + meetingLength};
                    roomMeetingMap.put(room, nextMeeting);
                    pq.offer(room);
                } else {
                    roomMeetingMap.remove(room);
                    emptyRooms.offer(room);
                }
            }
            if (!emptyRooms.isEmpty()) {
                int room = emptyRooms.poll();
                roomMeetingMap.put(room, meetings[i]);
                pq.offer(room);
            } else {
                delayedMeetings.offer(meetings[i][1] - meetings[i][0]);
            }
        }
        while (!pq.isEmpty()) {
            int room = pq.poll();
            count[room]++;
            if (!delayedMeetings.isEmpty()) {
                int meetingLength = delayedMeetings.poll();
                int[] previousMeeting = roomMeetingMap.get(room);
                int[] nextMeeting = new int[]{previousMeeting[1], previousMeeting[1] + meetingLength};
                roomMeetingMap.put(room, nextMeeting);
                pq.offer(room);
            } else {
                roomMeetingMap.remove(room);
                emptyRooms.offer(room);
            }
        }
        int max = 0;
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > max) {
                max = count[i];
                index = i;
            }
        }
        return index;
    }

    // TODO: A very good hard problem. Check the solution next time!

    public static void main(String[] args) {
        MostBooked mostBooked = new MostBooked();
        int n = 2;
        int[][] meetings = new int[][]{{0, 10}, {1, 5}, {2, 7}, {3, 4}};
        System.out.println(mostBooked.mostBooked(n, meetings) == 0);

        n = 3;
        meetings = new int[][]{{1, 20}, {2, 10}, {3, 5}, {4, 9}, {6, 8}};
        System.out.println(mostBooked.mostBooked(n, meetings) == 1);

        n = 4;
        meetings = new int[][]{{18, 19}, {3, 12}, {17, 19}, {2, 13}, {7, 10}};
        System.out.println(mostBooked.mostBooked(n, meetings) == 0);

        n = 2;
        meetings = new int[][]{{1, 10}, {2, 10}, {3, 10}, {4, 10}, {5, 10}, {6, 10}, {7, 10}};
        System.out.println(mostBooked.mostBooked(n, meetings) == 0);

    }
}
