

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int arrNum = Integer.parseInt(st.nextToken());
		int testcase = Integer.parseInt(st.nextToken());
		int[][] sum = new int[arrNum+1][arrNum+1];
		
		for(int i=1; i<=arrNum; i++) 
		{ 
			StringTokenizer sArr = new StringTokenizer(br.readLine());
			for(int j=1; j<=arrNum; j++) 
				sum[i][j] = sum[i][j-1]+Integer.parseInt(sArr.nextToken());
		}
		
		while(testcase-- > 0)
		{
			int result = 0;
			StringTokenizer test = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(test.nextToken());
			int y1 = Integer.parseInt(test.nextToken());
			
			int x2 = Integer.parseInt(test.nextToken());
			int y2 = Integer.parseInt(test.nextToken());
			
			for(int x=x1; x<=x2; x++)
				result += sum[x][y2] - sum[x][y1 - 1];
			sb.append(result).append('\n');
		}
		System.out.println(sb);
	}

}

