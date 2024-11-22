import java.util.*;

class Solution {
    static int N;
    static boolean[] v;
    static List<Integer>[] list;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        int w = wires.length;
        
        N = n;
        list = new List[n+1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < w; i++) {
            int to = wires[i][0];
            int from = wires[i][1];
            
            list[to].add(from);
            list[from].add(to);
        }
        
        for (int i = 0; i < w; i++) {
            int to = wires[i][0];
            int from = wires[i][1];
            
            //list[to].remove(from);
            //list[from].remove(to);
            
            int tCnt = bfs(to, from);
            int fCnt = bfs(from, to);
            
            //list[to].add(from);
            //list[from].add(to);
            
            answer = Math.min(Math.abs(tCnt - fCnt), answer);
        }
        
        return answer;
    }
    
    static int bfs(int start, int not) {
        v = new boolean[N+1];
        v[start] = true;
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(start);
        int cnt = 1;
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            for (int i : list[cur]) {
                if (v[i] || i==not) continue;
                q.offer(i);
                v[i] = true;
                cnt++;
            }
        }
        
        return cnt;
    }
}