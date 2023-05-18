import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15652_Main {

	public static int N, M;
	public static int[] pick;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		pick = new int[M];
		// 조합
		combi_15652(0,1);
	}

	private static void combi_15652(int cnt, int start) {

		if(cnt>=M){
			for (int i : pick) {
				System.out.print(i+" ");
			}
			System.out.println();
			return;
		}
		for (int i = start; i <= N; i++) {
			pick[cnt] = i;
			combi_15652(cnt+1,i);
		}
	}
}
