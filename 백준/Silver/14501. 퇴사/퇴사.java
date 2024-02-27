import java.io.*;
import java.util.*;

public class Main {

	static int N, result = Integer.MIN_VALUE;
	static int[][] schedule;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		schedule = new int[N][2];
		
		for (int i = 0; i < N; i++) 
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 상담 완료 시간
			schedule[i][0] = Integer.parseInt(st.nextToken());
			// 상담비
			schedule[i][1] = Integer.parseInt(st.nextToken());
		}
		
		setting(0,0);
		System.out.println(result);
	}
	
	private static void setting(int time, int val) 
	{
		//System.out.println(time+" "+val);
		if(time>N)
		{
			return;
		}
		result = Math.max(val, result);
		for (int i = time; i < N; i++) 
		{
			setting(i+schedule[i][0], val+schedule[i][1]);
		}
	}

}
