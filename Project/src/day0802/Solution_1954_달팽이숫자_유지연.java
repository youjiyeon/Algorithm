package day0802;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1954_달팽이숫자_유지연 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int[][] way = {{0,1},{1,0},{0,-1},{-1,0}}; // 우, 하, 좌, 상 

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());	
		
		for(int t = 1; t<=testcase; t++)
		{
			int N = Integer.parseInt(br.readLine());
			
			int[][] arr = new int[N][N];
			int x=0;
			int y=0;
			int change = 0;
			
			for(int i=1; i<=N*N;)
			{
				// 경계 체크
				if(x<N && x>=0 && y<N && y>=0)
				{
					// 이미 다른 값이 있다면? -> reset
					if(arr[x][y]!=0)
					{
						x-=way[change][0];
						y-=way[change][1];
						change++;
						if(change > 3)
							change=0;
					}
					else
					{
						arr[x][y] = i;
						i++;
					}
				}
				// 경계를 넘었다면? -> reset
				else
				{
					x-=way[change][0];
					y-=way[change][1];
					change++;
					if(change > 3)
						change=0;
				}
				
				x+=way[change][0];
				y+=way[change][1];
			}
			
			// 출력
			System.out.printf("#%d%n",t);
			for(int i=0; i<N; i++)
			{
				for(int j=0; j<N; j++)
				{
					System.out.printf("%d ",arr[i][j]);
				}
				System.out.println();
			}
		}

	}

}