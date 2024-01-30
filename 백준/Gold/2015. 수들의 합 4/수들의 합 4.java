import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 1);
        long cnt = 0;
        int[] sum = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i-1]+Integer.parseInt(st.nextToken());
            if (map.containsKey(sum[i]-K)){
                cnt+=map.get(sum[i]-K);
            }
            if (map.containsKey(sum[i])){
                map.replace(sum[i], map.get(sum[i])+1);
            }
            else map.put(sum[i], 1);
        }

        bw.write(cnt+"\n");
        bw.flush();
        bw.close();
    }
}