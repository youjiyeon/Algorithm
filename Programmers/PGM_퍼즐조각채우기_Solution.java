import java.util.LinkedList;
import java.util.Queue;

public class PGM_퍼즐조각채우기_Solution {
	public static int N;
	public static int[][] map;
	public static boolean[][] visit;
	// 상하좌우
	public static int[][] way = {{-1,0},{1,0},{0,-1},{0,1}};
	public int solution(int[][] game_board, int[][] table) {
		int answer = 0;
		N = game_board.length;
		map = game_board;
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visit[i][j] && map[i][j]==0)
				{
					bfs(i,j);
					answer++;
				}
			}
		}


		return answer;
	}

	public static void bfs(int x, int y){
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});
		int cx = 0;
		int cy = 0;

		while (!q.isEmpty()){
			x = q.peek()[0];
			y = q.peek()[1];
			visit[x][y] = true;
			q.poll();
			for (int i = 0; i < 4; i++) {
				cx = x + way[i][0];
				cy = y + way[i][1];
				if(cx>=0 && cx<N && cy>=0 && cy<N)
				{
					if(map[cx][cy] == 0 && !visit[cx][cy]) {
						q.offer(new int[] {cx, cy});
						visit[cx][cy] = true;
					}
				}
			}
		}
	}
}
