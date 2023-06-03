import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2589_Main {

	public static class Node{
		int x;
		int y;
		int cnt;

		public Node(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	public static int N, M, answer;
	public static char[][] map;
	// 상하좌우
	public static int[][] way = {{-1,0},{1,0},{0,-1},{0,1}};
	public static boolean[][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visit = new boolean[N][M];
		answer = 0;

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 'L'){
					visit = new boolean[N][M];
					answer = Math.max(bfs(i, j), answer);
				}
			}
		}

		System.out.println(answer);
	}

	public static int bfs(int x, int y){
		int val = 0;
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x,y,0));
		visit[x][y] = true;

		while (!q.isEmpty()){
			Node cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur.x+way[i][0];
				int ny = cur.y+way[i][1];

				// 체크
				if((nx>=0 && nx<N && ny>=0 && ny<M) &&
				!visit[nx][ny] &&
				map[nx][ny] != 'W'){
					visit[nx][ny] = true;
					q.offer(new Node(nx,ny, cur.cnt+1));
					val = Math.max(val, cur.cnt+1);
				}
			}
		}

		return val;
	}
}
