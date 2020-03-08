package uva;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.io.PrintWriter;

public class Task11286 {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int T;
        while ((T = Integer.parseInt(in.nextLine())) != 0) {
            Map<String, Integer> m = new HashMap<>();
            for (int i = 0; i < T; i += 1) {
                List<String> ll = Arrays.asList(in.nextLine().split(" "));
                Collections.sort(ll);
                StringBuilder b = new StringBuilder();
                for (String e : ll) {
                    b.append(e);
                }
                String key = b.toString();
                m.merge(key, 1, Integer::sum);
            }

            int max = 0;
            for (int x : m.values()) {
                max = Math.max(x, max);
            }

            int count = 0;
            for (int x : m.values()) {
                if (x == max) {
                    count += x;
                }
            }

            out.println(count);
        }
    }
}
