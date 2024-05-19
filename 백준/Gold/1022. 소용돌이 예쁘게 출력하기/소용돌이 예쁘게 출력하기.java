import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        int[][] arr = new int[r2-r1+1][c2-c1+1];
        int max = 0;
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                arr[i-r1][j-c1] = play(i, j);
                max = Math.max(max, arr[i-r1][j-c1]);
            }
        }

        StringBuilder sb = new StringBuilder("%");
        sb.append(String.valueOf(max).length());
        sb.append("d ");

        for (int i = 0; i <= r2-r1; i++) {
            for (int j = 0; j <= c2-c1; j++) {
                System.out.printf(sb.toString(), arr[i][j]);
            }
            System.out.println();
        }
    }

    static int play(int r, int c) {
        int border = Math.max(Math.abs(r), Math.abs(c));
        int min = (int)Math.pow(2*border-1, 2)+1;

        if (r == border) {
            return min + 7*border -1 + c;
        }
        if (c == -border) {
            return min + 5*border -1 + r;
        }
        if (r == -border) {
            return min + 3*border -1 - c;
        }

        return min + border -1 - r;
    }
}