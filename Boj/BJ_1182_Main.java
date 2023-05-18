import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_1182_Main {

	public static int N, S, result;
	public static int[] arr;
	public static boolean[] pick;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		pick = new boolean[N];
		result = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		powerSet(0);
		if (S==0) result--;
		System.out.println(result);
	}

	static void powerSet(int cnt) {

		if(cnt == N)
		{
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if(pick[i])
					sum+=arr[i];
			}

			if(sum == S)
			{
				result++;
			}
			return;
		}

		pick[cnt]=true;
		powerSet(cnt+1);
		pick[cnt]=false;
		powerSet(cnt+1);
	}
}
