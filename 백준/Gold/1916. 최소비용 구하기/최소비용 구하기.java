import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static class Node{
		int idx;
		int cost;

		public Node(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
	}
	public static int N, E, start, end;
	public static int[] dist;
	public static List<Node>[] lists;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());

		// 초기화
		lists = new List[N+1];
		for (int i = 1; i <= N; i++) {
			lists[i] = new ArrayList<Node>();
		}

		dist = new int[N+1];
		for (int i = 1; i <= N ; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		//

		// 입력
		for (int i = 1; i <= E ; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			lists[s].add(new Node(e,c));
		}

		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		//

		// dijstra
		System.out.println(dijstra(start, end));
	}

	public static int dijstra(int start, int end){
		PriorityQueue<Node> q = new PriorityQueue<Node>((o1,o2) -> o1.cost - o2.cost);
		q.offer(new Node(start,0));
		dist[start] = 0;

		while (!q.isEmpty()){
			Node cur = q.poll();

			if(dist[cur.idx] < cur.cost){
				continue;
			}

			for (Node next:	lists[cur.idx]) {
				if(dist[next.idx] > cur.cost + next.cost){
					dist[next.idx] = cur.cost + next.cost;
					q.offer(new Node(next.idx, dist[next.idx]));
				}
			}
		}

		return dist[end];
	}

}