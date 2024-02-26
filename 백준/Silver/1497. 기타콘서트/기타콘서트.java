import java.io.*;
import java.util.*;

public class Main {
    static int N, M, min = Integer.MAX_VALUE;
    static int max = 0;
    static long[] guitar;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        guitar = new long[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            char[] guitarTF = st.nextToken().toCharArray();

            for(int j = 0; j < M; j++){
                if (guitarTF[j] == 'Y') {
                    guitar[i] |= (1L<<j);
                }
            }
        }

        search(0,  0L, 0);
        if (min == 0) {
            min = -1;
        }

        System.out.println(min);
    }

    static void search(int cnt, long guitarMask, int val){
        int bitCount = Long.bitCount(guitarMask);

        if (bitCount == max && val < min) {
            min = val;
        }
        if (bitCount > max) {
            min = val;
            max = bitCount;
        }
        if (bitCount == M || cnt == N){
            return;
        }

        search(cnt+1, guitarMask | guitar[cnt], val+1);
        search(cnt+1, guitarMask, val);
    }
}