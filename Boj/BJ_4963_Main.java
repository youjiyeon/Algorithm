import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_4963_Main {

	public static int W, H;
	public static int[][] map;
	// 상하좌우 대각선(상좌, 상우, 하좌, 하우)
	public static int[][] way = {{-1,0},{1,0},{0,-1},{0,1},
		{-1,-1},{-1,1},{1,-1},{1,1}};
	public static boolean[][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true){
			// input
			StringTokenizer st = new StringTokenizer(br.readLine());
			int cnt = 0;
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			if(W == 0 && H == 0){
				System.out.println(sb);
				return;
			}

			map = new int[H][W];
			visit = new boolean[H][W];

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			//

			// 각각 요소마다 돌면서 bfs
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if(map[i][j] == 1 && !visit[i][j]){
						bfs(i,j);
						cnt++;
					}
				}
			}
			//

			// output
			sb.append(cnt+"\n");
		}
	}

	public static void bfs(int x, int y){
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});
		visit[x][y] = true;

		while (!q.isEmpty()){
			int cx = q.peek()[0];
			int cy = q.peek()[1];
			q.poll();

			for (int i = 0; i < 8; i++) {
				int nx = cx + way[i][0];
				int ny = cy + way[i][1];

				// 경계, 방문, 값 체크
				if((nx>=0 && nx<H && ny>=0 && ny<W) &&
				!visit[nx][ny] && map[nx][ny] == 1){
					q.offer(new int[] {nx, ny});
					visit[nx][ny] = true;
				}
			}
		}
	}
}
