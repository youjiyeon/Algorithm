import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1926_Main {

	public static int M, N, max;
	public static int[][] map;
	public static boolean[][] visit;
	// 상하좌우
	public static int[][] way = {{-1,0},{1,0},{0,-1},{0,1}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		int cnt = 0;
		max = 0;
		map = new int[M][N];
		visit = new boolean[M][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(!visit[i][j] && map[i][j]==1)
				{
					bfs(i,j);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		System.out.print(max);
	}

	public static void bfs(int x, int y){
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});
		int cx = 0;
		int cy = 0;
		int val = 1;
		while (!q.isEmpty()){
			x = q.peek()[0];
			y = q.peek()[1];
			visit[x][y] = true;
			max = Math.max(max, val);
			q.poll();
			for (int i = 0; i < 4; i++) {
				cx = x + way[i][0];
				cy = y + way[i][1];
				if(cx>=0 && cx<M && cy>=0 && cy<N)
				{
					if(map[cx][cy] == 1 && !visit[cx][cy]) {
						q.offer(new int[] {cx, cy});
						visit[cx][cy] = true;
						val++;
					}
				}
			}
		}
	}
}