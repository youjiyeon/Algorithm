// visit은 없어도 될것 같고
// 이동할 때마다 맥주하나 까고
// 맥주 없으면 이동 안됨
// 어? 도착지에 도착하면 happy
//
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_9205_Main {
    // 집, 편의점, 페스티벌
    public static int N, startX, startY, endX, endY;
    public static final int dis = 20 * 50; // 맥주 갯수 * 거리
    public static List<int[]> list;
    public static boolean flag = false;
    public static boolean[] visit;
    public static int[][] way = {{-50,0},{50,0},{0,-50},{0,50}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            list = new ArrayList<>();
            flag = false;
            visit = new boolean[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                list.add(new int[] {x, y});
            }
            st = new StringTokenizer(br.readLine());
            endX = Integer.parseInt(st.nextToken());
            endY = Integer.parseInt(st.nextToken());

            // dfs
            dfs(startX, startY);
            if(flag) System.out.println("happy");
            else System.out.println("sad");
        }
    }

    private static void dfs(int x, int y) {
        if(flag) return;

        if(Math.abs(x-endX)+Math.abs(y-endY)<=dis){
            flag = true;
            return;
        }

        for (int i = 0; i < N; i++) {
            if(visit[i]) continue;
            if(Math.abs(x-list.get(i)[0])+Math.abs(y-list.get(i)[1])>dis){
                continue;
            }
            visit[i] = true;
            dfs(list.get(i)[0], list.get(i)[1]);
        }
    }
}
