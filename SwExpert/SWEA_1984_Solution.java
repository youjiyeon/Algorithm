import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_1984_Solution {


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			int N = 10;
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			int sum = 0;
			int avg = 0;
			int[] arr = new int[N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
				sum += arr[j];
				min = Math.min(min, arr[j]);
				max = Math.max(max, arr[j]);
			}
			sum -= (min+max);
			avg = Math.round(sum/(float)8);
			System.out.printf("#%d %d%n", i, avg);
		}
	}
}
