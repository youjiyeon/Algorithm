import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_20040_Main {

	public static int n, m, answer;
	public static int[] parent;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		answer = 0;
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parent = new int[n];

		for (int j = 0; j < n; j++) {
			parent[j] = j;
		}

		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if(find(a) == find(b)){
				answer = i;
				break;
			}
			union(a, b);
		}
		System.out.println(answer);
	}

	public static void union(int x, int y) {
		x = find(x); //x의 부모노드 찾기
		y = find(y); //y의 부모노드 찾기

		if(x <= y) parent[y] = x;
		else parent[x] = y;
	}

	public static int find(int x) {
		if(parent[x] == x) return x;
		return find(parent[x]);
	}
}
