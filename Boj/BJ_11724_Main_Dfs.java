

import java.io.*;
import java.util.*;

public class BJ_11724_Main_Dfs {

	static int N, M, V, cnt;
	static boolean[] visit;
	static List<Integer>[] graph;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		cnt = 0;
		visit = new boolean[N+1];
		graph = new List[N+1];
		
		for (int i = 1; i <= N; i++) 
		{
			graph[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < M; i++) 
		{
			st = new StringTokenizer(br.readLine());
			
			int in1 = Integer.parseInt(st.nextToken());
			int in2 = Integer.parseInt(st.nextToken());
			graph[in1].add(in2);
			graph[in2].add(in1); // 양방향
		}

		for (int j = 1; j <= N; j++) 
		{
			if(!visit[j])
			{
				dfs(j);
				cnt++;
			}	
		}
		System.out.println(cnt);
		
	}

	static void dfs(int start) {
		
		for(int to : graph[start]) 
		{
			if(!visit[to])
			{
				visit[to] = true;
				dfs(to);
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
			System.out.print(start+" ");

			for(int to : graph[start]) 
			{
				if(!visit[to])
				{
					visit[to] = true;
					queue.offer(to);
				}
				
			}

		}
	}

}
