import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            bw.write("#"+t+" ");

            long cnt = 0L;
            PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> min = new PriorityQueue<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] tmp = new int[2];

            int first = Integer.parseInt(st.nextToken());
            max.offer(first);

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                tmp[0] = Integer.parseInt(st.nextToken());
                tmp[1] = Integer.parseInt(st.nextToken());

                int big = 0;
                int small = 0;
                int mid = max.peek();
                for (int j = 0; j < 2; j++) {
                    if (tmp[j]<mid){
                        small++;
                    }
                    else if (tmp[j]>mid) {
                        big++;
                    }
                }

                // 둘다 작을때
                if (small==2) {
                    max.offer(tmp[0]);
                    max.offer(tmp[1]);
                    min.offer(max.poll());
                }
                // 둘다 클때
                else if (big==2) {
                    min.offer(tmp[0]);
                    min.offer(tmp[1]);
                    max.offer(min.poll());
                }
                else {
                    if (tmp[0]<tmp[1]){
                        max.offer(tmp[0]);
                        min.offer(tmp[1]);
                    }
                    else if (tmp[0]>tmp[1]) {
                        max.offer(tmp[1]);
                        min.offer(tmp[0]);
                    }
                }
                cnt=(cnt+max.peek())%20171109;
            }

            bw.write(cnt+"\n");
        }

        bw.flush();
        bw.close();
    }
}