import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_3184_Main {

	public static int R, C, totalS, totalW;
	public static String[][] map;
	public static boolean[][] visit;
	public static int[][] way = {{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) throws IOException {
		// 울타리를 만나기 전까지 양의 갯수와 늑대의 갯수를 세기
		// 양 > 늑대 늑대 0
		// 이외에는 양 0

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new String[R][C];
		visit = new boolean[R][C];
		totalS = 0;
		totalW = 0;

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			map[i] = str.split("");
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(!visit[i][j] && map[i][j].equals("#")){
					bfs(i,j);
				}
			}
		}
		System.out.println(totalS + " " + totalW);
	}

	public static void bfs(int x, int y){
		int cntS = 0;
		int cntW = 0;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x,y});
		visit[x][y] = true;

		while (!q.isEmpty()){
			int cx = q.peek()[0];
			int cy = q.peek()[1];
			q.poll();
			if(map[cx][cy].equals("k")) cntS++;
			else if(map[cx][cy].equals("v")) cntW++;

			for (int i = 0; i < 4; i++) {
				int nx = cx + way[i][0];
				int ny = cy + way[i][1];

				if((nx >= 0 && nx<R && ny>=0 && ny<C) &&
					!visit[nx][ny] && !map[nx][ny].equals("#")){

					q.offer(new int[] {nx, ny});
					visit[nx][ny] = true;
				}
			}
		}

		if(cntS>cntW){
			totalS+=cntS;
		}
		else {
			totalW+=cntW;
		}
	}
}
