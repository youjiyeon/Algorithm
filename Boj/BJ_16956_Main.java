import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16956_Main {
	public static int R, C;
	public static char[][] map;
	public static Queue<int[]> wolf;
	public static int[][] way = {{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		wolf = new LinkedList<>();
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'W'){
					wolf.offer(new int[] {i,j});
				}
			}
		}

		bfs();

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

	public static void bfs(){
		while (!wolf.isEmpty()){
			int x = wolf.peek()[0];
			int y = wolf.peek()[1];
			wolf.poll();
			for (int i = 0; i < 4; i++) {
				int nx = x + way[i][0];
				int ny = y + way[i][1];

				// 경계 체크
				if(nx>=0 && nx<R && ny>=0 && ny<C){
					if(map[nx][ny] == '.'){
						map[nx][ny] = 'D';
					}
					else if(map[nx][ny] == 'S'){
						System.out.println(0);
						return;
					}
				}
			}
		}
		System.out.println(1);
	}
}
