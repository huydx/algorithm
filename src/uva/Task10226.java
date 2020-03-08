package uva;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.TreeMap;

public class Task10226 {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int T = Integer.parseInt(in.nextLine());
        in.nextLine();
        for (int i = 0; i < T; i++) {
            Map<String, Integer> map = new TreeMap<>();
            double c = 0;
            while (in.hasNextLine()) {
                String s = in.nextLine();
                if (s == null || s.isEmpty() || s.trim().isEmpty()) {
                    break;
                }
                map.merge(s, 1, Integer::sum);
                c++;
            }
            for (Entry<String, Integer> e : map.entrySet()) {
                out.append(String.format("%s %.4f\n", e.getKey(), 100 * e.getValue() / c));
            }
            if (i < T - 1) {
                out.println("");
            }
        }
    }
}
