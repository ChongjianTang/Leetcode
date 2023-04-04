package leetcode.p13.p1396;

import java.util.HashMap;

public class UndergroundSystem {

    private HashMap<Integer, String> stationNameTable;
    private HashMap<Integer, Integer> currentTimeTable;
    private HashMap<String, HashMap<String, int[]>> avgTime;

    public UndergroundSystem() {
        stationNameTable = new HashMap<>();
        currentTimeTable = new HashMap<>();
        avgTime = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        stationNameTable.put(id, stationName);
        currentTimeTable.put(id, t);
    }

    public void checkOut(int id, String stationName, int t) {
        int time = t - currentTimeTable.get(id);
        String startStationName = stationNameTable.get(id);
        if (avgTime.get(startStationName) == null) {
            avgTime.put(startStationName, new HashMap<>());
        }
        HashMap<String, int[]> temp = avgTime.get(startStationName);
        if (temp.get(stationName) == null) {
            temp.put(stationName, new int[]{time, 1});
        } else {
            int[] cumulativeTime = temp.get(stationName);
            cumulativeTime[0] += time;
            cumulativeTime[1] += 1;
        }
    }

    public double getAverageTime(String startStation, String endStation) {
        int[] cumulativeTime = avgTime.get(startStation).get(endStation);
        return cumulativeTime[0] * 1.0 / cumulativeTime[1];
    }

    public static void main(String[] args) {
        UndergroundSystem us = new UndergroundSystem();
        us.checkIn(45, "Leyton", 3);
        us.checkIn(32, "Paradise", 8);
        us.checkIn(27, "Leyton", 10);
        us.checkOut(45, "Waterloo", 15);
        us.checkOut(27, "Waterloo", 20);
        us.checkOut(32, "Cambridge", 22);
        System.out.println(us.getAverageTime("Paradise", "Cambridge") == 14);
        System.out.println(us.getAverageTime("Leyton", "Waterloo") == 11);
        us.checkIn(10, "Leyton", 24);
        System.out.println(us.getAverageTime("Leyton", "Waterloo") == 11);
        us.checkOut(10, "Waterloo", 38);
        System.out.println(us.getAverageTime("Leyton", "Waterloo") == 12);
    }
}
