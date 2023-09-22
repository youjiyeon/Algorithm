import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

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
		StringTokenizer st;
		min = 0;
		N = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
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
			//graph.get(e).add(new Node(s, c));
		}

		st = new StringTokenizer(br.readLine());
		mustA = Integer.parseInt(st.nextToken());
		mustB = Integer.parseInt(st.nextToken());

		//System.out.println(mustA + " " + mustB);
		dist = new int[N + 1]; // 최소 비용을 저장할 배열
		for (int i = 0; i < N + 1; i++) {
			dist[i] = Integer.MAX_VALUE;
		}

		min = dijkstra(mustA, mustB);
		//min += dist[mustA];

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

			// if(!visit[cur.idx]) {
			// 	visit[cur.idx] = true;
			if (dist[cur.idx] < cur.cost) {
				continue;
			}

			for (int i = 0; i < graph.get(cur.idx).size(); i++) {
				Node nxtNode = graph.get(cur.idx).get(i);
				if (dist[nxtNode.idx] > cur.cost + nxtNode.cost) {
					dist[nxtNode.idx] = cur.cost + nxtNode.cost;
					q.offer(new Node(nxtNode.idx, dist[nxtNode.idx]));
					//System.out.println(nxtNode.idx+" "+dist[nxtNode.idx]);
				}
			}
			//}
		}

		return dist[end];
	}
}