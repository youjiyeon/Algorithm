import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_15656_Main {

	public static int N, M;
	public static int[] pick;
	public static int[] arr;
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
		combi_15656(0);
		System.out.print(sb);
	}

	private static void combi_15656(int cnt) {

		if(cnt==M){
			for (int i:	pick) {
				sb.append(i+" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {

			pick[cnt] = arr[i];
			combi_15656(cnt+1);
		}
	}
}
