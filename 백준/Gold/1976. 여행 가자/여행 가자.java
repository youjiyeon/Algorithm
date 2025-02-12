import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int[][] arr;
    static boolean[] visited;

    public static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i < n; i++) {
                if (arr[cur][i] == 1 && !visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int[] travel = new int[m];
        for (int i = 0; i < m; i++) {
            travel[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        // BFS 실행 (여행 시작 도시 기준)
        bfs(travel[0]);

        // 모든 여행 도시가 같은 연결 요소 내에 있는지 확인
        boolean possible = true;
        for (int i = 1; i < m; i++) {
            if (!visited[travel[i]]) {
                possible = false;
                break;
            }
        }

        System.out.println(possible ? "YES" : "NO");
    }
}