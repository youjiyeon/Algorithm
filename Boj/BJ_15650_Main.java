import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15650_Main {

	public static int N, M;
	public static int[] pick;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		pick = new int[M];

		com(0);
		System.out.println(sb);
	}

	static void com(int cnt){

		if(cnt == M){

			for (int i: pick) {
				sb.append(i+" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= N; i++) {
			pick[cnt] = i;
			com(cnt+1);
		}
	}
}
