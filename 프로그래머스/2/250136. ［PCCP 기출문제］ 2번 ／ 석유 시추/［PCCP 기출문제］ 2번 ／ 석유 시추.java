/*
각 행마다 석유 덩어리와 각 덩어리 구하기
이 중 가장 큰 값 구하기
bfs
*/

import java.util.*;

class Solution {
    public static int n, m;
    public static int[] sum;
    public static int[][] map,
    way = {{0,1},{0,-1},{1,0},{-1,0}};
    public static boolean[][] v;
    public int solution(int[][] land) {
        int answer = 0;
        
        n = land.length;
        m = land[0].length;
        map = new int[n][m];
        sum = new int[m];
        v = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = land[i][j];
                //System.out.print(map[i][j]);
            }
            //System.out.println();
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[j][i]==1 && !v[j][i]) {
                    bfs(j, i);
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            answer = Math.max(answer, sum[i]);
        }
        
        return answer;
    }
    
    public static int bfs(int sx, int sy) {
        int cnt = 0;
        Queue<int[]> q = new LinkedList<>();
        Set<Integer> set = new TreeSet<>();
        q.offer(new int[] {sx, sy});
        v[sx][sy] = true;
        
        while (!q.isEmpty()) {
            int x = q.peek()[0];
            int y = q.peek()[1];
            q.poll();
            set.add(y);
            
            cnt++;
            
            for (int i = 0; i < 4; i++) {
                int nx = x + way[i][0];
                int ny = y + way[i][1];
                
                if (nx<0 || nx>=n || ny<0 || ny>=m || v[nx][ny] 
                    || map[nx][ny]==0) {
                    continue;
                }
                
                q.offer(new int[] {nx, ny});
                v[nx][ny] = true;
            }
        }
        
        for (Integer i : set) {
            sum[i] += cnt;
        }
        
        return cnt;
    }
}