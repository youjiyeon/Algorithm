import java.io.*;
import java.util.*;

public class Main {

    public static class Node{
        int val;
        String s;

        public Node(int val, String s) {
            this.val = val;
            this.s = s;
        }
    }
    public static boolean[] visit;
    public static String[] cal = {"D", "S", "L", "R"};
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            visit = new boolean[10001];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            sb.append(bfs(start, target)).append("\n");
        }
        System.out.println(sb);
    }

    public static String bfs(int start, int target){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(start, ""));
        visit[start] = true;

        while (!q.isEmpty()){
            Node cur = q.poll();
            if (cur.val==target){
                return cur.s;
            }
            for (int i = 0; i < 4; i++) {
                int temp = play(i,cur.val);
                //System.out.println(temp);
                if (!visit[temp]){
                    visit[temp] = true;
                    q.offer(new Node(temp, cur.s+cal[i]));
                }
            }
        }
        return "";
    }

    public static int play(int mode, int val){
        if (mode==0){
            return (val*2)%10000;
        }

        if (mode==1){
            return (val==0)? 9999: val-1;
        }

        if (mode==2){
            int temp = (val%1000)*10 + val/1000;
            return temp%10000;
        }

        if (mode==3){
            int temp = (val%10) * 1000 + val/10;
            return temp%10000;
        }

        return 0;
    }
}