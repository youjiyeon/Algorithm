import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2098_Main {

	static int N;
	static int result = Integer.MAX_VALUE;
	static int[][] ad;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		ad = new int[N][N];
		visited = new boolean[N];

		for (int i = 0; i < N; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
			{
				ad[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 모든 곳에서 시작
		for (int i = 0; i < N; i++)
		{
			dfs(i, i, 0, 0);
		}

		System.out.println(result);
	}

	static void dfs(int start, int cur, int sum, int cnt) {

		if(result<sum)
		{
			return;
		}

		// N개의 도시를 들렸고, 처음 도시까지 갔을 경우
		if(cnt==N && cur==start)
		{
			if(result>sum)
			{
				result = sum;
				return;
			}
		}

		for (int i = 0; i < N; i++)
		{
			// 방문하지않았고, 0이 아닌 경우(0은 들릴 수 없는 경우)
			if(!visited[cur] && ad[cur][i] != 0)
			{
				// 방문 표시
				visited[cur] = true;

				// 최단이라면
				if(result>=sum+ad[cur][i])
				{
					dfs(start, i, sum+ad[cur][i], cnt+1);
				}

				// 초기화
				visited[cur] = false;
			}
		}

	}

}