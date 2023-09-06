import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean[][] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        adj = new boolean[N+1][N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            adj[parent][child] = true;
        }

        for(int k=1; k<=N; k++) {
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=N; j++) {
                    if(adj[i][k] && adj[k][j]) {
                        adj[i][j] = true;
                    }
                }
            }
        }

        int[] cnt = new int[N+1];
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(adj[i][j] || adj[j][i]) {
                    cnt[i] ++;
                }
            }
        }

        int res =0;
        for(int num : cnt) {
            if(num == N-1) res++;
        }
        System.out.println(res);
    }
}