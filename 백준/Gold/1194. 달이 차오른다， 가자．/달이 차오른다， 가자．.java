import java.io.*;
import java.util.*;

public class Main {
	static int R, C, startX, startY, level;
	static boolean flag;
	static char[][] map;
	
	static boolean[] key;
	static boolean[][][] visited;
	static int[][] way = {{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		flag = false;
		key = new boolean[6];
		map = new char[R][C];
		visited = new boolean[R][C][64];
		
		for (int r = 0; r < R; r++) {
			String str = br.readLine();
			for (int c = 0; c < C; c++) {
				map[r][c] = str.charAt(c);
				if(map[r][c] == '0') {
					startX = r;
					startY = c;
				}
			}
		}
		
		bfs();
	}

	static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {startX, startY, 0});
		visited[startX][startY][0] = true;
		map[startX][startY] = '.';
		
		while(!q.isEmpty())
		{
			int size = q.size();
			
			for (int i = 0; i < size; i++) {
				int[] cur = q.poll();
				int cx = cur[0];
				int cy = cur[1];
				int cKey = cur[2];
				if (map[cx][cy]=='1') {
					System.out.println(level);
					return;
				}
				
				for (int j = 0; j < 4; j++) {
					int nx = cur[0]+way[j][0];
					int ny = cur[1]+way[j][1];
					
					if (isRight(nx,ny) && !visited[nx][ny][cKey] && map[nx][ny] != '#') {
						// 열쇠
						if (map[nx][ny]>='a' && map[nx][ny]<='f') {
							visited[nx][ny][ cKey | 1<<(map[nx][ny]-'a') ] = true;
							q.offer(new int[] {nx, ny, cKey | 1<<(map[nx][ny]-'a')});
						}
						// 문
						if(map[nx][ny]>='A' && map[nx][ny]<='F') {
							if((cKey & 1<<(map[nx][ny]-'a')) != 0) {
								visited[nx][ny][ cKey ] = true;
								q.offer(new int[] {nx, ny, cKey});
							}
						}
						else {
							visited[nx][ny][cKey] = true;
							q.offer(new int[] {nx, ny, cKey});
						}
					}
				}
			}	
			level++;
		}
		System.out.println(-1);
	}

	private static boolean isRight(int nx, int ny) {
		if (nx>=0 && nx<R && ny>=0 && ny<C)
			return true;
		return false;
	}

}