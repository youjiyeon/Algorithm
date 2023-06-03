import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_6593_Main {

	public static class Node{
		int l;
		int r;
		int c;

		public Node(int l, int r, int c) {
			this.l = l;
			this.r = r;
			this.c = c;
		}
	}

	// L: 층 수, R: 행, C: 열
	public static int L, R, C;
	// 시작점과 종점
	public static int sl, sr, sc;
	// 상 하 좌 우
	public static int[][] way = {{0,-1,0},{0,1,0},{0,0,-1},{0,0,1},
		{1,0,0},{-1,0,0}};
	public static char[][][] map;
	public static boolean[][][] visit;

	public static void main(String[] args) throws IOException {
		// 일차원이 아니라 층이 존재
		// 일차원 순회한 것처럼 층마다 순회 하면 됨

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true){

			StringTokenizer st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			if(L==0 && R==0 && C==0){
				return;
			}
			map = new char[L][R][C];
			visit = new boolean[L][R][C];

			char val = 0;
			for (int i = 0; i < L; i++) {
				for (int j = 0; j < R; j++) {
					String str = br.readLine();
					for (int k = 0; k < C; k++) {
						val = str.charAt(k);
						map[i][j][k] = val;
						if(val == 'S'){
							sl = i;
							sr = j;
							sc = k;
						}
					}
				}
				br.readLine();
			}

			bfs(new Node(sl, sr, sc));
		}
	}

	public static void bfs(Node n){
		Queue<Node> q = new LinkedList<>();
		q.offer(n);
		visit[n.l][n.r][n.c] = true;
		int time = 0;
		while (!q.isEmpty()){
			int size = q.size();

			for (int i = 0; i < size; i++) {
				Node cur = q.poll();
				if(map[cur.l][cur.r][cur.c] == 'E'){
					System.out.println("Escaped in "+ time +" minute(s).");
					return;
				}

				for (int w = 0; w < 6; w++) {
					int nl = cur.l + way[w][0];
					int nr = cur.r + way[w][1];
					int nc = cur.c + way[w][2];

					// 경계 체크
					if(isRight(nl, nr, nc) &&
						!visit[nl][nr][nc] &&
						map[nl][nr][nc]!='#'){
						visit[nl][nr][nc] = true;
						q.offer(new Node(nl, nr, nc));
					}
				}
			}
			time++;
		}
		System.out.println("Trapped!");
	}

	public static boolean isRight(int l, int r, int c){
		if(l>=0 && l<L && r>=0 && r<R && c>=0 && c<C){
			return true;
		}
		return false;
	}
}
