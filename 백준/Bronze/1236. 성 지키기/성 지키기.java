import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        boolean[] checkC = new boolean[c];
        boolean[] checkR = new boolean[r];
        int cCnt = 0;
        int rCnt = 0;
        for (int i = 0; i < c; i++) {
            String str = br.readLine();
            for (int j = 0; j < r; j++) {
                char ch = str.charAt(j);
                if (ch == 'X') {
                    if (!checkR[j]) {
                        checkR[j] = true;
                        rCnt++;
                    }
                    if (!checkC[i]) {
                        checkC[i] = true;
                        cCnt++;
                    }
                }
            }
        }

        System.out.println(Math.max(r-rCnt, c-cCnt));
    }
}