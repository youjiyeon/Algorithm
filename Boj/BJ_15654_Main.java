import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_15654_Main {
	public static int N, M;
	public static List<Integer> list;
	public static int[] pick;
	public static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		pick = new int[M];
		visit = new boolean[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}

		// 오름차순 정렬
		Collections.sort(list);

		// 조합
		combi_15654(0);

	}

	private static void combi_15654(int cnt) {

		if(cnt==M){
			for (int i = 0; i < M; i++) {
				System.out.print(pick[i]+" ");
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < list.size(); i++) {
			if(!visit[i]) {
				pick[cnt] = list.get(i);
				visit[i] = true;
				combi_15654(cnt+1);
				visit[i] = false;
			}
		}
	}
}
