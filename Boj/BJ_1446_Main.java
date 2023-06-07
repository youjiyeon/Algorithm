import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_1446_Main {
	public static class Node{
		int idx;
		int cost;

		public Node(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
	}

	public static int N, D;
	public static int[] dist;
	public static int[] target;
	public static List<Node>[] lists;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		lists = new List[10001];
		for (int i = 0; i <= 10000; i++) {
			lists[i] = new ArrayList<>();
		}

		dist = new int[10001];
		for (int i = 0; i <= 10000 ; i++) {
			dist[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			// 기존 길보다 빠를 때만 저장
			if(e-s>c){
				lists[e].add(new Node(s,c));
			}
		}

		System.out.println(dijstar(0, D));
	}

	public static int dijstar(int start, int end) {
		dist[start] = 0;

		// D까지 달려어ㅓㅓ!!!!!!!!!!
		for (int j = 1; j <= D; j++) {

			// 지름길이 존재하는 경우
			if (lists[j].size()>0){
				for (Node next:	lists[j]) {
					if(dist[next.idx]+ next.cost > dist[j]) continue;
					dist[j] = Math.min(dist[j-1]+1,dist[next.idx]+next.cost);
				}
				continue;
			}
			dist[j] = dist[j-1]+1;
		}

		return dist[end];
	}
}
