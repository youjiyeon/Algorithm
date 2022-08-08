package day0808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_9229_한빈이와SpotMart_유지연 {


	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) 
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // bag num
			int M = Integer.parseInt(st.nextToken()); // max weight
			int max = -1;
			int[] bags = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) 
			{
				bags[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < N; i++) 
			{
				for (int j = 0; j < N; j++) 
				{
					if ( i == j )
						continue;
					else if (bags[i]>=M || bags[j]>=M || bags[i]+bags[j]>M)
					{
						continue;
					}
					else
					{
						max = bags[i]+bags[j] > max ? bags[i]+bags[j] : max;
					}
				}
			}
			
			System.out.println("#"+t+" "+max);
			

		}
	}
	

}
