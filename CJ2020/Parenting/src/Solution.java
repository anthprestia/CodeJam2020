import java.util.*;
import java.io.*;


public class Solution {

    public static List<Integer> findSmallest(List<Integer> start, List<Integer> end) {

        int smallest = 99999;
        int smallestIdx = 0;

        for (int i = 0; i < start.size(); i++) {
            int temp = start.get(i);
            if (temp < smallest) {
                smallest = temp;
                smallestIdx = i;
            }
        }
        List<Integer> times = new ArrayList<>();
        times.add(smallest);
        times.add(end.get(smallestIdx));
        start.remove(smallestIdx);
        end.remove(smallestIdx);
        return times;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int appts = in.nextInt();
            StringBuilder sched = new StringBuilder();
            String error = "";
            int z = 0;
            int jS = 0; //end of previous appt
            int cS = 0;

            List<Integer> aptStart = new ArrayList<>();
            List<Integer> aptStartCpy = new ArrayList<>();
            List<Integer> aptEnd = new ArrayList<>();
            List<String> indexes = new ArrayList<>();
            List<Integer> taken = new ArrayList<>();

            for (int j = 0; j < appts; j++) {
                int start = in.nextInt();
                int end = in.nextInt();
                aptStart.add(start);
                aptStartCpy.add(start);
                aptEnd.add(end);
            }
            for (int j = 0; j < appts; j++) {
                indexes.add("");
            }

            for (int j = 0; j < appts; j++) {
                List<Integer> first = findSmallest(aptStart, aptEnd);
                int aStart = first.get(0);
                int aEnd = first.get(1);
                int idx = 0;
                for(int k = 0; k < aptStart.size(); k++) {
                    if (k == aptStartCpy.indexOf(aStart)) {
                        idx = k;
                    }
                }

                if (aStart >= jS) {
                    jS = aEnd;
                    indexes.add(idx,"J");
                }
                else if (aStart >= cS) {
                    cS = aEnd;
                    indexes.add(idx,"C");
                }
                else {
                    error = "IMPOSSIBLE";
                    z = 1;
                    break;
                }
                System.out.println("Index: "+ idx);

            }

            for (int j = 0; j < indexes.size(); j++) {
                sched.append(indexes.get(j));
            }

            if (z == 1) {
                System.out.println("Case #" + i + ": " + error);
            }
            else {
                System.out.println("Case #" + i + ": " + sched);
            }
        }
    }
}