import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_18405_Main {

	public static int N, K, S, X, Y;
	public static int[][] map;
	static int[][] way = {{-1,0},{1,0},{0,-1},{0,1}};
	static Queue<Node> q = new LinkedList<>();

	static class Node{
		int x;
		int y;
		int virus;
		int time;

		public Node(int x, int y, int virus, int time) {
			this.x = x;
			this.y = y;
			this.virus = virus;
			this.time = time;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		ArrayList<Node> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] != 0)
				{
					list.add(new Node(i,j,map[i][j],0));
				}
			}
		}

		Collections.sort(list, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.virus - o2.virus;
			}
		});

		for (Node node : list) {
			q.add(node);
		}

		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());

		bfs();

		System.out.println(map[X-1][Y-1]);
	}

	public static void bfs(){

		while(!q.isEmpty()) {
			Node node = q.poll();
			int virusX = node.x;
			int virusY = node.y;

			if (node.time == S) {
				return;
			}
			// 4방으로 퍼트리기
			for (int i = 0; i < 4; i++) {
				int vx = virusX + way[i][0];
				int vy = virusY + way[i][1];

				if (!isRight(vx, vy))
					continue;
				if (map[vx][vy] == 0)
				{
					map[vx][vy] = node.virus;
					q.offer(new Node(vx, vy, node.virus, node.time+1));
				}
			}
		}
	}

	// 경계 체크 함수
	private static boolean isRight(int x, int y) {
		return (x>=0 && x<N && y>=0 && y<N);
	}
}
