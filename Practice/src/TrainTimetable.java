/**
 * CORRECT WOOT Code Jam 2016 Qualifier
 * Written By: Anthony Prestia
 */

import java.util.*;
import java.io.*;

public class TrainTimetable {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int N = in.nextInt();
            int Nt = -1;
            if (N == 0) {
                System.out.println("Case #" + i + ": INSOMNIA");
                continue;
            }
            HashSet<Character> digits = new HashSet<>();
            String nString;
            int temp = 1;
            while (digits.size() < 10) {
                Nt = temp * N;
                nString = Integer.toString(Nt);
                for (int j = 0; j < nString.length(); j++) {
                    digits.add(nString.charAt(j));
                }
                temp++;
            }
            System.out.println("Case #" + i + ": " + Nt);
        }
    }
}
