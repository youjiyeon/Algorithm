import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_15657_Main {

	public static int N, M;
	public static int[] arr, pick;
	public static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		pick = new int[M];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		combi_15657(0,0);
		System.out.println(sb);
	}

	private static void combi_15657(int cnt, int start) {

		if (cnt == M){

			for (int i: pick) {
				sb.append(i+" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			if(i>=start) {
				pick[cnt] = arr[i];
				combi_15657(cnt + 1, i);
			}
		}
	}
}
