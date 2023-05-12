import java.util.*;
class PGM_네트워크_Solution {

	public static int N;
	public static int[][] nodes;
	public static boolean[] visit;
	public int solution(int n, int[][] computers) {
		// 양배추같은 문제
		// 인접행렬 문제
		// 각 노드마다 간선이 이어져있는 지 찾고 쭉 가다가 끊기면 ++
		// bfs & dfs
		N = computers.length;
		nodes = computers;
		visit = new boolean[N];
		int answer = 0;

		for(int i = 0; i < N; i++){
			if(!visit[i]){
				//bfs(i);
				dfs(i);
				answer++;
			}
		}

		return answer;
	}

	public void bfs(int node){
		Queue<Integer> q = new LinkedList<>();
		q.offer(node);

		while(!q.isEmpty()){
			int current = q.poll();
			visit[current] = true;
			for(int i=0; i<N; i++){

				if(!visit[i] && nodes[current][i]==1){
					q.offer(i);
				}
			}
		}
	}

	public void dfs(int node){
		visit[node] = true;

		for(int i=0; i<N; i++){

			if(!visit[i] && nodes[node][i]==1){
				dfs(i);
			}
		}
	}
}