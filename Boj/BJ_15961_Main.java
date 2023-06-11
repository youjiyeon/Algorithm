

import java.io.*;
import java.util.*;

public class BJ_15961_Main {

	static int[] arr; 
	static int[] count;
	
	static int N; 
	static int C;
	static int Window;
	static int coupon; 
	static int max = Integer.MIN_VALUE;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		Window = Integer.parseInt(st.nextToken());
		coupon = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		count = new int[C+1];
		
		for (int i = 0; i < N; i++) 
		{
			arr[i] = Integer.parseInt(br.readLine());
		}
		test(Window);


	}
	
	public static void test(int n) throws IOException {
		
		int cnt = 0;
		
		// 초기
		for (int i = 0; i < n; i++) 
		{
			if(count[arr[i]]++==0)
				cnt++;
		}

		max = cnt;

		for (int i = 1; i < N+1; i++) 
		{
			// 맨 앞 제거
			if(--count[arr[i-1]] == 0)
				cnt--;
			
			// 맨 마지막 중복 확인
			if(count[arr[(i+n-1)%N]]++ == 0) cnt++;
			
			// 쿠폰 확인
			if(count[coupon] == 0 && cnt+1>max)
			{
				max = cnt+1;
			}
			// max 갱신
			max = max<cnt ? cnt : max;
		}
		bw.write(String.valueOf(max));
		bw.flush();
		bw.close();
	}

}
