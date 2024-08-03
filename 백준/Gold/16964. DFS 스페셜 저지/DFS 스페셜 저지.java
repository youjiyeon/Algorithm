import java.io.*;
import java.util.*;

public class Main {
    static int n, idx;
    static int[] origin;
    static List<Integer>[] list;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        origin = new int[n];
        visit = new boolean[n+1];
        list = new List[n+1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            origin[i] = Integer.parseInt(st.nextToken());
        }

        // 루트 노드 확인
        if (origin[0] == 1) {
            visit[1] = true;
            idx = 1;
            dfs(-1, 1);
        }
        System.out.println(idx == n ? 1 : 0);
    }

    static void dfs(int par, int curNode) {
        Set<Integer> s = new HashSet<>();
        for(int i = 0; i < list[curNode].size(); i++) {
            int next = list[curNode].get(i);
            if(next!=par) s.add(next);
        }
        int len = s.size();
        if (len==0) return;
        while (len>0){
            int val = origin[idx];
            if (!visit[val] && s.contains(val)){
                idx++;
                visit[val] = true;
                dfs(curNode, val);
                len--;
            }
            else break;
        }
    }
}