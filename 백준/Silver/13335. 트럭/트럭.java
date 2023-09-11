import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    public static int n, w, l;
    public static Queue<Integer> truck = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            truck.add(Integer.parseInt(st.nextToken()));
        }

        // 트럭을 가지고 있는 주머니
        // 다리 이동
        // 초마다 확인 후 담았다가 큐에서 내보내기???
        int time = 0;
        int bw = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < w; i++) {
            q.offer(0);
        }

        while (!q.isEmpty()){
            time++;
            bw-=q.poll();
            if (!truck.isEmpty()){
                if (truck.peek()+bw<=l){
                    bw+=truck.peek();
                    q.offer(truck.poll());
                }
                else {
                    q.offer(0);
                }
            }
        }

        System.out.println(time);
    }
}