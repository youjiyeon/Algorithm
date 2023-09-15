import java.io.*;
import java.util.*;

public class Main {
    public static int start, end;
    public static int[] time, parent;
    public static int[] way = {1,-1,2};

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        time = new int[100001];
        parent = new int[100001];

        bfs();
        Stack<Integer> stack = new Stack<>();
        stack.push(end);
        int i = end;
        while (i!=start){
            stack.push(parent[i]);
            i = parent[i];
        }

        sb.append(time[end]-1).append("\n");
        while (!stack.isEmpty()){
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
    }

    public static void bfs(){
        List<Integer> list = new ArrayList<>();
        list.add(start);
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        time[start] = 1;

        while (!q.isEmpty()){
            int cur = q.poll();

            if (cur==end){
                return;
            }

            for (int i = 0; i < 3; i++) {
                int next = cur;
                if (i==2){
                    next *= way[i];
                } else next += way[i];

                if (next<0 || next> 100000) continue;

                if (time[next] == 0){
                    q.offer(next);
                    time[next] = time[cur]+1;
                    parent[next] = cur;
                }
            }
        }
    }
}