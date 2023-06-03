import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16928_Main {
	// 사다리
	public static int[][] ladder;
	// 뱀
	public static int[][] snake;
	public static boolean[] visit;
	public static int L, S;
	public static void main(String[] args) throws IOException {
		// 1 - 100까지 bfs
		// 1-6까지 loop

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		ladder = new int[L][2];
		snake = new int[S][2];
		visit = new boolean[101];

		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			ladder[i][0] = Integer.parseInt(st.nextToken());
			ladder[i][1] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < S; i++) {
			st = new StringTokenizer(br.readLine());
			snake[i][0] = Integer.parseInt(st.nextToken());
			snake[i][1] = Integer.parseInt(st.nextToken());
		}

		bfs();
	}

	public static void bfs(){
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		visit[1] = true;
		int cnt = 0;
		while (!q.isEmpty()){
			int size = q.size();

			for (int i = 0; i < size; i++) {
				int cur = q.poll();

				if(cur == 100){
					System.out.println(cnt);
					return;
				}

				// 주사위만큼
				for (int j = 1; j <= 6; j++) {
					int next = cur + j;

					// 경계 체크, 방문 체크
					// 사다리 & 뱀 체크
					if(next>= 1 && next<=100 &&
						!visit[next]){
						boolean lflag = false, sflag = false;
						for (int l = 0; l < L; l++) {
							if(next == ladder[l][0]){
								//visit[next] = true;
								visit[ladder[l][1]] = true;
								q.offer(ladder[l][1]);
								lflag = true;
							}
						}
						for (int s = 0; s < S; s++) {
							if(next == snake[s][0]){
								//visit[next] = true;
								visit[snake[s][1]] = true;
								q.offer(snake[s][1]);
								sflag = true;
							}
						}

						if(!lflag && !sflag) {
							visit[next] = true;
							q.offer(next);
						}
					}
				}
			}
			cnt++;
		}
	}
}
