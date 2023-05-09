import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ_15663_Main {

	public static int N, M;
	public static Set<String> set = new LinkedHashSet<>();
	public static int[] pick, arr;
	public static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		pick = new int[M];
		visit = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int val = Integer.parseInt(st.nextToken());
			arr[i] = val;
		}
		Arrays.sort(arr);
		combi_15663(0);
		for (String s: set) {
			System.out.println(s);
		}
	}

	private static void combi_15663(int cnt) {

		if(cnt == M){
			String str = "";
			for (int i:	pick) {
				str += i+" ";
			}
			set.add(str);
			return;
		}


		for (int i = 0; i < N; i++) {
			if(visit[i]) continue;
			{
				pick[cnt] = arr[i];
				visit[i] = true;
				combi_15663(cnt + 1);
				visit[i] = false;
			}
		}
	}
}
