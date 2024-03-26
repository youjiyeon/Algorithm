
import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int max = 1;
	static boolean[] visit; // 알파벳만큼 생성
	static char[][] graph;
	static int [][] deltas = {{-1, 0},{1, 0},{0, -1},{0, 1}};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visit = new boolean[26]; // 0: A
		graph = new char[N+1][M+1];
		for (int i = 1; i <= N; i++) 
		{
			String str = br.readLine();
			for (int j = 1; j <= M; j++) 
			{
				graph[i][j] = str.charAt(j-1);
			}
		}
		
		//visit[graph[1][1]-65] = true; // 시작점
		
/*		// graph 확인
		for (int i = 1; i <= N; i++) 
		{
			for (int j = 1; j <= M; j++) 
			{
				System.out.print(graph[i][j]+" ");
			}
			System.out.println();
		}*/
		
/*		// 알파벳 visit 확인
		for (int i = 0; i < visit.length; i++) 
		{
			System.out.print(visit[i]+" ");
		}*/
		
		dfs(1,1,visit,1);
		System.out.println(max);
		
	}
	
    static void dfs(int r, int c, boolean[] visit, int cnt) {
        
    	// 사용하기 - 그 노드에 방문했을 때 무슨 일을 할 것인가? (ex: 방문처리)
       
    	visit[graph[r][c]-65] = true;
    	
        // 자식 노드 탐색
        for(int d=0; d<deltas.length; d++) {
            int nr = r + deltas[d][0];
            int nc = c + deltas[d][1]; // 2차원 배열의 새로운지점 - 범위!

            // 범위 안에 있고 방문 가능한 지점이고 아직 미방문이면 가자!!
            if(nr>=1 && nr<N+1 && nc>=1 && nc <M+1)
            {
            	//System.out.printf("%d, %d = %d cnt: %d%n",nr,nc,graph[nr][nc]-65,cnt);
            	if(!visit[graph[nr][nc]-65])
	            {
            		
	                max = max<cnt+1 ? cnt+1 : max;
	                    
	                //System.out.printf("%d, %d = %d cnt: %d%n",nr,nc,graph[nr][nc]-65,cnt+1);
/*	        		for (int i = 0; i < visit.length; i++) 
	        		{
	        			System.out.print(visit[i]+" ");
	        		}
	        		System.out.println();*/
	                dfs(nr, nc, visit,cnt+1);
            	}
            }
        }
        
        visit[graph[r][c]-65] = false;
    }

}
