package Leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Leetcode3169 {
    public static int countDays(int days, int[][] meetings) {
        if (meetings.length == 0) return days;

        // Sort meetings by start time
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        // Merge overlapping intervals
        int lastEnd = 0;
        int meetingDays = 0;
        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];

            if (start > lastEnd) {
                // Non-overlapping interval
                meetingDays += end - start + 1;
                lastEnd = end;
            } else {
                // Overlapping interval
                if (end > lastEnd) {
                    meetingDays += end - lastEnd;
                    lastEnd = end;
                }
            }
        }

        return days - meetingDays;
    }

    public static void main(String[] args) {
        int days = 10;
        int [][]meetings = {{5,7},{1,3},{9,10}};

        System.out.println(countDays(days, meetings));
    }
}
