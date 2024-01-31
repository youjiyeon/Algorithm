import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<Long, Integer> map = new TreeMap<>();
        map.put(0L, 1);
        long cnt = 0;

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] A = new long[N+1];
        for (int i = 1; i <= N; i++) {
            A[i] = A[i-1]+Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        long[] B = new long[N+1];
        for (int i = 1; i <= N; i++) {
            B[i] = B[i-1]+Integer.parseInt(st.nextToken());
        }

        long tmp = 0L;
        for (int i = 1; i <= N; i++) {
            tmp = A[i]-B[i];
            cnt+=map.getOrDefault(tmp, 0);
            map.put(tmp, map.getOrDefault(tmp, 0)+1);
        }

        bw.write(cnt+"\n");
        bw.flush();
        bw.close();
    }
}