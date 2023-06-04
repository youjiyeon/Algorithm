import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_11725_Main {
	
	public static int N;
	public static boolean[] visit;
	public static int[] result;
	public static List[] lists;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		lists = new List[N+1];
		visit = new boolean[N+1];
		result = new int[N+1];

		for (int i = 0; i <= N; i++) {
			lists[i] = new ArrayList<Integer>();
		}
		for (int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 상위
			int n = Integer.parseInt(st.nextToken());
			// 하위
			int m = Integer.parseInt(st.nextToken());

			lists[m].add(n);
			lists[n].add(m);
		}

		for (int i = 1; i <= N; i++) {
			visit[1] = true;
			dfs(1);
		}

		for (int i = 2; i <= N; i++) {
			System.out.println(result[i]);
		}
	}

	public static void dfs(int start){
		for (int i = 0; i < lists[start].size(); i++) {
			if(!visit[(int)lists[start].get(i)]){
				visit[(int)lists[start].get(i)] = true;
				result[(int)lists[start].get(i)] = start;
				dfs((int)lists[start].get(i));
			}
		}
	}
}
