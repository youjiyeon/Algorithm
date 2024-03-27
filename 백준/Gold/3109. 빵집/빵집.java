
import java.io.*;
import java.util.*;

public class Main {

	static int R; // 행
	static int C; // 열
	static int cnt = 0;
	static boolean flag;
	static char[][] map;
	static int[][] way = {{-1,1},{0,1},{1,1}}; // 우상, 우, 우하
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		for (int i = 0; i < R; i++) 
		{
			String str = br.readLine();
			
			for (int j = 0; j < C; j++) 
			{
				map[i][j] = str.charAt(j);
			}
		}
		
		for (int i = 0; i < R; i++) 
		{
			// 행의 값만 받아서 각 행의 첫번째 열에서 돌리기
			// 근처 빵집에서 시작
			if(dfs(i,0)) cnt++;
			//flag = false;
		}
		System.out.println(cnt);

	}
	
	private static boolean dfs(int r, int c) 
	{
		map[r][c] = 'x';
		int tempR = r;
		int tempC = c;
		
		for (int i = 0; i < 3; i++) 
		{
			tempR = r + way[i][0];
			tempC = c + way[i][1];

			// 경계안에 있고 x가 아니라면
			if(tempR>=0 && tempR<R && tempC>=0 && tempC<C && map[tempR][tempC] != 'x') 
			{
				//map[tempR][tempC] = 'x';
				//System.out.println(tempR+" "+tempC);
				
				// 마지막 열에 도착한다면
				if(tempC == C-1)
				{
					return true;
				}
				
				
				if(dfs(tempR, tempC)) return true;
			}
		}
		
		return false;
	}
	
	

}
