import java.io.*;
import java.util.*;

/*
 * 치킨집의 조합
 * 1: 집
 * 2: 치킨집
 * 각 집마다의 치킨거리 구하기
 */


public class Main {

	static int N, M, result = Integer.MAX_VALUE;
	static int[][] map;
	static int[][] pick;
	static List<int[]> house = new ArrayList<>();
	static List<int[]> chicken = new ArrayList<>();
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		pick = new int[M][2];
		for (int i = 0; i < N; i++) 
		{
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) 
			{
				map[i][j] = Integer.parseInt(st.nextToken());
				// 집 리스트 추가
				if(map[i][j] == 1)
					house.add(new int[] {i,j});
				// 치킨집 리스트 추가
				if(map[i][j] == 2)
					chicken.add(new int[] {i,j});
			}
		}
		
		
		// 치킨집 조합
		combi(0, 0);

		
		System.out.println(result);
	}
	
	private static void combi(int cnt, int start) {
		
		// 기저 조건
		if(cnt==M)
		{
			// 각 집마다 치킨 거리 구하기
			int temp = houseDis();
			// 가장 작은 도시의 치킨 거리
			result = Math.min(temp, result);
			return;
		}
		for (int i = start; i < chicken.size(); i++) 
		{
			pick[cnt][0] = chicken.get(i)[0];
			pick[cnt][1] = chicken.get(i)[1];
			combi(cnt+1, i+1);
		}
	}

	private static int houseDis() {

		int sum = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < house.size(); i++) 
		{
			min = Integer.MAX_VALUE;
			for (int j = 0; j < M; j++) 
			{
				int temp = Math.abs(house.get(i)[0]-pick[j][0])+
						Math.abs(house.get(i)[1]-pick[j][1]);
				min = Math.min(temp, min);
			}
			sum+=min;
		}
		
		return sum;
	}

}
