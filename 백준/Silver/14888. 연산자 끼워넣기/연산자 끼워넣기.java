import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	static int[] pick;
	static int[] number;
	// + - * /
	static int[] operator = new int[4];
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		number = new int[N];
		pick = new int[N-1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) 
		{
			number[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) 
		{
			operator[i] = Integer.parseInt(st.nextToken());
		}
		
		perm(0);
		System.out.println(max);
		System.out.println(min);
	}
	
	private static void perm(int cnt) {

		if(cnt==N-1)
		{
			// 조합 완성
			// 계산
			
			int temp = calc(pick);
			min = Math.min(temp, min);
			max = Math.max(temp, max);
			//System.out.println(Arrays.toString(pick));
			return;
		}
		
		for (int i = 0; i < 4; i++) 
		{
			if(operator[i]!=0)
			{
				operator[i]--;
				pick[cnt] = i;
				perm(cnt+1);
				operator[i]++;
			}
		}
	}

	private static int calc(int[] arr) {

		int sum = number[0];
		for (int i = 0; i < N-1; i++) 
		{
			switch (arr[i]) {
			case 0:
				sum+=number[i+1];
				break;
			case 1:
				sum-=number[i+1];
				break;
			case 2:
				sum*=number[i+1];
				break;
			case 3:
				sum/=number[i+1];
				break;
			default:
				break;
			}
		}
		
		return sum;
	}

}