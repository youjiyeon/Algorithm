import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            bw.write("#"+t+" ");

            PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                switch (Integer.parseInt(st.nextToken())){
                    case 1:
                        q.offer(Integer.parseInt(st.nextToken()));
                        break;
                    case 2:
                        if (!q.isEmpty()){
                            bw.write(q.poll()+" ");
                        }
                        else bw.write(-1+" ");
                }
            }

            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}