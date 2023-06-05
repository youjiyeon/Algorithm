import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_11123_Main {
	public static int H, W, cnt;
	public static char[][] map;
	public static boolean[][] visit;
	public static int[][] way = {{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());

			cnt = 0;
			map = new char[H][W];
			visit = new boolean[H][W];

			for (int i = 0; i < H; i++) {
				String str = br.readLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = str.charAt(j);
				}
			}

			// 탐색
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if(!visit[i][j] && map[i][j] == '#'){
						visit[i][j] = true;
						bfs(i,j);
						//dfs(i,j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}

	public static void bfs(int x, int y){
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});

		while (!q.isEmpty()){
			int cx = q.peek()[0];
			int cy = q.peek()[1];
			q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cx + way[i][0];
				int ny = cy + way[i][1];

				if( nx>=0 && nx<H && ny>=0 && ny<W &&
					!visit[nx][ny] &&
					map[nx][ny] == '#'){
					q.offer(new int[] {nx, ny});
					visit[nx][ny] = true;
				}
			}
		}
	}
	public static void dfs(int x, int y){
		for (int i = 0; i < 4; i++) {
			int nx = x + way[i][0];
			int ny = y + way[i][1];
			if( nx>=0 && nx<H && ny>=0 && ny<W &&
				!visit[nx][ny]&&
				map[nx][ny] == '#'){
				visit[nx][ny] = true;
				dfs(nx,ny);
			}
		}
	}
}
