
import java.io.*; 
import java.util.*;


public class BJ_2178_Main {
	
	static int M;
	static int N;
	static int K;
	
	// 상하좌우
	static int[][] way = {{-1,0},{1,0},{0,-1},{0,1}};
	static int[][] table;
	static int[][] check;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 세로 길이
		M = Integer.parseInt(st.nextToken()); // 가로 길이
		
		
		table = new int[N][M];
		check = new int[N][M];
		

		for (int i = 0; i < N; i++) 
		{
			String input = br.readLine();
			for (int j = 0; j < M; j++) 
			{
				//System.out.print(input.charAt(j)-'0');
				table[i][j] = input.charAt(j)-'0';
			}
			//System.out.println();
		}
	
		bfs(0,0);
		System.out.println(check[N-1][M-1]);
		
/*		for (int i = 0; i < N; i++) 
		{
			for (int j = 0; j < M; j++) 
			{
				System.out.print(table[i][j]+" ");
			}
			System.out.println();
		}*/
	}
	
	public static void bfs(int x, int y)
	{
		Queue<int[]> queue = new LinkedList<int[]>();
		//queue<pair<int, int>> q;
		queue.add(new int[] {x, y});
		//System.out.println(Arrays.toString(queue.peek()));
		check[x][y] = 1;

		while (!queue.isEmpty())
		{
			int xy[] = queue.peek();
			
			x = xy[0];
			y = xy[1];
			queue.poll();

			int nx = 0;
			int my = 0;
			for (int i = 0; i < 4; i++)
			{
				nx = way[i][0] + x;
				my = way[i][1] + y;
				if (0 <= nx && nx < N && 0 <= my && my < M)
				{
					if (check[nx][my] == 0 && table[nx][my] == 1)
					{
						queue.add(new int[] {nx, my});
						check[nx][my] = check[x][y]+1;
					}
					else if (check[nx][my] == 0)
					{
						check[nx][my] = -1;
					}
				}
			}
		}
	}

}
