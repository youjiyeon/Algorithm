

import java.io.*;
import java.util.*;

public class Main {

	static int V, E;
	static int cnt;
	static long result = 0;
	static int[] num;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		num = new int[V+1];
		arr = new int[E][3]; //0 from, 1 to, 2 weight
		
		for (int i = 0; i < E; i++) 
		{
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			arr[i][0] = from;
			arr[i][1] = to;
			arr[i][2] = weight;
		}
		
		for (int i = 1; i <= V; i++) 
		{
			num[i] = i;
		}
		Arrays.sort(arr, (a,b) -> {
			return a[2] - b[2];
		});
/*		
		for (int i = 1; i <= V; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}*/

		for (int i = 0; i < E; i++) 
		{
			int[] current = arr[i];
			if(FindSet(current[0]) == FindSet(current[1])) continue;
			
			
			Union(current[0],current[1]);
			result += current[2];
			cnt++;
			if(cnt == V-1)
				break;
			

		}
		System.out.println(result);
	}
	private static void Union(int i, int j) {
		
		if(FindSet(i) == FindSet(j))
			return;
		else
			num[FindSet(i)] = FindSet(j);
		
	}
	private static int FindSet(int i) {
		
		if(num[i] == i)
			return i;
		else
			return num[i] = FindSet(num[i]);
	}

}
