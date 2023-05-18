import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11403_Main {

	public static int N;
	public static boolean flag;
	public static int[][] map, result;
	public static boolean[] visit;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		result = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 경로 찾기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// if(i==j) {
				// 	result[i][j] = 1;
				// 	continue;
				// }

				visit = new boolean[N];
				flag = false;
				dfs(i,j);
				// 경로가 있다면
				if(flag) {
					result[i][j] = 1;
				}
			}
		}

		// 출력
		for (int i = 0; i < N; i++){
			for (int r: result[i]) {
				System.out.print(r+" ");
			}
			System.out.println();
		}

	}

	private static void dfs(int i, int j) {

		if(i!=j) {
			visit[i] = true;
		}
		// i열 뒤지기
		for (int k = 0; k < N; k++) {
			if(!visit[k] && map[i][k] != 0)
			{
				if(k==j) {
					flag = true;
				}
				visit[k] = true;
				dfs(k, j);
			}
		}
		//System.out.println(i+" "+j+" "+flag);
	}
}
