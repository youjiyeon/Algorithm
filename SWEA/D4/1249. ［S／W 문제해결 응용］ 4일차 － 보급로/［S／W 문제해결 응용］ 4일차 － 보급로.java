import java.util.*;
import java.io.*;
 
public class Solution {
    static int n;
    static int[][] arr, dp,
    way = {{0,1},{0,-1},{1,0},{-1,0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            dp = new int[n][n];
 
            for (int j = 0; j < n; j++) {
                String str = br.readLine();
                for (int k = 0; k < n; k++) {
                    arr[j][k] = str.charAt(k)-'0';
                    dp[j][k] = Integer.MAX_VALUE;
                }
            }
 
            sb.append("#").append(i).append(" ").append(bfs()).append("\n");
        }
 
        System.out.println(sb);
    }
 
    static int bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0, 0});
        dp[0][0] = 0;
 
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0]+way[i][0];
                int ny = cur[1]+way[i][1];
 
                if (nx<0 || nx >= n || ny<0 || ny >= n) continue;
 
                int tmp = dp[cur[0]][cur[1]] + arr[nx][ny];
                
                if (dp[nx][ny] > tmp) {
                    q.offer(new int[] {nx, ny});
                    dp[nx][ny] = tmp;
                }
                    
            }
        }
 
        return dp[n-1][n-1];
    }
}