import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class combi {

	public static int N, R;
	public static int[] map, pick;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N];
		pick = new int[R];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}

		com(0, 0);
	}

	static void com(int cnt, int start) {

		if(cnt == R)
		{
			System.out.println(Arrays.toString(pick));
			return;
		}

		for (int i = start; i < N; i++) {
			pick[cnt] = map[i];
			com(cnt+1, i+1);
		}
	}
}
