import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1504_Main {

	public static class Node {
		int idx, cost;

		Node(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
	}

	public static int N, E, mustA, mustB, min;
	public static int[] dist;
	public static boolean[] visit;
	public static ArrayList<ArrayList<Node>> graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		min = 0;
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		visit = new boolean[N+1];

		graph = new ArrayList<ArrayList<Node>>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<Node>());
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			graph.get(s).add(new Node(e, c));
			graph.get(e).add(new Node(s, c));
		}

		st = new StringTokenizer(br.readLine());
		mustA = Integer.parseInt(st.nextToken());
		mustB = Integer.parseInt(st.nextToken());

		dist = new int[N + 1]; // 최소 비용을 저장할 배열
		for (int i = 0; i < N + 1; i++) {
			dist[i] = Integer.MAX_VALUE;
		}

		long r1 = 0;
		r1 += dijkstra(1, mustA);
		r1 += dijkstra(mustA, mustB);
		r1 += dijkstra(mustB, N);

		long r2 = 0;
		r2 += dijkstra(1, mustB);
		r2 += dijkstra(mustB, mustA);
		r2 += dijkstra(mustA, N);


		min = (r1 >= Integer.MAX_VALUE && r2 >= Integer.MAX_VALUE) ? -1 : (int)Math.min(r1, r2);
		System.out.println(min);
	}

	public static int dijkstra(int start, int end){
		Arrays.fill(dist, Integer.MAX_VALUE);
		Arrays.fill(visit, false);

		PriorityQueue<Node> q = new PriorityQueue<Node>(Comparator.comparingInt(o -> o.cost));
		q.offer(new Node(start, 0));
		dist[start] = 0;
		
		while (!q.isEmpty()){
			Node cur = q.poll();
			
			if(!visit[cur.idx]) {
				visit[cur.idx] = true;
				for (int i = 0; i < graph.get(cur.idx).size(); i++) {
					Node nxtNode = graph.get(cur.idx).get(i);
					if (!visit[nxtNode.idx] && dist[nxtNode.idx] > dist[cur.idx] + nxtNode.cost) {
						dist[nxtNode.idx] = dist[cur.idx] + nxtNode.cost;
						q.offer(new Node(nxtNode.idx, dist[nxtNode.idx]));
					}
				}
			}
		}

		return dist[end];
	}
}
