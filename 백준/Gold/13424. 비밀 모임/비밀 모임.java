import java.io.*;
import java.util.*;
public class Main {
    static final int INF = 1000000000;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] dist = new int[N+1][N+1];
            for(int i = 1 ; i <= N ; i ++){
                for(int j = 1 ; j <= N ; j ++)
                    dist[i][j] = (i == j) ? 0 : INF;
            }

            for(int i = 1 ; i <= M ; i ++){
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                // 무방향
                dist[a][b] = d;
                dist[b][a] = d;
            }

            // 플로이드워셜 알고리즘
            for(int k = 1 ; k <= N ; k ++){
                for(int start = 1 ; start <= N ; start ++) {
                    for(int end = 1 ; end <= N ; end ++) {
                        if(start == end) continue;
                        else dist[start][end] = Math.min(dist[start][end], dist[start][k] + dist[k][end]);
                    }
                }
            }

            int K = Integer.parseInt(br.readLine());

            int[] friends = new int[K];
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < K ; i ++)
                friends[i] = Integer.parseInt(st.nextToken());

            // 결과값 도출
            int min = INF, idx = -1;
            for(int i = 1 ; i <= N ; i ++){
                int sum = 0;
                for(int k = 0 ; k < K ; k ++)
                    sum += dist[friends[k]][i];

                if(min > sum){
                    min = sum;
                    idx = i;
                }
            }

            System.out.println(idx);
        }
    }
}