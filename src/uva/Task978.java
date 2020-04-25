package uva;

import java.util.Comparator;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.TreeSet;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Task978 {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            // each test
            int b = in.nextInt();
            int gb = in.nextInt();
            int sb = in.nextInt();

            TreeSet<Integer> gbt = new TreeSet<>((o1, o2) -> Integer.compare(o2, o1));
            TreeSet<Integer> sbt = new TreeSet<>((o1, o2) -> Integer.compare(o2, o1));
            for (int j = 0; j < gb; j++) {
                gbt.add(in.nextInt());
            }
            for (int j = 0; j < sb; j++) {
                sbt.add(in.nextInt());
            }
            while (b-- > 0) {
                Integer topg = gbt.first();
                out.println(topg);
                gbt.remove(topg);
                Integer topb = sbt.first();
                out.println(topb);
                sbt.remove(topb);
                if (topg == null && topb == null) {
                    out.println("green and blue died");
                } else if (topg == null) {
                    out.println("blue wins");
                    out.println(topb);
                } else if (topb == null) {
                    out.println("green wins");
                    out.println(topg);
                } else {
                    if (topg > topb) {
                        gbt.add(topg - topb);
                    } else if (topb > topg) {
                        sbt.add(topb - topg);
                    }
                }
            }
        }
    }
}
