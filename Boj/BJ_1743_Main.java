import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1743_Main {
	public static int N, M, K, max, temp;
	public static int[][] map;
	public static boolean[][] visit;
	public static int[][] way = {{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		max = 0;
		map = new int[N+1][M+1];
		visit = new boolean[N+1][M+1];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = 1;
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if(!visit[i][j] && map[i][j]==1){
					temp = 0;
					visit[i][j] = true;
					dfs(i,j);
					//bfs(i,j);
					max = Math.max(temp,max);
				}
			}
		}
		System.out.println(max);
	}

	public static void dfs(int x, int y){

		temp++;
		for (int i = 0; i < 4; i++) {
			int nx = x + way[i][0];
			int ny = y + way[i][1];
			if( nx>=1 && nx<=N && ny>=1 && ny<=M &&
				!visit[nx][ny] &&
				map[nx][ny] == 1
			){
				visit[nx][ny] = true;
				dfs(nx, ny);
			}
		}
	}

	public static void bfs(int x, int y){
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x,y});
		temp = 1;
		while (!q.isEmpty()){
			int cx = q.peek()[0];
			int cy = q.peek()[1];
			q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cx + way[i][0];
				int ny = cy + way[i][1];
				if( nx>=1 && nx<=N && ny>=1 && ny<=M &&
					!visit[nx][ny] &&
					map[nx][ny] == 1){
					visit[nx][ny] = true;
					q.offer(new int[] {nx,ny});
					temp++;
				}
			}
		}
	}
}
