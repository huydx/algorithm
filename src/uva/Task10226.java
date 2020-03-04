package uva;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.TreeMap;

public class Task10226 {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int T = in.nextInt();
        in.nextLine();
        int c = 0;
        for (int j = 0; j < T; j++) {
            Map<String, Integer> map = new TreeMap<>();
            while (true) {
                String s = in.nextLine();
                if (s == null || s.equals("")) {
                    break;
                } else {
                    c++;
                    Integer i = map.get(s);
                    if (i == null) {
                        i = 0;
                    }
                    map.put(s, i + 1);
                }
            }
            for (Entry<String, Integer> e : map.entrySet()) {
                out.println(String.format("%s %.4f", e.getKey(), (float) 100 * e.getValue() / c));
            }
            if (j == T-1) {
                return;
            } else {
                in.nextLine();
            }
        }
    }
}
