import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ_15665_Main {
	public static int N, M;
	public static int[] arr, pick;
	public static Set<String> set = new LinkedHashSet<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		pick = new int[M];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		per(0);

		for (String str:set) {
			System.out.println(str);
		}
	}

	public static void per(int cnt){
		if(cnt == M){
			String str = "";
			for (int i:	pick) {
				str+=i+" ";
			}
			set.add(str);
			return;
		}

		for (int i = 0; i < N; i++) {
			pick[cnt] = arr[i];
			per(cnt+1);
		}
	}
}
