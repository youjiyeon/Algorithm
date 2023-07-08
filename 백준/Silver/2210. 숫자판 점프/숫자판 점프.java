import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static int answer;
    public static int[][] map,
    way = {{-1,0},{1,0},{0,-1},{0,1}};
    public static boolean[] visit;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new int[5][5];
        visit = new boolean[1000000];
        for (int i = 0; i < 5; i++) {
            StringTokenizer st =  new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                // 각 자리마다 경우를 따져본다.
                make(map[i][j], 0, i, j);
            }
        }
        System.out.println(answer);
    }

    public static void make(int sum, int cnt, int r, int c){
        // 기저 조건
        if(cnt==5){
            if(!visit[sum]){
                visit[sum] = true;
                answer++;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nr = r + way[i][0];
            int nc = c + way[i][1];
            if(nr>=0 && nr<5 && nc>=0 && nc<5){
                make(sum*10+map[nr][nc], cnt+1, nr, nc);
            }
        }
    }
}