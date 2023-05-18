import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_15649_Main {

	public static int N, M;
	public static boolean[] visited;
	public static int[] pick;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N+1];
		pick = new int[M];

		per(0);
	}

	static void per(int cnt){

		if(cnt == M){

			for (int i = 0; i < M; i++) {
				System.out.print(pick[i]+" ");
			}
			System.out.println();
			return;
		}

		for (int i = 1; i <= N; i++) {
			if(!visited[i]){
				visited[i] = true;
				pick[cnt] = i;
				per(cnt+1);
				visited[i] = false;
			}
		}
	}
}
