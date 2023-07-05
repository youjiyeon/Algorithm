
import java.io.*;
import java.util.*;

public class Main {

	static int N, M, V;
	static boolean[] visit;
	static int[][] graph;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		visit = new boolean[N+1];
		graph = new int[N+1][N+1];
		for (int i = 0; i < M; i++) 
		{
			st = new StringTokenizer(br.readLine());
			
			int in1 = Integer.parseInt(st.nextToken());
			int in2 = Integer.parseInt(st.nextToken());
			graph[in1][in2] = graph[in2][in1] = 1; // 양방향
		}
		
		visit[V] = true;
		
		dfs(V);
		
		System.out.println();
		//visit = new boolean[M];

		bfs(V);
	}

	static void dfs(int start) {
		
		System.out.print(start+" ");
		for (int i = 1; i <= N; i++) 
		{
			if(!visit[i] && graph[start][i] != 0)
			{
				visit[i] = true;
				dfs(i);
			}
		}
		
	}
	
	static void bfs(int start)
	{
		Queue<Integer> queue = new LinkedList<>();
		Arrays.fill(visit, false);
		queue.offer(start);
		visit[start] = true;

		while (!queue.isEmpty())
		{
			start = queue.poll();

			//cout << start << " ";
			System.out.print(start+" ");

			for (int i = 1; i <= N; i++)
			{
				if (!visit[i] && graph[start][i] != 0)
				{
					visit[i] = true;
					queue.offer(i);
				}
			}
		}
	}

}
