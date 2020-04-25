package uva;

import java.util.BitSet;
import java.util.Scanner;
import java.io.PrintWriter;

// Another n-queen
public class Task11195 {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int c = 1;
        while (true) {
            int n = Integer.parseInt(in.nextLine());
            if (n == 0) {
                break;
            }
            int[][] board = new int[n][n];
            for (int i = 0; i < n; i++) {
                String l = in.nextLine();
                int j = 0;
                for (char ch : l.toCharArray()) {
                    board[i][j] = ch == '.' ? 1 : 0;
                    j++;
                }
            }
            int result = new Solver().solve(board);
            System.out.printf("Case %d: %d\n", c, result);
            c++;
        }
    }

    private static class Solver {
        int ans = 0;
        BitSet rw = new BitSet(30);
        BitSet ld = new BitSet(30);
        BitSet rd = new BitSet(30);

        private int solve(int[][] board) {
            backtrack(0, board);
            return ans;
        }

        private void backtrack(int c, int[][] board) {
            int n = board.length;
            if (c == n) {
                ans++;
                return;
            }
            for (int r = 0; r < n; r++) {
                if (board[r][c] != 0 && !rw.get(r) && !ld.get(r - c + n - 1) && !rd.get(r + c)) {
                    rw.set(r, true);
                    ld.set(r - c + n - 1, true);
                    rd.set(r + c, true);

                    backtrack(c + 1, board);

                    rw.set(r, false);
                    ld.set(r - c + n - 1, false);
                    rd.set(r + c, false);
                }
            }
        }
    }

}
