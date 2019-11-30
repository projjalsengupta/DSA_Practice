package Amazon.array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class MergeOverlappingIntervals {
    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        ArrayList<Interval> intervals = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int s = scanner.nextInt();
            int e = scanner.nextInt();
            intervals.add(new Interval(s, e));
        }

        print(merge(intervals));
    }

    private static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> res = new ArrayList<>();
        intervals.sort(Comparator.comparingInt(interval -> interval.start));

        int index = 0;
        int highestEnd = 0;
        for (int i = 0; i < intervals.size(); i++) {
            Interval fInterval = intervals.get(i);

            if (index >= res.size()) {
                res.add(fInterval);
            }

            if (i < intervals.size() - 1) {
                Interval sInterval = intervals.get(i + 1);
                highestEnd = Math.max(highestEnd, fInterval.end);
                if (sInterval.start <= highestEnd) {
                    highestEnd = Math.max(highestEnd, sInterval.end);
                    res.get(index).end = highestEnd;
                } else {
                    index++;
                }
            }
        }
        return res;
    }

    private static void print(ArrayList<Interval> intervals) {
        for (Interval interval : intervals) {
            System.out.println(interval.start + " " + interval.end);
        }
    }
}
