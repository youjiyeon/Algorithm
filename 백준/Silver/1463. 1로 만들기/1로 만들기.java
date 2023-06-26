

import java.io.*;

public class Main {

	static int[] DP = new int[1000001];
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 2; i <= N; i++) 
		{
			DP[i] = DP[i-1]+1;
			
			// 3으로 나눠진다
			if (i % 3 == 0) 
			{
				DP[i] = Math.min(DP[i], DP[i/3]+1);
			} 
			// 2로 나눠진다
			if (i % 2 == 0) 
			{
				DP[i] = Math.min(DP[i], DP[i/2]+1);
			}
		}
		
		System.out.println(DP[N]);
	}

}
