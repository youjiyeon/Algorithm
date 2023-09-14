import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int N, M, B, max, T = Integer.MAX_VALUE;
    public static int[][] map,
    way = {{0,1},{0,-1},{-1,0},{1,0}};
    // 1 동, 2 서, 3 북, 4 남

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int h = 0; h <= 256; h++) {
            int build = 0;
            int remove = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int height = map[i][j] - h;
                    if (height>0) remove += height;
                    else if (height<0) {
                        build -= height;
                    }
                }
            }
            if (remove + B >= build){
                int time = remove * 2 + build;
                if(T>=time){
                    T = time;
                    max = h;
                }
            }
        }

        System.out.println(T+" "+max);
    }
}