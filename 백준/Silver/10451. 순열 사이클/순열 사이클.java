import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n;
    public static List<Integer>[] lists;
    public static boolean[] visit;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int cnt = 0;
            n = Integer.parseInt(br.readLine());
            lists = new List[n+1];
            for (int i = 1; i <= n; i++) {
                lists[i] = new ArrayList<>();
            }
            visit = new boolean[n+1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                lists[i].add(Integer.parseInt(st.nextToken()));
            }
            for (int i = 1; i <= n; i++) {
                if(!visit[i]){
                    //bfs
                    if(bfs(i)){
                        cnt++;
                    }
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }

    private static boolean bfs(int start) {
        visit[start] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while (!q.isEmpty()){
            int cur = q.poll();

            for (int i = 0; i < lists[cur].size(); i++) {
                if (lists[cur].get(i)==start){
                    return true;
                }
                if (!visit[lists[cur].get(i)]){
                    visit[lists[cur].get(i)] = true;
                    q.offer(lists[cur].get(i));
                }
            }
        }

        return false;
    }
}