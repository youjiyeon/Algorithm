

import java.io.*;
import java.util.*;

public class Main {

	static int R, C, cheese, melt;
	static int[][] map;
	static int[][] way = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (map[r][c] == 1)
					cheese++;
			}
		}

		int time = 0;
		while (true) {
			melt = 0;
			visited = new boolean[R][C];
			dfs(0, 0);
			cheese -= melt;
			time++;
			if (cheese == 0)
				break;
		}
		System.out.println(time);
		System.out.println(melt);

	}

	private static void bfs() {

		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[R][C];

		q.offer(new int[] { 0, 0 });
		visited[0][0] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + way[i][0];
				int ny = cur[1] + way[i][1];

				// 0일 때 q offer
				if (isRight(nx, ny) && !visited[nx][ny] && map[nx][ny] == 0) {
					q.offer(new int[] { nx, ny });
					visited[nx][ny] = true;
				}
				// 1일 때 녹은 치즈++;
				else if (isRight(nx, ny) && !visited[nx][ny] && map[nx][ny] == 1) {
					visited[nx][ny] = true;
					map[nx][ny] = 0;
					melt++;
				}
			}
		}
	}

	private static void dfs(int x, int y) {

		//Queue<int[]> q = new LinkedList<>();
		

		//q.offer(new int[] { 0, 0 });
		visited[x][y] = true;

		//while (!q.isEmpty()) {
			//int[] cur = q.poll();
		
		if(map[x][y] == 1)
		{
			melt++;
			map[x][y] = 0;
			return;
		}
			for (int i = 0; i < 4; i++) {
				int nx = x + way[i][0];
				int ny = y + way[i][1];

				// 0일 때 q offer
				if (isRight(nx, ny) && !visited[nx][ny]) {
					//q.offer(new int[] { nx, ny });
					//visited[nx][ny] = true;
					dfs(nx, ny);
				}
				/*// 1일 때 녹은 치즈++;
				else if (isRight(nx, ny) && !visited[nx][ny] && map[nx][ny] == 1) {
					visited[nx][ny] = true;
					map[nx][ny] = 0;
					melt++;
				}*/
			}
		//}
	}

	private static boolean isRight(int nx, int ny) {

		if (nx >= 0 && nx < R && ny >= 0 && ny < C)
			return true;
		return false;
	}

}