import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_10974_Main {

	public static int N;
	public static int[] map;
	public static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N];
		visited = new boolean[N+1];
		per(0);
	}

	static void per(int cnt) {

		if(cnt == N)
		{
			for (int i: map) {
				System.out.print(i+ " ");
			}
			System.out.println();
			return;
		}

		for (int i = 1; i <= N; i++) {
			if(!visited[i])
			{
				visited[i] = true;
				map[cnt] = i;
				per(cnt+1);
				visited[i] = false;
			}
		}
	}
}
