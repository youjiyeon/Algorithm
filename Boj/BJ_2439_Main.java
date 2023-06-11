import java.io.*;
import java.util.StringTokenizer;


public class BJ_2439_Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] input = new int[N];
		int[] maxidx = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) 
		{
			input[i] =  Integer.parseInt(st.nextToken());
		}
		
		
		for (int i = N-1; i >= 1; i--) 
		{
			int j = i-1;
			while(j>=0 && input[i]>=input[j])
			{
				j--;
			}
			
			if(j == -1) continue;
			else maxidx[i] = j+1;
		}
		
		for (int i = 0; i < maxidx.length; i++) 
		{
			sb.append(maxidx[i]).append(" ");
		}
		
		System.out.println(sb);

	}

}
