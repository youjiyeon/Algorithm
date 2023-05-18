import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1389_Main {

	public static int N, M, sum, cnt, minIdx, min;
	public static int[][] map;
	public static boolean[] visit;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		min = Integer.MAX_VALUE;

		int x, y;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			map[x][y] = 1;
			map[y][x] = 1;
		}

		// 경로 찾기
		for (int i = 1; i <= N; i++) {
			visit = new boolean[N+1];
			bfs(i);
		}

		// 출력
		System.out.println(minIdx);

	}

	private static void bfs(int start) {
		Queue<int[]> q = new LinkedList<>();
		int cnt = 0;

		visit[start] = true;
		q.offer(new int[] {start, 0});
		while (!q.isEmpty()){
			int current = q.peek()[0];
			int val = q.peek()[1];
			cnt += val;
			q.poll();

			for (int k = 1; k <= N; k++) {
				if(!visit[k] && map[current][k]==1)
				{
					visit[k] = true;
					q.offer(new int[] {k, val+1});
				}
			}
		}

		if(min>cnt)
		{
			min = cnt;
			minIdx = start;
		}
	}
}
