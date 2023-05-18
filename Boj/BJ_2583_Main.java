import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2583_Main {

	public static int M, N, K;
	public static int[][] map;
	public static boolean[][] visit;
	// 상하좌우
	public static int[][] way = {{-1,0},{1,0},{0,-1},{0,1}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		int cnt = 0;
		map = new int[M][N];
		visit = new boolean[M][N];
		PriorityQueue<Integer> priorityQueueLowest = new PriorityQueue<>();

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			int ex = Integer.parseInt(st.nextToken());
			int ey = Integer.parseInt(st.nextToken());
			addValue(sy, sx, ey, ex);
		}

/*		for (int[] i: map) {
			System.out.println(Arrays.toString(i));
		}*/

		Queue<Integer> q = new PriorityQueue<>();
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(!visit[i][j] && map[i][j] == 0){
					cnt++;
					q.add(bfs_2583(i,j));
				}
			}
		}

		System.out.println(cnt);
		while (!q.isEmpty()){
			System.out.print(q.poll()+" ");
		}
		/*
		for (int[] i: map) {
			System.out.println(Arrays.toString(i));
		}*/
	}

	private static int bfs_2583(int i, int j) {
		int cnt = 1;
		Queue<int[]> qq = new LinkedList<>();
		qq.offer(new int[] {i,j});
		visit[i][j] = true;

		while (!qq.isEmpty()){
			int size = qq.size();
			while(size-- > 0){
				int cx = qq.peek()[0];
				int cy = qq.peek()[1];
				qq.poll();

				//System.out.println(cx+" "+cy);
				for (int k = 0; k < 4; k++) {
					int nx = cx + way[k][0];
					int ny = cy + way[k][1];

					if(0<=nx && nx<M && 0<=ny && ny<N){
						if(!visit[nx][ny] && map[nx][ny]==0){
							visit[nx][ny] = true;
							//System.out.println(nx+" "+ny);
							qq.offer(new int[] {nx, ny});
							cnt++;
						}
					}
				}
			}
		}
		return cnt;
	}

	private static void addValue(int sx, int sy, int ex, int ey) {

		for (int i = sx; i < ex; i++) {
			for (int j = sy; j < ey; j++) {
				map[i][j] = 1;
			}
		}
	}
}
